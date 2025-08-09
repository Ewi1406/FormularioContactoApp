package com.tuuser.formulariocontactoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_contacto)

        // Encontrar los TextViews en la interfaz por su ID
        val nombreTextView = findViewById<TextView>(R.id.nombre_text_view)
        val fechaNacimientoTextView = findViewById<TextView>(R.id.fecha_nacimiento_text_view)
        val telefonoTextView = findViewById<TextView>(R.id.telefono_text_view)
        val emailTextView = findViewById<TextView>(R.id.email_text_view)
        val descripcionTextView = findViewById<TextView>(R.id.descripcion_text_view)
        val editarButton = findViewById<Button>(R.id.editar_button)

        // Obtener el Intent que inició esta activity
        val intent = intent

        // Recuperar los datos pasados desde la Activity 1
        val nombre = intent.getStringExtra("NOMBRE_COMPLETO")
        val fechaNacimiento = intent.getStringExtra("FECHA_NACIMIENTO")
        val telefono = intent.getStringExtra("TELEFONO")
        val email = intent.getStringExtra("EMAIL")
        val descripcion = intent.getStringExtra("DESCRIPCION")

        // Mostrar los datos en los TextViews
        nombreTextView.text = "Nombre completo: $nombre"
        fechaNacimientoTextView.text = "Fecha de nacimiento: $fechaNacimiento"
        telefonoTextView.text = "Teléfono: $telefono"
        emailTextView.text = "Email: $email"
        descripcionTextView.text = "Descripción: $descripcion"

        // Configurar el botón de "Editar datos"
        editarButton.setOnClickListener {
            // Crear un Intent para regresar a MainActivity
            val editarIntent = Intent(this, MainActivity::class.java)

            // Adjuntar los datos para que MainActivity los pueda precargar
            editarIntent.putExtra("NOMBRE_COMPLETO", nombre)
            editarIntent.putExtra("FECHA_NACIMIENTO", fechaNacimiento)
            editarIntent.putExtra("TELEFONO", telefono)
            editarIntent.putExtra("EMAIL", email)
            editarIntent.putExtra("DESCRIPCION", descripcion)

            // Iniciar la actividad
            startActivity(editarIntent)
        }
    }
}