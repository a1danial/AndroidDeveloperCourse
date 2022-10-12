package com.example.androiddevelopercourse.A1ABC.Unit4_Path1

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.androiddevelopercourse.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel(
    val desserts: List<DessertU4P1> = DessertDatasource.dessertList
): ViewModel() {
    // Dessert UI state
    private val _uiState = MutableStateFlow(DessertUiState())
    // Backing property to avoid state updates from other classes
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun onDessertClicked() {
        // Update the revenue & desserts sold
        val updatedRevenue = _uiState.value.revenue.plus(
            _uiState.value.currentDessertPrice
        )
        val updatedDessertsSold = _uiState.value.dessertsSold + 1

        // Show the next dessert
        val dessertToShow = determineDessertToShow(updatedDessertsSold)

        updateDessertState(
            updatedRevenue = updatedRevenue,
            updatedDessertsSold = updatedDessertsSold,
            newDessertImageId = dessertToShow.imageId,
            newDessertPrice = dessertToShow.price
        )
    }

    private fun updateDessertState(
        updatedRevenue: Int,
        updatedDessertsSold: Int,
        newDessertImageId: Int,
        newDessertPrice: Int
    ) {
        _uiState.update { currentState ->
            currentState.copy(
                revenue = updatedRevenue,
                dessertsSold = updatedDessertsSold,
                currentDessertPrice = newDessertPrice,
                currentDessertImageId = newDessertImageId
            )
        }
    }

    /**
     * Determine which dessert to show.
     */
    fun determineDessertToShow(dessertsSold: Int): DessertU4P1 {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShow
    }

    /**
     * Share desserts sold information using ACTION_SEND intent
     */
    fun shareSoldDessertsInformation(intentContext: Context) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT,
                intentContext.getString(
                    R.string.share_text,
                    _uiState.value.dessertsSold,
                    _uiState.value.revenue
                )
            )
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)

        try {
            ContextCompat.startActivity(intentContext, shareIntent, null)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                intentContext,
                intentContext.getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    init {
        _uiState.update { currentState ->
            currentState.copy(
                currentDessertPrice = desserts[0].price,
                currentDessertImageId = desserts[0].imageId
            )
        }
    }
}