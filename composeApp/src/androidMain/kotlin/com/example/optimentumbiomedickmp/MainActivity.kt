package com.example.optimentumbiomedickmp

// ===== CORRECCIÓN CLAVE AQUÍ =====
// Se importa 'App' usando su ruta completa para que el compilador sepa dónde encontrarla.
import com.example.optimentumbiomedickmp.App

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // Esta línea ahora funcionará porque el import es correcto.
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
