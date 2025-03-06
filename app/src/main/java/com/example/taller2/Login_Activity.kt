package com.example.taller2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login_Activity : AppCompatActivity() {
    private lateinit var TextViewRecucontra: TextView
    private lateinit var TextViewRegistrate: TextView
    private lateinit var buttonIngreso: Button
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextContrasena: EditText
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d("Login_Activity","onCreate:Inicializando el Activity de Login")
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
        buttonIngreso = findViewById(R.id.bt_ingreso)
        TextViewRecucontra = findViewById(R.id.rpcontrasena)
        TextViewRegistrate = findViewById(R.id.rgistro)
        editTextCorreo = findViewById(R.id.et_username)
        editTextContrasena = findViewById(R.id.et_contrasena)

        buttonIngreso.setOnClickListener {
            if (validarUsuario()) {
                val intent = Intent(this,Perfil_Activity::class.java)
                startActivity(intent)
                finish()
            }
        }

        TextViewRecucontra.setOnClickListener{
            val intent = Intent(this,Recuperarcontra::class.java)
            startActivity(intent)
            finish()
        }
        TextViewRegistrate.setOnClickListener{
            val intent = Intent(this,RegistroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
        private fun validarUsuario(): Boolean {
        val correoIngresado = editTextCorreo.text.toString().trim()
        val contraIngresada = editTextContrasena.text.toString().trim()

        val correoGuardado = sharedPreferences.getString("correo", "")
        val contraGuardada = sharedPreferences.getString("contra", "")

        return if (correoIngresado == correoGuardado && contraIngresada == contraGuardada) {
            true
        } else {
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            false
        }
    }
    }

