package com.example.proyectofinaldi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LoginActivity : AppCompatActivity() {
    //declaracion temprana de las variables que emplearemos con el tipo de lo que contendran
    private lateinit var edtUser:EditText
    private lateinit var edtCorreo:EditText
    private lateinit var edtContraseña:EditText
    private lateinit var botonEntrar: Button

    //declaracion temprana de la variable que nos permite realizar todos los parametros
    //de la conexion y manejo de la autentificacion en firebase
    private lateinit var auth: FirebaseAuth

    //declaracion temprana de una variable que contendra el acceso a  la BBDD de realtime de firebase
    //y a su vez declaracion de una variable que tenga la referencia en la que guardaremos el acceso
    // a un padre o hijo concreto de la BBDD
    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase


override fun onCreate(savedInstanceState: Bundle?) {

    //para que se duerma un poco y nos permita ver el logo original ya que nuestra app
    //no carga tantas cosas como para que de tiempo a que se vea lo suficiente por defecto
    Thread.sleep(2000) //2 segundos

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)


    //asignamos los valores del xml a lasa variables anteriormente creadas
    edtUser=findViewById(R.id.edtuser)
    edtCorreo=findViewById(R.id.edtcorreo)
    edtContraseña=findViewById(R.id.edtcontra)
    botonEntrar=findViewById(R.id.botonEntrar)


    //autentificación
    auth = FirebaseAuth.getInstance()

    //guardamos la conexion a la BBDD
    database = FirebaseDatabase.getInstance()

    //guardamos la referenca al hijo usuarios dentro de la BBDD no relacional
    databaseReference = database.reference.child("Usuarios")


//al presionar el boton "entrar"
botonEntrar.setOnClickListener {
    //condiciones minimas para intentar la conexion con la autentificación de firebase
    if(edtUser.text.isNotBlank() && edtCorreo.text.isNotBlank() && edtContraseña.text.isNotBlank()
        && edtCorreo.text.contains("@") && edtCorreo.text.contains(".") && edtContraseña.text.length>=6){
        //conexion mediante la instancia de la autentificacion de firebase usando "signInWithEmailAndPassword"
        auth.signInWithEmailAndPassword(edtCorreo.text.toString(),edtContraseña.text.toString()).addOnCompleteListener{
            //si el listener que comprueba que si se ha completado devuelve que si
            if (it.isSuccessful){
                //guardamos el usuario actual
                val usuarioActual: FirebaseUser = auth.currentUser!!
                //crea un listener esperando un cambio en la referencia a usuarios
                databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        //comprueba si el usuario actual en el que estas haciendo login el nombre de usuario asociado es igual al que estas intentando introducir
                        if(snapshot.child(usuarioActual.uid).child("nombreUsuario").value.toString()==edtUser.text.toString()){
                            //te permite pasar a la siguiente app
                            val intent = Intent(this@LoginActivity, SeriesPelisActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@LoginActivity,"Nombre de usuario equivocado para los parametros introducidos", Toast.LENGTH_SHORT).show()
                        }
                    }
                    //si al acceder a esa posicion concreta en memoria se cancela por algun tipo de error
                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(this@LoginActivity,"Error - ${error.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            }else{
                //salta un mensaje en pantalla que te avisa de que hubo un error y te permite ir al registro o volver a intentarlo
                AlertDialog.Builder(this).apply {
                    setTitle("Error en el logeo")
                    setMessage("Vuelva a intentarlo o registrese si aun no lo hizo")
                    //un boton para OK
                    setPositiveButton("Volver a Intentar",null)
                    setNegativeButton("Registrarse"){ _, _ ->
                        val intent = Intent(this@LoginActivity, RegistroActivity::class.java)
                        startActivity(intent)
                    }
                } .show()
            }
        }
    }else{
        //si alguna de las condiciones anteriores fallaba informa al usuario mediante los siguientes toast

        //si alguno de los campos a rellenar esta vacio
        if(edtUser.text.isBlank() || edtCorreo.text.isBlank() || edtContraseña.text.isBlank()){
            Toast.makeText(this,"Rellene todos los campos antes de intentar entrar...",Toast.LENGTH_SHORT).show()
        }else{
            //si el campo de correo no contiene al menos una @ y un .
            if(!edtCorreo.text.contains("@") || !edtCorreo.text.contains(".")){
                Toast.makeText(this,"El correo debe contener @ y punto",Toast.LENGTH_SHORT).show()
            }else{
                //si la contraseña no mide al menos 6 de longitud
                if(edtContraseña.text.length<6){
                    Toast.makeText(this,"La contraseña debe medir 6 o más ",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}

}
}