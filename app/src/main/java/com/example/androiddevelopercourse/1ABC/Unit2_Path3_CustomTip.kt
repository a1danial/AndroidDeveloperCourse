package com.example.androiddevelopercourse


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevelopercourse.ui.theme.AndroidDeveloperCourseTheme
import java.text.NumberFormat

class Unit2_Path3_CustomTip : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDeveloperCourseTheme { // Follows name of project
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipTimeScreen()
                }
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun CustomTipDefaultPreview() {
    AndroidDeveloperCourseTheme {
        TipTimeScreen()
    }
}

//@Composable
//fun TipTimeScreen() {
//    var amountInput by remember { mutableStateOf("") }
//
//    // parses a string as a Double number and returns the result or null if the string isn't a valid representation of a number
//    val amount = amountInput.toDoubleOrNull() ?: 0.0
//
//    val tip = calculateTip(amount)
//
//    Column(
//        modifier = Modifier.padding(32.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        Text(text = stringResource(id = R.string.calculate_tip),
//            fontSize = 24.sp,
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        )
//        Spacer(Modifier.height(16.dp))
//        EditNumberField(
//            amountInput
//        ) { amountInput = it }
//        Spacer(Modifier.height(24.dp))
//        Text(
//            text = stringResource(id = R.string.tip_amount, tip),
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold
//        )
//    }
//}

//@Composable
//fun EditNumberField(
//    value: String,
//    onValueChange: (String) -> Unit
//) {
//    TextField(
//        value = value,
//        onValueChange = onValueChange,
//        label = { Text(text = stringResource(id = R.string.cost_of_service)) },
//        modifier = Modifier.fillMaxWidth(),
//        singleLine = true, // single horizontally scrolling text field
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) // set keyboard type to number keyboard
//    )
//}
//
//private fun calculateTip(
//    amount: Double,
//    tipPercent: Double = 15.0
//): String {
//    val tip = amount * (tipPercent / 100)
//    return NumberFormat.getCurrencyInstance().format(tip)
//}