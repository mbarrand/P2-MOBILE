package org.mathieu.sandboxdiiage12027.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import org.mathieu.sandboxdiiage12027.R
import org.mathieu.sandboxdiiage12027.Routes
import org.mathieu.sandboxdiiage12027.ui.composables.login.LoginCard
import org.mathieu.sandboxdiiage12027.ui.theme.*


@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        LoginCard(
            onLoginClick = { username, password ->
                println("username: $username, password: $password")
            },
            onNavigate = {
                navController.navigate(Routes.PlayerDashboard)
            }
        )
    }
}
