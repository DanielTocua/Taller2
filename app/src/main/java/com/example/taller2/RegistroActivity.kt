package com.example.taller2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.prefs.AbstractPreferences

class RegistroActivity : AppCompatActivity() {

    private lateinit var editTextNombres: EditText
    private lateinit var editTextApellidos: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextCell: EditText
    private lateinit var editTextContrasena: EditText
    private lateinit var editTextRepitacontra: EditText
    private lateinit var buttonRegistro : Button

    private lateinit var sharedPreferences: SharedPreferences


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        Log.d("RegistroActivity","onCreate:Inicializando el Activity de Registro")

        editTextNombres = findViewById(R.id.regi_nombres)
        editTextApellidos = findViewById(R.id.regi_apellidos)
        editTextCorreo = findViewById(R.id.regi_correo)
        editTextCell = findViewById(R.id.regi_cell)
        editTextContrasena = findViewById(R.id.regi_contra)
        editTextRepitacontra = findViewById(R.id.regi_repitacontra)
        buttonRegistro  = findViewById(R.id.bt_regis)

        //Archivo de almacenamiento local
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        buttonRegistro.setOnClickListener{
            //validar campos
            if(validarCampos()){
                //guardar los datos
                guardarDatos()
                //redireccionar al usuario
                val intent = Intent(this,Login_Activity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
        private fun validarCampos()  :  Boolean{
            val nombres =  editTextNombres.text.toString().trim()
            val apellidos =  editTextApellidos.text.toString().trim()
            val correo =  editTextCorreo.text.toString().trim()
            val cell =  editTextCell.text.toString().trim()
            val contra =  editTextContrasena.text.toString().trim()
            val repitacontra =  editTextRepitacontra.text.toString().trim()

            if(nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty()  || cell.isEmpty() || contra.isEmpty() || repitacontra.isEmpty()){
               Toast.makeText(this,"Existe un espacio en blanco",Toast.LENGTH_SHORT).show()
                return false
            }
            return true
        }
        private fun guardarDatos(){
            val editor = sharedPreferences.edit()

            editor.putString("nombres",editTextNombres.text.toString().trim())
            editor.putString("apellidos",editTextApellidos.text.toString().trim())
            editor.putString("correo",editTextCorreo.text.toString().trim())
            editor.putString("cell",editTextCell.text.toString().trim())
            editor.putString("contra",editTextContrasena.text.toString().trim())
            editor.putString("repitacontra",editTextRepitacontra.text.toString().trim())
            editor.apply()

            Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_SHORT).show()

        }




    }

