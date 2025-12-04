package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CotizacionScreen(
    onBack: () -> Unit
) {
    // 1. Se levanta el estado de cada campo a la pantalla principal.
    val empresa = remember { mutableStateOf("") }
    val cantidad = remember { mutableStateOf("") }
    val valorEquipo = remember { mutableStateOf("") }
    val valorMantenimiento = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cotización") },
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
            // 2. Cada OutlinedTextField se vincula con su estado.
            OutlinedTextField(
                value = empresa.value,
                onValueChange = { empresa.value = it },
                label = { Text("Empresa o persona") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = cantidad.value,
                onValueChange = { cantidad.value = it },
                label = { Text("Cantidad") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            OutlinedTextField(
                value = valorEquipo.value,
                onValueChange = { valorEquipo.value = it },
                label = { Text("Valor del equipo") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            OutlinedTextField(
                value = valorMantenimiento.value,
                onValueChange = { valorMantenimiento.value = it },
                label = { Text("Valor del mantenimiento") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            Button(
                onClick = {
                    // 3. Ahora puedes usar los valores guardados en el estado.
                    val cotizacionEmpresa = empresa.value
                    val cotizacionCantidad = cantidad.value
                    // ... y así sucesivamente.
                    // Aquí iría tu lógica para guardar la cotización.
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar cotización")
            }
        }
    }
}
