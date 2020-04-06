package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class resultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
//Almacenar el dato del emoji a mostrar y objetos por medio de sus ID
        var imcShow: TextView = findViewById<TextView>(R.id.txtIMC)
        var mensaje: TextView = findViewById<TextView>(R.id.txtMensaje)
        val emj = intent.getStringExtra("emoji")
        val emoji: ImageView = findViewById<ImageView>(R.id.imgResultado)

//Seleccionar una imagen dependiendo del resultado del calculo
        val emojiRes = when (emj){
            "1" -> R.drawable.uno
            "2" -> R.drawable.dos
            "3" -> R.drawable.tres
            else -> R.drawable.cuatro
        }
//Setear una imagen al componente ImageView
        emoji.setImageResource(emojiRes)

//Mostrar los textos en pantalla
        var intent = intent
        imcShow.text = intent.getStringExtra("resultado")
        mensaje.text = intent.getStringExtra("mensaje")




    }
}
