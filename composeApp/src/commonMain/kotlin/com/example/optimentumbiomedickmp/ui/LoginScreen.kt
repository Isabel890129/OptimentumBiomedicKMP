package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// Los parámetros DEBEN COINCIDIR con los que usas en App.kt
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onRegisterClick: () -> Unit) {
    Column {
        Text("Pantalla de Login")
        Button(onClick = onLoginSuccess) {
            Text("Entrar")
        }
        Button(onClick = onRegisterClick) {
            Text("Registrarse")
        }
    }
}
