package org.mathieu.sandboxdiiage12027

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import org.mathieu.sandboxdiiage12027.ui.screens.player.PlayerDashboardScreen
import org.mathieu.sandboxdiiage12027.ui.screens.LoginScreen
import org.mathieu.sandboxdiiage12027.ui.theme.LeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeTheme { val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.LoginScreen, builder = {
                    composable(Routes.LoginScreen){
                        LoginScreen(navController)
                    }
                    composable(Routes.PlayerDashboard){
//                        val name = it.arguments?.getString("name")
                        PlayerDashboardScreen()
                    }
                })
            }
        }
    }
}
