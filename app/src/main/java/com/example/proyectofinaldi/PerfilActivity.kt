package com.example.proyectofinaldi

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class PerfilActivity : AppCompatActivity() {
    private lateinit var botonVolver:Button
    private lateinit var botonVerContra: ImageButton
    private lateinit var imagenPerfil : ImageView
    private lateinit var txvUsuario : TextView
    private lateinit var txvCorreo : TextView
    private lateinit var txvContra : TextView


    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_perfil)

    botonVerContra=findViewById(R.id.botonver)
    botonVolver=findViewById(R.id.botonvolver)
    imagenPerfil=findViewById(R.id.imagenperfil)
    txvUsuario=findViewById(R.id.txvusuario)
    txvCorreo=findViewById(R.id.txvcorreo)
    txvContra=findViewById(R.id.txvcontra)




    auth = FirebaseAuth.getInstance()

    val usuarioActual: FirebaseUser = auth.currentUser!!

    database = FirebaseDatabase.getInstance()

    databaseReference = database.reference.child("Usuarios").child(usuarioActual.uid)

    databaseReference.addListenerForSingleValueEvent(object : ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {

            var nombreFotoElegida = snapshot.child("foto").value.toString()

            imagenPerfil.setImageResource(resources.getIdentifier("@drawable/$nombreFotoElegida",null,packageName))
            txvUsuario.text=txvUsuario.text.toString()+" "+snapshot.child("nombreUsuario").value.toString()
            txvCorreo.text=txvCorreo.text.toString()+" "+snapshot.child("correo").value.toString()
            txvContra.text= snapshot.child("contraseña").value.toString()
        }

        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(this@PerfilActivity,"Error - ${error.message}", Toast.LENGTH_SHORT).show()
        }

    })


botonVerContra.setOnClickListener {
    txvContra.inputType=InputType.TYPE_CLASS_TEXT
}

botonVolver.setOnClickListener {
    val intent = Intent(this@PerfilActivity,SeriesPelisActivity::class.java)
    startActivity(intent)
}
}
}