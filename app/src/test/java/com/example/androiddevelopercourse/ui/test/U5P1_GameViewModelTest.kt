package com.example.androiddevelopercourse.ui.test

import com.example.androiddevelopercourse.A1ABC.Unit4_Path1.GameViewModel
import com.example.androiddevelopercourse.MAX_NO_OF_WORDS
import com.example.androiddevelopercourse.SCORE_INCREASE
import com.example.androiddevelopercourse.getUnscrambledWord
import com.example.androiddevelopercourse.allWords
import org.junit.Assert.*
import org.junit.Test

class U5P1_GameViewModelTest {
    private val viewModel = GameViewModel(allWords)

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset() {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()
        currentGameUiState = viewModel.uiState.value

        // Assert that checkUserGuess() method updates isGuessedWordWrong is updated correctly.
        assertFalse(currentGameUiState.isGuessedWordWrong)
        // Assert that score is updated correctly.
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)
    }

    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet() {
        // Given an incorrect word as input
        val incorrectPlayerWord = "and"

        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()

        val currentGameUiState = viewModel.uiState.value
        // Assert that score is unchanged
        assertEquals(0, currentGameUiState.score)

        // Assert that checkUserGuess() method updates isGuessedWordWrong correctly
        assertTrue(currentGameUiState.isGuessedWordWrong)
    }

    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {
        val currentGameUiState = viewModel.uiState.value
        getUnscrambledWord(currentGameUiState.currentScrambledWord)

        // Assert that initial current word count is set to 0
        assertTrue(currentGameUiState.currentWordCount == 0)

        // Assert that initial score is set to 0
        assertTrue(currentGameUiState.score == 0)

        assertFalse(currentGameUiState.isGuessedWordWrong) // Assert that the wrong word guessed is false.
        assertFalse(currentGameUiState.isGameOver) // Assert that game is not over.
    }

    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly() {
        var expectedScore = 0
        var currentGameUiState = viewModel.uiState.value
        var correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        println("____")
        repeat(MAX_NO_OF_WORDS) {
//            println("Run $it:")
            expectedScore += SCORE_INCREASE
//            println("Scrambled Word: $correctPlayerWord, ${currentGameUiState.currentScrambledWord}")
            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()
            currentGameUiState = viewModel.uiState.value
            correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

//            println("Score: $expectedScore, ${currentGameUiState.score}")
            assertEquals(expectedScore, currentGameUiState.score) // Assert correct score after each correct answer
        }
        // Assert that after all questions are answered, the current word count is up-to-date.
        assertEquals(MAX_NO_OF_WORDS-1, currentGameUiState.currentWordCount)
        // Assert that after 10 questions are answered, the game is over.
        assertTrue(currentGameUiState.isGameOver)
    }

    @Test
    fun gameViewModel_WordSkipped_ScoreUnchangedAndWordCountIncreased() {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()
        currentGameUiState = viewModel.uiState.value

        val lastWordCount = currentGameUiState.currentWordCount
        viewModel.skipWord()
        currentGameUiState = viewModel.uiState.value

        // Assert that score remains unchanged after word is skipped
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)

        // Assert that word count is increased by 1 after word is skipped.
        assertEquals(lastWordCount + 1, currentGameUiState.currentWordCount)
    }

    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}