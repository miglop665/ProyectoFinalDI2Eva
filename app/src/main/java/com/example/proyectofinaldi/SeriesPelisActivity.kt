package com.example.proyectofinaldi

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SeriesPelisActivity : AppCompatActivity() {
    private lateinit var fotoPerfil: ImageView
    private lateinit var seriesScroll :HorizontalScrollView
    private lateinit var pelisScroll :HorizontalScrollView
    private lateinit var seriesBoton: ToggleButton
    private lateinit var pelisBoton: ToggleButton
    private lateinit var foto1:ImageView
    private lateinit var foto2: ImageView
    private lateinit var foto3:ImageView
    private lateinit var foto4:ImageView
    private lateinit var foto5:ImageView
    private lateinit var foto6:ImageView
    private lateinit var foto7:ImageView
    private lateinit var foto8: ImageView
    private lateinit var foto9:ImageView
    private lateinit var foto10:ImageView
    private lateinit var foto11:ImageView
    private lateinit var foto12:ImageView

    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_series_pelis)

    fotoPerfil=findViewById(R.id.imagenPerfil)
    seriesScroll=findViewById(R.id.seriesScroll)
    pelisScroll=findViewById(R.id.pelisScroll)
    seriesBoton=findViewById(R.id.seriesBoton)
    pelisBoton=findViewById(R.id.pelisBoton)
    foto1=findViewById(R.id.foto1)
    foto2=findViewById(R.id.foto2)
    foto3=findViewById(R.id.foto3)
    foto4=findViewById(R.id.foto4)
    foto5=findViewById(R.id.foto5)
    foto6=findViewById(R.id.foto6)
    foto7=findViewById(R.id.foto7)
    foto8=findViewById(R.id.foto8)
    foto9=findViewById(R.id.foto9)
    foto10=findViewById(R.id.foto10)
    foto11=findViewById(R.id.foto11)
    foto12=findViewById(R.id.foto12)


    auth = FirebaseAuth.getInstance()

    val usuarioActual: FirebaseUser = auth.currentUser!!

    database = FirebaseDatabase.getInstance()

    databaseReference = database.reference.child("Usuarios").child(usuarioActual.uid)

    databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {

            var nombreFotoElegida = snapshot.child("foto").value.toString()

            fotoPerfil.setImageResource(resources.getIdentifier("@drawable/$nombreFotoElegida",null,packageName))

            //fotoPerfil.setImageDrawable(resources.getDrawable(snapshot.child("foto").value.toString().toInt()))
            //fotoPerfil.setImageResource(resources.getIdentifier(snapshot.child("foto").value.toString(), null, packageName))
        }
        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(this@SeriesPelisActivity,"Error - ${error.message}", Toast.LENGTH_SHORT).show()
        }
    })




fotoPerfil.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,PerfilActivity::class.java)
    startActivity(intent)
}

seriesBoton.setOnClickListener {
    if(seriesScroll.visibility== View.GONE){
        seriesScroll.visibility = View.VISIBLE
        pelisBoton.isEnabled=false
    }else{
        seriesScroll.visibility= View.GONE
        pelisBoton.isEnabled=true
    }
}

pelisBoton.setOnClickListener {
    if(pelisScroll.visibility== View.GONE){
        pelisScroll.visibility = View.VISIBLE
        seriesBoton.isEnabled=false
    }else{
        pelisScroll.visibility= View.GONE
        seriesBoton.isEnabled=true
    }
}

foto1.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" ,"harry_potter_y_la_piedra_filosofal")
    startActivity(intent)
}
foto2.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" ,"gremlins")
    startActivity(intent)
}
foto3.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "spiderman_homecoming")
    startActivity(intent)
}
foto4.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "harry_potter_y_el_prisionero_de_azkaban")
    startActivity(intent)
}
foto5.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "fast_and_furious_tokyo_drift")
    startActivity(intent)
}
foto6.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "harry_potter_y_el_caliz_de_fuego")
    startActivity(intent)
}
foto7.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "house")
    startActivity(intent)
}
foto8.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "death_note")
    startActivity(intent)
}
foto9.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "friends")
    startActivity(intent)
}
foto10.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "juego_de_tronos")
    startActivity(intent)
}
foto11.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "lucifer")
    startActivity(intent)
}
foto12.setOnClickListener {
    val intent = Intent(this@SeriesPelisActivity,InfoActivity::class.java)
    intent.putExtra("nombreDatos" , "simpsons")
    startActivity(intent)
}


}
}