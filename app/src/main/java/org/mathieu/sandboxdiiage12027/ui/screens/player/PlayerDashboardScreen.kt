package org.mathieu.sandboxdiiage12027.ui.screens.player

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.mathieu.sandboxdiiage12027.ui.composables.BottomNavBar
import org.mathieu.sandboxdiiage12027.ui.screens.player.PlayerDashboardViewModel
import org.mathieu.sandboxdiiage12027.ui.screens.player.Challenge
import org.mathieu.sandboxdiiage12027.ui.theme.*

@Composable
fun PlayerDashboardScreen(viewModel: PlayerDashboardViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().background(BackgroundColor)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                // Header Section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Bienvenue, ${uiState.userName}!",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = OnBackgroundColor
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${uiState.points} points",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(end = 8.dp),
                            color = OnBackgroundColor
                        )
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(TertiaryColor)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    thickness = 1.dp,
                    color = TertiaryColor
                )

                Text(
                    text = "Vous pouvez participer à un challenge !",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = OnBackgroundColor
                )

                uiState.challenges.forEach { challenge ->
                    ChallengeCard(challenge)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }

        BottomNavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}



@Composable
fun ChallengeCard(challenge: Challenge) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(PrimaryColor),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row( // Utilisation d'une Row pour organiser le contenu horizontalement
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically // Centrage vertical
        ) {
            // Numéro du challenge
            Text(
                text = "#${challenge.number}",
                color = SecondaryColor, // Utilisation du thème
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 16.dp) // Espacement avec le contenu à droite
            )

            // Contenu texte (titre + description)
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Titre
                Text(
                    text = challenge.title,
                    color = OnPrimaryColor, // Utilisation du thème
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                // Description
                Text(
                    text = challenge.description,
                    color = OnPrimaryColor, // Utilisation du thème),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
