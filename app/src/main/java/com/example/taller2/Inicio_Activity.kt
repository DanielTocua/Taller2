package com.example.taller2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Inicio_Activity : AppCompatActivity() {

    private lateinit var TextViewRegistrate: TextView
    private lateinit var buttonLogin : Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        Log.d("Inicio_Activity","onCreate:Inicializando el Activity de Inicio")

        buttonLogin  = findViewById(R.id.btcomienza)
        TextViewRegistrate = findViewById(R.id.registrate)
        buttonLogin.setOnClickListener{
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
            finish()
        }
        TextViewRegistrate.setOnClickListener{
            val intent = Intent(this,RegistroActivity::class.java)
            startActivity(intent)
            finish()
        }
        }
    }

