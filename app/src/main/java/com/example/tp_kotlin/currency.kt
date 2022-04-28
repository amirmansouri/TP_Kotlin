package com.example.tp_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class currency : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
        val dinar = findViewById<Button>(R.id.dinar)
        val euro = findViewById<Button>(R.id.euro)
        val montant = findViewById<EditText>(R.id.montant)

        dinar.setOnClickListener {

            Toast.makeText(this,"${montant.text}",Toast.LENGTH_LONG).show()
      val affiche = findViewById<TextView>(R.id.aff)

val m = montant.text.toString().toFloat()
            affiche.text= (m * (3.5)).toString()
            val intent = Intent(this@currency,MainActivity::class.java)
        intent.putExtra("mnt",affiche.text)
          startActivity(intent)
        }
        euro.setOnClickListener {

            Toast.makeText(this,"${montant.text}",Toast.LENGTH_LONG).show()
            val affiche = findViewById<TextView>(R.id.aff)

            val m = montant.text.toString().toFloat()
            affiche.text= (m / (3.5)).toString()
        }

    }
}