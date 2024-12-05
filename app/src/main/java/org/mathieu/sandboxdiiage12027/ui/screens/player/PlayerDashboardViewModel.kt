package org.mathieu.sandboxdiiage12027.ui.screens.player

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Challenge(
    val number: Int,
    val title: String,
    val description: String
)

data class PlayerDashboardState(
    val userName: String = "",
    val points: Int = 0,
    val challenges: List<Challenge> = emptyList()
)

class PlayerDashboardViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        PlayerDashboardState(
            userName = "Mattéo",
            points = 34,
            challenges = listOf(
                Challenge(8, "Découverte des mots de passe", "Dans ce challenge vous devrez répondre aux questions basiques sur les mots de passe..."),
                Challenge(5, "Reconnaître du phishing", "Dans ce challenge vous allez analyser différents emails et devoir identifier ceux qui contiennent du phishing")
            )
        )
    )
    val uiState: StateFlow<PlayerDashboardState> = _uiState
}
