package com.example.androiddevelopercourse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevelopercourse.A1ABC.Unit3_Path2.AffirmationApp
import com.example.androiddevelopercourse.A1ABC.Unit3_Path2.GridApp
import com.example.androiddevelopercourse.A1ABC.Unit3_Path3.SuperheroesApp
import com.example.androiddevelopercourse.A1ABC.Unit3_Path3.WoofApp
import com.example.androiddevelopercourse.A1ABC.Unit4_Path1.DessertDatasource.dessertList
import com.example.androiddevelopercourse.A1ABC.Unit4_Path1.DessertClickerApp
import com.example.androiddevelopercourse.ui.theme.AndroidDeveloperCourseTheme
import com.example.androiddevelopercourse.ui.theme.DessertClickerTheme
import com.example.androiddevelopercourse.ui.theme.SuperheroesTheme
import com.example.androiddevelopercourse.ui.theme.WoofTheme
import com.example.diceroller.DiceRollerAppDebug
import com.example.sqlbasics.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// tag for logging
private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
////            AndroidDeveloperCourseTheme {
////                // A surface container using the 'background' color from the theme
//////                Surface(
//////                    modifier = Modifier.fillMaxSize(),
//////                    color = MaterialTheme.colors.background
//////                ) {
//////                    Greeting("Android")
//////                }
////
//////                DiceRollerApp() // Unit 2; Pathway 2; Page 7
//////                DiceRollerAppDebug() // Unit 2; Pathway 2; Class 3; Page 3
////
//////                LemonadeApp() // Unit 2; Pathway 2; Class 4
////
//////                TipTimeScreen() // Unit 2; Pathway 3; Class 3
//////                CustomTipScreen() // Unit 2; Pathway 3; Class 4
//////                ArtSpaceScreen() // Unit 2; Pathway 3; Class 5
////            }
//
////            GlobalScope.launch {
////                AppDatabase.getDatabase(applicationContext).californiaParkDao().getAll()
////
////            }
//
////            AffirmationApp() // ABC; Unit 3; Pathway 2; Module 2
////            GridApp() // ABC; Unit 3; Pathway 2; Module 4
////            WoofTheme { // ABC; Unit 3; Pathway 3
////                WoofApp()
////            }
//            SuperheroesTheme { // ABC; Unit 3; Pathway 3; Module 5
//                SuperheroesApp()
//            }
//        }
//    }

    // ABC; Unit 4; Pathway 1; Module 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DessertClickerTheme {
                DessertClickerApp(desserts = dessertList)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidDeveloperCourseTheme {
        Greeting("Android")
    }
}