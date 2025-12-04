package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditosScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Créditos") },
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
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF004B54), Color(0xFF0C3A3F)) // Degradado más sutil
                    )
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "OPTIMENTUM BIOMEDIC",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                color = Color.White, // Color añadido para legibilidad
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Aplicación diseñada para optimizar la gestión de procesos biomédicos, hojas de vida, cotizaciones, inventarios y contratos de equipos médicos.",
                textAlign = TextAlign.Center,
                color = Color.White.copy(alpha = 0.8f) // Ligera transparencia para diferenciarlo
            )

            // Divisor más visible
            Divider(color = Color.White.copy(alpha = 0.5f), thickness = 1.dp)

            Text(
                text = "Desarrolladores",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text("Daniel Muñoz Piedrahita", color = Color.White)
            Text("Maria Isabel Orozco Vejarano", color = Color.White)

            Divider(color = Color.White.copy(alpha = 0.5f), thickness = 1.dp)

            Text(
                text = "Tecnología usada",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text("Kotlin Multiplatform & Jetpack Compose", color = Color.White)

            Divider(color = Color.White.copy(alpha = 0.5f), thickness = 1.dp)

            Text(
                text = "Versión 1.0.0",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.6f)
            )
        }
    }
}

// ===== BLOQUE DE VISTA PREVIA CORREGIDO =====
@Preview
@Composable
fun CreditosScreenPreview() {
    // Se envuelve la pantalla en un MaterialTheme para que la vista previa
    // pueda renderizar correctamente los componentes y estilos.
    MaterialTheme {
        CreditosScreen(onBack = {})
    }
}
