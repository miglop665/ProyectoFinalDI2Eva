package com.example.proyectofinaldi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistroActivity : AppCompatActivity() {
    private lateinit var CVimagenPerfil:CardView
    private lateinit var imagenPerfil: ImageView
    private lateinit var conjuntoFotos: GridLayout
    private lateinit var foto1:ImageView
    private lateinit var foto2:ImageView
    private lateinit var foto3:ImageView
    private lateinit var foto4:ImageView
    private lateinit var foto5:ImageView
    private lateinit var foto6:ImageView
    private lateinit var edtUser:EditText
    private lateinit var edtCorreo:EditText
    private lateinit var edtContraseña:EditText
    private lateinit var botonRegistrar: Button
    private lateinit var nombreFotoElegida :String

    private lateinit var auth: FirebaseAuth

    //login con firebase realtime
    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        conjuntoFotos=findViewById(R.id.conjuntoFotos)
        imagenPerfil=findViewById(R.id.imagenperfil)
        CVimagenPerfil=findViewById(R.id.cvimagenperfil)
        foto1=findViewById(R.id.foto1)
        foto2=findViewById(R.id.foto2)
        foto3=findViewById(R.id.foto3)
        foto4=findViewById(R.id.foto4)
        foto5=findViewById(R.id.foto5)
        foto6=findViewById(R.id.foto6)
        edtUser=findViewById(R.id.edtuser)
        edtCorreo=findViewById(R.id.edtcorreo)
        edtContraseña=findViewById(R.id.edtcontra)
        botonRegistrar=findViewById(R.id.botonregistrar)

        var imagenPerfilBase = imagenPerfil.drawable

        foto1.setOnClickListener {
            nombreFotoElegida="fotoperfil1"
            imagenPerfil.setImageDrawable(foto1.drawable)
            conjuntoFotos.visibility= View.GONE
            CVimagenPerfil.visibility=View.VISIBLE
        }
        foto2.setOnClickListener {
            nombreFotoElegida="fotoperfil2"
            imagenPerfil.setImageDrawable(foto2.drawable)
            conjuntoFotos.visibility= View.GONE
            CVimagenPerfil.visibility=View.VISIBLE
        }
        foto3.setOnClickListener {
            nombreFotoElegida="fotoperfil3"
            imagenPerfil.setImageDrawable(foto3.drawable)
            conjuntoFotos.visibility= View.GONE
            CVimagenPerfil.visibility=View.VISIBLE
        }
        foto4.setOnClickListener {
            nombreFotoElegida="fotoperfil4"
            imagenPerfil.setImageDrawable(foto4.drawable)
            conjuntoFotos.visibility= View.GONE
            CVimagenPerfil.visibility=View.VISIBLE
        }
        foto5.setOnClickListener {
            nombreFotoElegida="fotoperfil5"
            imagenPerfil.setImageDrawable(foto5.drawable)
            conjuntoFotos.visibility= View.GONE
            CVimagenPerfil.visibility=View.VISIBLE
        }
        foto6.setOnClickListener {
            nombreFotoElegida="fotoperfil6"
            imagenPerfil.setImageDrawable(foto6.drawable)
            conjuntoFotos.visibility= View.GONE
            CVimagenPerfil.visibility=View.VISIBLE
        }


        auth = FirebaseAuth.getInstance()


    //login con firebase realtime
    database = FirebaseDatabase.getInstance()

    databaseReference = database.getReference("Usuarios")


    botonRegistrar.setOnClickListener {
        if(edtUser.text.isNotBlank() && edtCorreo.text.isNotBlank() && edtContraseña.text.isNotBlank() && imagenPerfil.drawable!=imagenPerfilBase){
            auth.createUserWithEmailAndPassword(edtCorreo.text.toString(),edtContraseña.text.toString()).addOnCompleteListener{
                if (it.isSuccessful){

            //login con firebase realtime
                    val usuarioActual: FirebaseUser = auth.currentUser!!

                    val currentUserDb = databaseReference.child(usuarioActual.uid)

                    currentUserDb.child("foto").setValue(nombreFotoElegida)
                    currentUserDb.child("contraseña").setValue(edtContraseña.text.toString())
                    currentUserDb.child("correo").setValue(edtCorreo.text.toString())
                    currentUserDb.child("nombreUsuario").setValue(edtUser.text.toString())

                    val intent = Intent(this@RegistroActivity, LoginActivity::class.java)
                    startActivity(intent)

            }else{

                AlertDialog.Builder(this).apply {
                    setTitle("Error en el Registro")
                    var mensaje = ""

                    when(it.exception?.message.toString()){
                        "The email address is badly formatted."->{
                            mensaje="Formato del email incorrecto"
                        }
                        "The given password is invalid. [ Password should be at least 6 characters ]"->{
                            mensaje="La longitud minima de la contraseña debe ser 6"
                        }
                        "The email address is already in use by another account."->{
                            mensaje="La direccion de correo ya existe, redirigiendo al login..."
                        }
                        else->{
                            mensaje="Error - contacte con servicio tecnico [Codigo error - ~${it.exception?.message.toString()}"
                        }
                    }
                    setMessage(mensaje)
                    setPositiveButton("OK"){ _, _ ->
                        if(mensaje=="La direccion de correo ya existe, redirigiendo al login..."){
                            val intent = Intent(this@RegistroActivity, LoginActivity::class.java)
                            startActivity(intent)
                        }
                    }
                } .show()
            }
        }
    }else{
        if(imagenPerfil.drawable==imagenPerfilBase){
            Toast.makeText(this,"Seleccione una de las fotos de perfil", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Rellene todos los campos antes de intentar registrarse...", Toast.LENGTH_SHORT).show()
        }

    }

}

}
}