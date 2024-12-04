package com.example.learnnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mathieu.sandboxdiiage12027.ui.composables.BottomNavBar

@Composable
fun PlayerDashboardScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp) // Place pour la navbar
        ) {
            // Simule des données pour le moment
            val userName = "Mattéo"
            val points = 34
            val challenges = listOf(
                Challenge(4, "Découverte des mots de passe", "Dans ce challenge vous devrez répondre aux questions basiques sur les mots de passe..."),
                Challenge(5, "Reconnaître du phishing", "Dans ce challenge vous allez analyser différents emails et devoir identifier ceux qui contiennent du phishing")
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Header Section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Bienvenue, $userName!",
                        style = MaterialTheme.typography.headlineSmall, // Remplacement ici
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$points points",
                            style = MaterialTheme.typography.bodyMedium, // Compatible Material 3
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        // Placeholder for the profile picture
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color.Gray) // Simule une image
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Separator Line
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Title Section
                Text(
                    text = "Vous pouvez participer à un challenge !",
                    style = MaterialTheme.typography.titleMedium, // Compatible Material 3
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Challenges List
                challenges.forEach { challenge ->
                    ChallengeCard(challenge)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
        // Navbar placée en bas
        BottomNavBar()
    }



}

@Composable
fun ChallengeCard(challenge: Challenge) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Numéro du challenge
            Text(
                text = "#${challenge.number}",
                color = Color(0xFFFFA500), // Couleur jaune
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            // Titre
            Text(
                text = challenge.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
            // Description
            Text(
                text = challenge.description,
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

// Data class pour simuler un challenge
data class Challenge(
    val number: Int,
    val title: String,
    val description: String
)
