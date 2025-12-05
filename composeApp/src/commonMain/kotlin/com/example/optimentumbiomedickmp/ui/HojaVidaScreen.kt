package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import org.jetbrains.compose.ui.tooling.preview.Preview

// --- Paleta de Colores actualizada ---
private val DarkTeal = Color(0xFF1E4950)
private val MediumTeal = Color(0xFF3B8C9A)
private val DarkerTeal = Color(0xFF1A3E45)
private val LightCream = Color(0xFFF5F1E9)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HojaVidaScreen(onBack: () -> Unit) {
    // Estado para los campos de texto
    var descripcion by remember { mutableStateOf("") }
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            // Barra de navegación inferior
            BottomNavigationBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(LightCream) // Color de fondo principal
        ) {
            // Contenido principal de la pantalla
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(DarkTeal)
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()), // Para permitir el scroll si el contenido no cabe
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Título de la pantalla
                ScreenTitle()

                // Título de la sección
                SectionPill(text = "INFORMACION GENERAL")

                // Separador de puntos
                DottedDivider()

                // Campos del formulario
                InfoTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    placeholder = "Digite aqui la descripción del equipo"
                )

                SectionPill(text = "MARCA")
                InfoTextField(
                    value = marca,
                    onValueChange = { marca = it },
                    placeholder = "Digite aqui la marca del equipo"
                )

                SectionPill(text = "MODELO")
                InfoTextField(
                    value = modelo,
                    onValueChange = { modelo = it },
                    placeholder = "Digite aqui el modelo del equipo"
                )

                SectionPill(text = "SERIE")
                InfoTextField(
                    value = serie,
                    onValueChange = { serie = it },
                    placeholder = "Digite aqui la serie del equipo"
                )
            }
        }
    }
}

@Composable
private fun ScreenTitle() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hoja de vida",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "\"EQUIPO\"",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
private fun SectionPill(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(if (text == "INFORMACION GENERAL") DarkerTeal else MediumTeal) // Color diferente para el título principal
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 1.sp // Espaciado entre letras
        )
    }
}

@Composable
private fun DottedDivider() {
    Text(
        text = "...........................................",
        color = Color.White.copy(alpha = 0.5f),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        maxLines = 1,
        letterSpacing = 2.sp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InfoTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = DarkTeal.copy(alpha = 0.8f)) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = LightCream,
            unfocusedContainerColor = LightCream,
            focusedTextColor = DarkTeal,
            unfocusedTextColor = DarkTeal,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true
    )
}

@Composable
private fun BottomNavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Profile", "Notifications")
    val icons = listOf(Icons.Default.Home, Icons.Default.Person, Icons.Default.Notifications)

    NavigationBar(
        containerColor = LightCream,
        contentColor = DarkTeal
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MediumTeal,
                    unselectedIconColor = DarkTeal.copy(alpha = 0.6f),
                    indicatorColor = MediumTeal.copy(alpha = 0.1f) // Color del círculo de selección
                )
            )
        }
    }
}


// --- Preview para ver el diseño en el IDE ---
@Preview
@Composable
fun HojaVidaScreenPreview() {
    MaterialTheme {
        HojaVidaScreen(onBack = {})
    }
}
