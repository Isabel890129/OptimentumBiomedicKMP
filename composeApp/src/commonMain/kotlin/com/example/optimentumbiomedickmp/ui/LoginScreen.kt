package com.example.optimentumbiomedickmp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import optimentumbiomedickmp.composeapp.generated.resources.Res
import optimentumbiomedickmp.composeapp.generated.resources.LOGO

private val DarkTeal = Color(0xFF0C3A3F)
private val LightBackground = Color(0xFFF5EDE0)
private val ButtonGreen = Color(0xFFAEDCC0)
private val ErrorColor = Color(0xFFD32F2F)

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(true) }
    var isPasswordValid by remember { mutableStateOf(true) }

    fun validateFields() {
        isEmailValid = email.isNotBlank() && "@" in email
        isPasswordValid = password.length >= 6
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkTeal)
            .padding(horizontal = 32.dp, vertical = 24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.LOGO),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(72.dp)
                        .background(LightBackground, RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "OPTIMENTUM", color = LightBackground, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = "BIOMEDIC", color = LightBackground, fontSize = 16.sp, letterSpacing = 4.sp)
                }
            }

            Text(text = "Bienvenido", color = LightBackground, fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Column(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        isEmailValid = email.isNotBlank() && "@" in email
                    },
                    label = { Text("Email") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = LightBackground,
                        unfocusedContainerColor = LightBackground,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    isError = !isEmailValid
                )
                if (!isEmailValid) {
                    Text(
                        text = "Por favor, introduce un email válido.",
                        color = ErrorColor,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        isPasswordValid = password.length >= 6
                    },
                    label = { Text("Contraseña") },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = LightBackground,
                        unfocusedContainerColor = LightBackground,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    isError = !isPasswordValid
                )
                if (!isPasswordValid) {
                    Text(
                        text = "La contraseña debe tener al menos 6 caracteres.",
                        color = ErrorColor,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            Button(
                onClick = {
                    validateFields()
                    if (isEmailValid && isPasswordValid) {
                        onLoginSuccess()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonGreen,
                    contentColor = DarkTeal,
                    disabledContainerColor = ButtonGreen.copy(alpha = 0.5f)
                ),
                enabled = isEmailValid && isPasswordValid
            ) {
                Text(text = "Iniciar sesión", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "¿Olvidaste tu contraseña?", color = LightBackground, fontSize = 16.sp)
                TextButton(onClick = onRegisterClick) {
                    Text(text = "Registro", color = LightBackground, fontSize = 16.sp, fontStyle = FontStyle.Italic, textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(
            onLoginSuccess = {},
            onRegisterClick = {}
        )
    }
}
