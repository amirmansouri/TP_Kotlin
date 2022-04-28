package com.example.tp_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button) as Button
        val login = findViewById<EditText>(R.id.emailTxt)
        val pass = findViewById<EditText>(R.id.passwordTxt)
        // val txt = findViewById<TextView>(R.id.textView)

val affiche = findViewById<TextView>(R.id.affiche)
        val intent: Intent = intent
        var data = intent.getStringExtra("mnt")
        affiche.text = data.toString()
        button.setOnClickListener {
            if (login.text.toString() == "amir" && pass.text.toString()=="amir") {
                val intent = Intent(this, ComputeActivity::class.java)
                startActivity(intent)
            }

        }


    }
}







