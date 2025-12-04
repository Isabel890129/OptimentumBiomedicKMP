package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HojaVidaScreen(
    onBack: () -> Unit
) {
    // 1. Se levanta el estado de cada campo a la pantalla principal.
    val descripcion = remember { mutableStateOf("") }
    val marca = remember { mutableStateOf("") }
    val modelo = remember { mutableStateOf("") }
    val serie = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hoja de vida") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("< Atrás")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // 2. Cada OutlinedTextField se vincula a su estado.
            OutlinedTextField(
                value = descripcion.value,
                onValueChange = { descripcion.value = it },
                label = { Text("Descripción del equipo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = marca.value,
                onValueChange = { marca.value = it },
                label = { Text("Marca") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = modelo.value,
                onValueChange = { modelo.value = it },
                label = { Text("Modelo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = serie.value,
                onValueChange = { serie.value = it },
                label = { Text("Serie") },
                modifier = Modifier.fillMaxWidth()
            )

            // 3. Se añade un botón para realizar una acción con los datos.
            Button(
                onClick = {
                    // Aquí puedes usar los valores:
                    // val desc = descripcion.value
                    // val marc = marca.value
                    // ...etc.
                },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            ) {
                Text("Guardar hoja de vida")
            }
        }
    }
}

// 4. Código añadido para la previsualización.
@Preview
@Composable
fun HojaVidaScreenPreview() {
    HojaVidaScreen(onBack = {})
}
