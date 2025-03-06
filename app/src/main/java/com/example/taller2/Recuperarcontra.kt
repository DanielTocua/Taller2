package com.example.taller2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Recuperarcontra : AppCompatActivity() {

    private lateinit var buttonRecupcontra : Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacion)
        Log.d("Inicio_Activity","onCreate:Inicializando el Activity de Recuperacion")

        buttonRecupcontra  = findViewById(R.id.bt_recuperar)
        buttonRecupcontra.setOnClickListener{
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
            finish()
        }
    }

}