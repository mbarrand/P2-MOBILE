package org.mathieu.sandboxdiiage12027.ui.composables.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mathieu.sandboxdiiage12027.R
import org.mathieu.sandboxdiiage12027.ui.theme.*

@Composable
fun LoginCard(
    onLoginClick: (username: String, password: String) -> Unit = { _, _ -> },
    onNavigate: () -> Unit = {}
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val isLoginEnabled = username.isNotBlank() && password.isNotBlank()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        .background(PrimaryColor),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text(
                text = "Connexion",
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 25.sp,
                color = OnPrimaryColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Username input
            Text(
                text = "Nom d'utilisateur",
                style = MaterialTheme.typography.bodyMedium,
                color = OnPrimaryColor
            )
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundColor),
                singleLine = true,
                placeholder = { Text(text = "Entrez votre nom d'utilisateur") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password input
            Text(
                text = "Mot de passe",
                style = MaterialTheme.typography.bodyMedium,
                color = OnPrimaryColor
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundColor),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                placeholder = { Text(text = "Entrez votre mot de passe") },
                trailingIcon = {
                    val icon = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = icon, contentDescription = null)
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Login button
            Button(
                onClick = {
                    onLoginClick(username, password)
                    if (isLoginEnabled) onNavigate()
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = isLoginEnabled,
                colors = ButtonDefaults.buttonColors(
                    containerColor = SecondaryColor,
                    contentColor = OnSecondaryColor,
                    disabledContainerColor = SecondaryColor,
                    disabledContentColor = OnSecondaryColor,
                )
            ) {
                Text(text = "Se connecter")
            }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                color = OnPrimaryColor,
                fontSize = 15.sp,
                text = "Mot de passe oublié ?"
            )
        }
    }
