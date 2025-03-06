package com.example.taller2


import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Perfil_Activity : AppCompatActivity()  {

    private lateinit var TextViewNombres: TextView
    private lateinit var TextViewApellidos: TextView
    private lateinit var TextViewCorreo: TextView
    private lateinit var TextViewCell: TextView
    private lateinit var buttonEditar : Button

    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        Log.d("PerfilActivity","onCreate:Inicializando el Activity de Perfil")

        TextViewNombres = findViewById(R.id.t_nombres)
        TextViewApellidos = findViewById(R.id.t_apellidos)
        TextViewCorreo = findViewById(R.id.t_correo)
        TextViewCell = findViewById(R.id.t_cell)
        buttonEditar  = findViewById(R.id.bt_editar)

        //Archivo de almacenamiento local
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        buttonEditar  = findViewById(R.id.bt_editar)
        buttonEditar.setOnClickListener{
            val intent = Intent(this,RegistroActivity::class.java)
            startActivity(intent)
            finish()
        }
        //Ejemplo de como llamar los datos
        cargarDatosUsuario()
    }

    private fun cargarDatosUsuario(){
        val nombres = sharedPreferences.getString("nombres","")
        val apellidos = sharedPreferences.getString("apellidos", "")
        val correo = sharedPreferences.getString("correo", "")
        val cell = sharedPreferences.getString("cell", "")

        TextViewNombres.text = nombres
        TextViewApellidos.text = apellidos
        TextViewCorreo.text = correo
        TextViewCell.text = cell


    }
}
