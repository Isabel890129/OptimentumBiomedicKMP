package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import optimentumbiomedickmp.composeapp.generated.resources.LOGO
import optimentumbiomedickmp.composeapp.generated.resources.Res

// --- Paleta de colores extraída de la imagen ---
private val DarkTeal = Color(0xFF0C3A3F)
private val MediumTeal = Color(0xFF1D5E68)
private val LightCream = Color(0xFFF5EDE0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventarioScreen(
    onBack: () -> Unit // Se mantiene por si se necesita
) {
    // --- Estados para los campos de texto ---
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            // --- Barra de Navegación Inferior ---
            BottomAppBar(
                containerColor = LightCream,
                contentColor = DarkTeal
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = { /* TODO: Navegar a Home */ }) {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                    }
                    IconButton(onClick = { /* TODO: Navegar a Perfil */ }) {
                        Icon(Icons.Default.Person, contentDescription = "Perfil")
                    }
                    IconButton(onClick = { /* TODO: Navegar a Notificaciones */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notificaciones")
                    }
                }
            }
        },
        floatingActionButton = {
            // --- Botón Flotante de Acción (FAB) ---
            FloatingActionButton(
                onClick = { /* TODO: Acción para añadir nuevo inventario */ },
                containerColor = LightCream,
                contentColor = DarkTeal,
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Añadir Inventario")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(LightCream) // Fondo claro para la base de la pantalla
        ) {
            // --- Área de Contenido Principal con fondo oscuro ---
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(DarkTeal)
                    .padding(vertical = 24.dp, horizontal = 24.dp)
            ) {
                // --- Logo y Título Superior ---
                Header()

                Spacer(modifier = Modifier.height(24.dp))

                // --- Título de la Sección ---
                SectionPill(text = "INFORMACION GENERAL")
                DottedDivider()
                Spacer(modifier = Modifier.height(16.dp))

                // --- Campos de texto ---
                InfoField(
                    label = "MARCA",
                    value = marca,
                    onValueChange = { marca = it },
                    placeholder = "Digite aqui la marca del equipo",
                    backgroundColor = MediumTeal,
                    textColor = LightCream
                )
                Spacer(modifier = Modifier.height(16.dp))

                InfoField(
                    label = "MODELO",
                    value = modelo,
                    onValueChange = { modelo = it },
                    placeholder = "Digite aqui el modelo del equipo",
                    backgroundColor = LightCream,
                    textColor = DarkTeal
                )
                Spacer(modifier = Modifier.height(16.dp))

                InfoField(
                    label = "SERIE",
                    value = serie,
                    onValueChange = { serie = it },
                    placeholder = "Digite aqui la serie del equipo",
                    backgroundColor = MediumTeal,
                    textColor = LightCream
                )
            }
        }
    }
}


// --- Componentes de UI Reutilizables ---

@Composable
private fun Header() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.LOGO),
            contentDescription = "Logo",
            modifier = Modifier.size(32.dp) // Logo más pequeño
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "OPTIMENTUM BIOMEDIC",
            color = Color.White,
            fontSize = 12.sp,
            letterSpacing = 2.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "INVENTARIO  ",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "\"EQUIPO\"",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
private fun SectionPill(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50))
            .background(MediumTeal)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
private fun DottedDivider() {
    Text(
        text = "...........................................................",
        color = Color.White,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        maxLines = 1,
        letterSpacing = 2.sp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InfoField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    backgroundColor: Color,
    textColor: Color
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = label,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = textColor.copy(alpha = 0.7f)) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true
        )
    }
}

// --- Vista Previa ---
@Preview
@Composable
fun InventarioScreenPreview() {
    MaterialTheme {
        InventarioScreen(onBack = {})
    }
}
