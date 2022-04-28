package com.example.tp_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class ComputeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compute)
        val value1 = findViewById<EditText>(R.id.value1)
        val value2 = findViewById<EditText>(R.id.value2)
        val calc = findViewById<Button>(R.id.calc)
        val res = findViewById<TextView>(R.id.reslt)
        val radio = findViewById<RadioGroup>(R.id.radiogroup)

        radio.setOnCheckedChangeListener { radioGroup, i ->
            calc.setOnClickListener {
                when(i){
                    R.id.sum -> {
                        res.text = (value1.text.toString().toInt() +  value2.text.toString().toInt()).toString()
                    }
                    R.id.square -> {
                        value2.setVisibility(View.INVISIBLE);
                        val valeur = value1.text.toString().toInt() * value1.text.toString().toInt()
                        res.text = valeur.toString()
                    }
                }

                }
            }
        }
        }




