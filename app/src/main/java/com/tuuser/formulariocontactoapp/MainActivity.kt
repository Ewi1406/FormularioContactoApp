package com.tuuser.formulariocontactoapp // Asegúrate de que este sea el nombre de tu paquete

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    // Esta función se ejecuta cuando la actividad se crea.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el layout activity_main.xml como la interfaz de usuario de esta actividad.
        setContentView(R.layout.activity_main)

        // 1. Encontrar los elementos de la interfaz por su ID
        // Estos IDs deben coincidir con los que definiste en activity_main.xml
        val nombreEditText = findViewById<TextInputEditText>(R.id.nombre_edit_text)
        val fechaNacimientoEditText = findViewById<TextInputEditText>(R.id.fecha_nacimiento_edit_text)
        val telefonoEditText = findViewById<TextInputEditText>(R.id.telefono_edit_text)
        val emailEditText = findViewById<TextInputEditText>(R.id.email_edit_text)
        val descripcionEditText = findViewById<TextInputEditText>(R.id.descripcion_edit_text)
        val enviarButton = findViewById<Button>(R.id.enviar_button)

        // 2. Configurar el Date Picker para el campo de fecha de nacimiento
        // Cuando el usuario haga clic en el campo de texto de la fecha, se abrirá un diálogo de calendario.
        fechaNacimientoEditText.setOnClickListener {
            val calendario = Calendar.getInstance()
            val año = calendario.get(Calendar.YEAR)
            val mes = calendario.get(Calendar.MONTH)
            val dia = calendario.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val fecha = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    fechaNacimientoEditText.setText(fecha)
                }, año, mes, dia)

            datePickerDialog.show()
        }

        // 3. Configurar el botón de Enviar
        // Cuando se haga clic en el botón, se recopilan los datos y se pasan a la siguiente actividad.
        enviarButton.setOnClickListener {
            // Obtener los datos de los campos de texto
            val nombre = nombreEditText.text.toString()
            val fechaNacimiento = fechaNacimientoEditText.text.toString()
            val telefono = telefonoEditText.text.toString()
            val email = emailEditText.text.toString()
            val descripcion = descripcionEditText.text.toString()

            // Crear un Intent para abrir la segunda actividad (DetalleContactoActivity)
            val intent = Intent(this, DetalleContactoActivity::class.java)

            // Adjuntar los datos al Intent usando "extras"
            intent.putExtra("NOMBRE_COMPLETO", nombre)
            intent.putExtra("FECHA_NACIMIENTO", fechaNacimiento)
            intent.putExtra("TELEFONO", telefono)
            intent.putExtra("EMAIL", email)
            intent.putExtra("DESCRIPCION", descripcion)

            // Iniciar la segunda actividad
            startActivity(intent)
        }
    }
}

