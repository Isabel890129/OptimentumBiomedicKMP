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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var empresa by remember { mutableStateOf("") }
    var nit by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var fechaInicio by remember { mutableStateOf("") }
    var fechaFin by remember { mutableStateOf("") }
    var valorContrato by remember { mutableStateOf("") }
    var objetoPropuesta by remember { mutableStateOf("") }

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
                SectionTitle("DATOS CONTRATANTE")
                ContractField(label = "EMPRESA", value = empresa, onValueChange = { empresa = it }, tealBackground = true)
                ContractField(label = "NIT EMPRESA", value = nit, onValueChange = { nit = it })
                ContractField(label = "DIRECCION", value = direccion, onValueChange = { direccion = it }, tealBackground = true)
                ContractField(label = "CELULAR", value = celular, onValueChange = { celular = it })

                SectionTitle("TIEMPO DE CONTRATO")
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    ContractField(label = "Fecha inicio", value = fechaInicio, onValueChange = { fechaInicio = it }, modifier = Modifier.weight(1f))
                    ContractField(label = "Fecha Fin", value = fechaFin, onValueChange = { fechaFin = it }, modifier = Modifier.weight(1f))
                }
                ContractField(label = "VALOR DE CONTRATO...", value = valorContrato, onValueChange = { valorContrato = it }, tealBackground = true)

                SectionTitle("OBJETO DE LA PROPUESTA")
                ContractField(label = "Escriba el objeto de la propuesta", value = objetoPropuesta, onValueChange = { objetoPropuesta = it }, singleLine = false, lines = 3)
            }
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(text = text, color = LightBackground, fontSize = 18.sp, fontWeight = FontWeight.Bold)
}

@Composable
private fun ContractField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    tealBackground: Boolean = false,
    singleLine: Boolean = true,
    lines: Int = 1
) {
    val bgColor = if (tealBackground) TealField else LightBackground
    val contentColor = if (tealBackground) Color.White else DarkTeal

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = singleLine,
        minLines = lines,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = bgColor,
            unfocusedContainerColor = bgColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
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
    MaterialTheme {
        ContratoScreen(onBack = {})
    }
}
