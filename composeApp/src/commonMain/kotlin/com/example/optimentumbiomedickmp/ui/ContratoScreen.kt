package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

private val DarkTeal = Color(0xFF0C3A3F)
private val LightBackground = Color(0xFFF5EDE0)
private val TealField = Color(0xFF1D5E68)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContratoScreen(
    onBack: () -> Unit
) {
    // 1. El estado de cada campo se levanta a la pantalla principal (State Hoisting).
    val empresa = remember { mutableStateOf("") }
    val nit = remember { mutableStateOf("") }
    val direccion = remember { mutableStateOf("") }
    val celular = remember { mutableStateOf("") }
    val fechaInicio = remember { mutableStateOf("") }
    val fechaFin = remember { mutableStateOf("") }
    val valorContrato = remember { mutableStateOf("") }
    val objetoPropuesta = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("CONTRATO", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("< Atrás")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(LightBackground)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
                    .background(DarkTeal, shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // DATOS CONTRATANTE
                SectionTitle("DATOS CONTRATANTE")

                // 2. Se pasa el estado (value) y el callback para actualizarlo (onValueChange).
                ContractField(
                    label = "EMPRESA",
                    value = empresa.value,
                    onValueChange = { empresa.value = it },
                    tealBackground = true
                )
                ContractField(
                    label = "NIT EMPRESA",
                    value = nit.value,
                    onValueChange = { nit.value = it }
                )
                ContractField(
                    label = "DIRECCION",
                    value = direccion.value,
                    onValueChange = { direccion.value = it },
                    tealBackground = true
                )
                ContractField(
                    label = "CELULAR",
                    value = celular.value,
                    onValueChange = { celular.value = it }
                )

                // TIEMPO DE CONTRATO
                SectionTitle("TIEMPO DE CONTRATO")

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ContractField(
                        label = "Fecha inicio",
                        value = fechaInicio.value,
                        onValueChange = { fechaInicio.value = it },
                        modifier = Modifier.weight(1f)
                    )
                    ContractField(
                        label = "Fecha Fin",
                        value = fechaFin.value,
                        onValueChange = { fechaFin.value = it },
                        modifier = Modifier.weight(1f)
                    )
                }

                ContractField(
                    label = "VALOR DE CONTRATO...",
                    value = valorContrato.value,
                    onValueChange = { valorContrato.value = it },
                    tealBackground = true
                )

                // OBJETO DE LA PROPUESTA
                SectionTitle("OBJETO DE LA PROPUESTA")

                ContractField(
                    label = "Escriba el objeto de la propuesta",
                    value = objetoPropuesta.value,
                    onValueChange = { objetoPropuesta.value = it },
                    singleLine = false,
                    lines = 3
                )
            }
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        color = LightBackground,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ContractField(
    label: String,
    value: String, // Recibe el valor actual desde el padre
    onValueChange: (String) -> Unit, // Recibe la función para actualizar el estado en el padre
    modifier: Modifier = Modifier,
    tealBackground: Boolean = false,
    singleLine: Boolean = true,
    lines: Int = 1
) {
    // El estado ya no se gestiona aquí.
    val bgColor = if (tealBackground) TealField else LightBackground
    // 3. Corrección de color: El color del contenido cambia según el fondo para ser legible.
    val contentColor = if (tealBackground) Color.White else DarkTeal

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = singleLine,
        minLines = lines,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = bgColor,
            unfocusedContainerColor = bgColor,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            // Se usan los colores de contenido dinámicos.
            focusedTextColor = contentColor,
            unfocusedTextColor = contentColor,
            focusedLabelColor = contentColor,
            unfocusedLabelColor = contentColor
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5EDE0)
@Composable
fun ContratoScreenPreview() {
    ContratoScreen(onBack = {})
}
