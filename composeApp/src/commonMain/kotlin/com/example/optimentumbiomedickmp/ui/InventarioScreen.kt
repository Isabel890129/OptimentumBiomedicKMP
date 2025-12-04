package com.example.optimentumbiomedickmp.ui

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventarioScreen(
    onBack: () -> Unit
) {
    // Declarar variables de estado para cada campo de texto
    var descripcion by remember { mutableStateOf("") }
    var referencia by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var numInventario by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inventario de equipos") },
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
            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it }, // Actualizar el estado cuando el texto cambie
                label = { Text("Descripción del equipo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = referencia,
                onValueChange = { referencia = it }, // Actualizar el estado
                label = { Text("Referencia") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = codigo,
                onValueChange = { codigo = it }, // Actualizar el estado
                label = { Text("Código del equipo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = numInventario,
                onValueChange = { numInventario = it }, // Actualizar el estado
                label = { Text("No. inventario") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { /* Aquí puedes usar las variables: descripcion, referencia, etc. */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar equipo")
            }
        }
    }
}
