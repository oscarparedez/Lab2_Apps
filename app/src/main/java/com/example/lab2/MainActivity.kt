package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Definir las variables que se van a utilizar para realizar el calculo
        val altura: EditText = findViewById<EditText>(R.id.inputAltura)
        val peso: EditText = findViewById<EditText>(R.id.inputPeso)
        val calcular: Button = findViewById<Button>(R.id.btnProcesar)

//Funcion que al presionar el boton se realiza lo que esta a continuacion
        calcular.setOnClickListener(View.OnClickListener {

//Datos de altura, peso y resultado respectivamente
            val a: Double = altura.text.toString().toDouble() / 100
            val p: Double = peso.text.toString().toDouble() / 2.2
            val res: String = BigDecimal((p / (a * a))).setScale(1, RoundingMode.HALF_EVEN).toString()

//Creacion del intent para abrir una nueva activity
            val intent = Intent(this, resultado::class.java)

//Guardar un mensaje dependiendo del resultado obtenido del calculo
            var mensaje: String = if (res.toDouble() < 18.5)
                "Te encuentras debajo de tu peso ideal!"
            else if (res.toDouble() >= 18.5 && res.toDouble() < 24.9)
                "Te encuentras en un peso saludable!"
            else if (res.toDouble() >= 24.9 && res.toDouble() < 29.9)
                "Te encuentras en sobrepeso!"
            else
                "Te encuentras en obesidad!"

//Mandar un valor dependiendo del calculo para mostrar su imagen respectiva
            var emoji = (if (res.toDouble() < 18.5)
                "3"
            else if (res.toDouble() >= 18.5 && res.toDouble() < 24.9)
                "1"
            else if (res.toDouble() >= 24.9 && res.toDouble() < 29.9)
                "3"
            else
                "4")

//Mandar los valores de los datos por medio del intent a la siguiente activity
            intent.putExtra("resultado", res)
            intent.putExtra("mensaje", mensaje)
            intent.putExtra("emoji", emoji)
            startActivity(intent)

        })

//Mostar la formula del IMC al dejar presionado el boton de procesar
        calcular.setOnLongClickListener(View.OnLongClickListener {
            Toast.makeText(
                applicationContext,
                "IMC = Peso (kg) / Altura (m) ^ 2",
                Toast.LENGTH_SHORT
            ).show()
            true
        })
    }
}
