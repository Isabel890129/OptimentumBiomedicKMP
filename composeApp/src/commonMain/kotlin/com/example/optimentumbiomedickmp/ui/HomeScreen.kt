package com.example.optimentumbiomedickmp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onLogout: () -> Unit,
    onHojaVida: () -> Unit,
    onCotizacion: () -> Unit,
    onInventario: () -> Unit,
    onContrato: () -> Unit,
    onCreditos: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("OPTIMENTUM BIOMEDIC") },
                actions = {
                    IconButton(onClick = onLogout) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Cerrar sesión"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido, Inge",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.align(Alignment.Start)
            )
            Button(onClick = onHojaVida, modifier = Modifier.fillMaxWidth()) {
                Text("REALIZAR HOJAS DE VIDA")
            }
            Button(onClick = onCotizacion, modifier = Modifier.fillMaxWidth()) {
                Text("COTIZACION DE SERVICIOS Y EQUIPO")
            }
            Button(onClick = onInventario, modifier = Modifier.fillMaxWidth()) {
                Text("INVENTARIO DE EQUIPOS")
            }
            Button(onClick = onContrato, modifier = Modifier.fillMaxWidth()) {
                Text("CONTRATO")
            }
            Button(onClick = onCreditos, modifier = Modifier.fillMaxWidth()) {
                Text("Créditos")
            }
            Button(onClick = onLogout, modifier = Modifier.fillMaxWidth()) {
                Text("Cerrar Sesión")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            onLogout = {},
            onHojaVida = {},
            onCotizacion = {},
            onInventario = {},
            onContrato = {},
            onCreditos = {}
        )
    }
}
