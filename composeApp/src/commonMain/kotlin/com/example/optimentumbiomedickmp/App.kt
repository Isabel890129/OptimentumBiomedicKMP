// 1. AÑADIDA LA DECLARACIÓN DEL PAQUETE QUE FALTABA
package com.example.optimentumbiomedickmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.optimentumbiomedickmp.ui.ContratoScreen
import com.example.optimentumbiomedickmp.ui.CotizacionScreen
import com.example.optimentumbiomedickmp.ui.CreditosScreen
import com.example.optimentumbiomedickmp.ui.HojaVidaScreen
import com.example.optimentumbiomedickmp.ui.HomeScreen
import com.example.optimentumbiomedickmp.ui.InventarioScreen
import com.example.optimentumbiomedickmp.ui.LoginScreen
import com.example.optimentumbiomedickmp.ui.RegistroScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

// 2. CORREGIDO EL IMPORT DE 'Screen'. AHORA APUNTA A LA RUTA CORRECTA (SIN 'ui').
//    (Asegúrate de que el archivo Screen.kt esté al mismo nivel que App.kt)
import com.example.optimentumbiomedickmp.Screen

// 3. ELIMINADO EL IMPORT INCORRECTO de 'App' a sí mismo.

@Composable
@Preview
fun App() {
    MaterialTheme {
        // Asegúrate de haber CREADO los archivos para estas pantallas en la carpeta 'ui',
        // de lo contrario, la aplicación no podrá compilar.
        var currentScreen by remember { mutableStateOf(Screen.Login) }

        // El 'when' actúa como el navegador de la aplicación.
        when (currentScreen) {
            Screen.Login -> LoginScreen(
                onLoginSuccess = { currentScreen = Screen.Home },
                onRegisterClick = { currentScreen = Screen.Registro }
            )
            Screen.Registro -> RegistroScreen(
                onBack = { currentScreen = Screen.Login }
            )
            Screen.Home -> HomeScreen(
                onHojaVida = { currentScreen = Screen.HojaVida },
                onCotizacion = { currentScreen = Screen.Cotizacion },
                onInventario = { currentScreen = Screen.Inventario },
                onContrato = { currentScreen = Screen.Contrato },
                onCreditos = { currentScreen = Screen.Creditos },
                onLogout = { currentScreen = Screen.Login }
            )
            Screen.Inventario -> InventarioScreen(
                onBack = { currentScreen = Screen.Home }
            )
            Screen.HojaVida -> HojaVidaScreen(
                onBack = { currentScreen = Screen.Home }
            )
            Screen.Cotizacion -> CotizacionScreen(
                onBack = { currentScreen = Screen.Home }
            )
            Screen.Contrato -> ContratoScreen(
                onBack = { currentScreen = Screen.Home }
            )
            Screen.Creditos -> CreditosScreen(
                onBack = { currentScreen = Screen.Home }
            )
        }
    }
}
