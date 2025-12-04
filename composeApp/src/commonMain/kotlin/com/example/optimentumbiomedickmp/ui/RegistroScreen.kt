package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import optimentumbiomedickmp.composeapp.generated.resources.Res
import optimentumbiomedickmp.composeapp.generated.resources.LOGO

private val DarkTeal = Color(0xFF0C3A3F)
private val LightBackground = Color(0xFFF5EDE0)
private val ButtonGreen = Color(0xFFAEDCC0)

@Composable
fun RegistroScreen(
    onBack: () -> Unit
) {
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var areFieldsValid by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    fun validateFields() {
        areFieldsValid = nombres.isNotBlank() && apellidos.isNotBlank() && correo.isNotBlank() && "@" in correo && contrasena.length >= 6
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkTeal)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.LOGO),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(56.dp)
                    .background(LightBackground, RoundedCornerShape(12.dp))
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "OPTIMENTUM", color = LightBackground, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "BIOMEDIC", color = LightBackground, fontSize = 14.sp, letterSpacing = 3.sp)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(LightBackground)
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Registro",
                color = DarkTeal,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = nombres,
                onValueChange = { nombres = it; validateFields() },
                placeholder = { Text("Nombres *") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = DarkTeal,
                    unfocusedContainerColor = DarkTeal,
                    focusedTextColor = LightBackground,
                    unfocusedTextColor = LightBackground,
                    unfocusedPlaceholderColor = LightBackground.copy(alpha = 0.7f),
                    focusedPlaceholderColor = LightBackground.copy(alpha = 0.7f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                singleLine = true
            )
            OutlinedTextField(
                value = apellidos,
                onValueChange = { apellidos = it; validateFields() },
                placeholder = { Text("Apellidos *") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = DarkTeal,
                    unfocusedContainerColor = DarkTeal,
                    focusedTextColor = LightBackground,
                    unfocusedTextColor = LightBackground,
                    unfocusedPlaceholderColor = LightBackground.copy(alpha = 0.7f),
                    focusedPlaceholderColor = LightBackground.copy(alpha = 0.7f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                singleLine = true
            )
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it; validateFields() },
                placeholder = { Text("Correo *") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = DarkTeal,
                    unfocusedContainerColor = DarkTeal,
                    focusedTextColor = LightBackground,
                    unfocusedTextColor = LightBackground,
                    unfocusedPlaceholderColor = LightBackground.copy(alpha = 0.7f),
                    focusedPlaceholderColor = LightBackground.copy(alpha = 0.7f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                singleLine = true
            )
            OutlinedTextField(
                value = contrasena,
                onValueChange = { contrasena = it; validateFields() },
                placeholder = { Text("Contraseña *") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = DarkTeal,
                    unfocusedContainerColor = DarkTeal,
                    focusedTextColor = LightBackground,
                    unfocusedTextColor = LightBackground,
                    unfocusedPlaceholderColor = LightBackground.copy(alpha = 0.7f),
                    focusedPlaceholderColor = LightBackground.copy(alpha = 0.7f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { showSuccessDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonGreen,
                    contentColor = DarkTeal,
                    disabledContainerColor = ButtonGreen.copy(alpha = 0.5f)
                ),
                enabled = areFieldsValid
            ) {
                Text(text = "Registrar", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }

    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = {
                showSuccessDialog = false
                onBack()
            },
            title = { Text(text = "Registro Exitoso") },
            text = { Text("Tu cuenta ha sido creada. Ahora puedes iniciar sesión.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showSuccessDialog = false
                        onBack()
                    }
                ) {
                    Text("Aceptar")
                }
            }
        )
    }
}

@Preview
@Composable
fun RegistroScreenPreview() {
    MaterialTheme {
        RegistroScreen(onBack = {})
    }
}
