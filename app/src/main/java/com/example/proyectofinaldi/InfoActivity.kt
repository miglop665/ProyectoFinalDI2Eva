package com.example.proyectofinaldi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.MediaController
import android.widget.ScrollView
import android.widget.TextView
import android.widget.ToggleButton
import android.widget.VideoView
import androidx.cardview.widget.CardView
import com.example.proyectofinaldi.DatosSP

class InfoActivity : AppCompatActivity() {
    private lateinit var CVimagenPeli: CardView
    private lateinit var imagenPeli: ImageView
    private lateinit var botonSinopsis: ToggleButton
    private lateinit var sinopsis: ScrollView
    private lateinit var sinopsisInfoTexto: TextView
    private lateinit var botonPlay: Button
    private lateinit var video: VideoView
    private lateinit var botonVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        CVimagenPeli=findViewById(R.id.CVimagenPeli)
        imagenPeli=findViewById(R.id.imagenPeli)
        botonSinopsis=findViewById(R.id.botonsinopsis)
        sinopsis=findViewById(R.id.sinopsisInfo)
        sinopsisInfoTexto=findViewById(R.id.sinopsisInfoTexto)
        botonPlay=findViewById(R.id.botonPlay)
        video=findViewById(R.id.video)
        botonVolver=findViewById(R.id.botonvolver)



        val nombreDatos=intent.getStringExtra("nombreDatos")
        val datos = DatosSP()

        val mapaDatos = datos.darDatos(nombreDatos)

        var imagen = mapaDatos["foto"]
        var sinopsisInfo = mapaDatos["sinopsis"]
        var trailer = Uri.parse("android.resource://" + packageName  + "/" + resources.getIdentifier(mapaDatos["trailer"],"raw",packageName))



        imagenPeli.setImageResource(resources.getIdentifier(imagen,null,packageName))
        video.setVideoURI(trailer)
        sinopsisInfoTexto.text=sinopsisInfo



        botonSinopsis.setOnClickListener {
            if(sinopsis.visibility== View.GONE){
                sinopsis.visibility = View.VISIBLE
            }else{
                sinopsis.visibility= View.GONE
            }
        }


        botonPlay.setOnClickListener {
            if(video.visibility==View.GONE){
                CVimagenPeli.visibility= View.GONE
                video.visibility= View.VISIBLE
                video.start()
            }else{
                video.stopPlayback()
                CVimagenPeli.visibility= View.VISIBLE
                video.visibility= View.GONE
            }
        }

        botonVolver.setOnClickListener {
            val intent = Intent(this@InfoActivity,SeriesPelisActivity::class.java)
            startActivity(intent)
        }
    }
}