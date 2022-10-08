package com.example.androiddevelopercourse.A1ABC.Unit4_Path1

data class GameUiState(
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val score: Int = 0,
)
