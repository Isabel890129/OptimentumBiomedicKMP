package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

// --- Paleta de Colores ---
private val DarkTeal = Color(0xFF0C3A3F)
private val LightGreen = Color(0xFFB2D8C3)
private val LightBlue = Color(0xFFCDE2E8)
private val LightCream = Color(0xFFF5EDE0)

@Composable
fun HomeScreen(
    onLogout: () -> Unit,
    onHojaVida: () -> Unit,
    onCotizacion: () -> Unit,
    onInventario: () -> Unit,
    onContrato: () -> Unit,
    onCreditos: () -> Unit
    // onCreditos ya no se usa según el diseño
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkTeal
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // ===== PASO 1: Pasamos la acción onLogout al Header =====
            Header(onLogout = onLogout)

            // Contenido principal con el nuevo diseño
            MainContent(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(LightCream)
                    .padding(24.dp),
                onHojaVida = onHojaVida,
                onCotizacion = onCotizacion,
                onInventario = onInventario,
                onContrato = onContrato
            )
        }
    }
}

// ===== PASO 2: Renombramos HeaderLogo a Header y añadimos el botón de Logout =====
@Composable
private fun Header(onLogout: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        // Columna para el logo y el texto, centrada
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp), // Padding para que no se solape con el botón de logout
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Build,
                contentDescription = "Logo Optimentum Biomedic",
                tint = DarkTeal,
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .padding(12.dp)
            )
            Text(
                text = "OPTIMENTUM\nBIOMEDIC",
                color = Color.White,
                textAlign = TextAlign.Center,
                letterSpacing = 2.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Light
            )
        }
        // Botón de Logout alineado a la derecha
        IconButton(
            onClick = onLogout,
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Logout,
                contentDescription = "Cerrar Sesión",
                tint = Color.White
            )
        }
    }
}


@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    onHojaVida: () -> Unit,
    onCotizacion: () -> Unit,
    onInventario: () -> Unit,
    onContrato: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Bienvenido, Inge",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = DarkTeal,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "¿Qué deseas hacer hoy?",
            fontSize = 18.sp,
            color = DarkTeal.copy(alpha = 0.7f),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        MenuButton(
            text = "REALIZAR HOJAS\nDE VIDA",
            icon = Icons.Default.Article,
            color = LightGreen,
            onClick = onHojaVida
        )
        MenuButton(
            text = "COTIZACION DE\nSERVICIOS Y EQUIPO",
            icon = Icons.Default.AttachMoney,
            color = LightBlue,
            onClick = onCotizacion
        )
        MenuButton(
            text = "INVENTARIO DE\nEQUIPOS",
            icon = Icons.Default.Inventory,
            color = LightGreen,
            onClick = onInventario
        )
        MenuButton(
            text = "CONTRATO",
            icon = Icons.Default.Edit,
            color = LightBlue,
            onClick = onContrato
        )
    }
}

@Composable
private fun MenuButton(
    text: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = DarkTeal
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .background(DarkTeal.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 18.sp
            )
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
            onContrato =   {},
            onCreditos = {},
            )
    }
}
