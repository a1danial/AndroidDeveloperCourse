package com.example.androiddevelopercourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevelopercourse.ui.theme.AndroidDeveloperCourseTheme
import com.example.diceroller.DiceRollerAppDebug
import com.example.sqlbasics.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            AndroidDeveloperCourseTheme {
//                // A surface container using the 'background' color from the theme
////                Surface(
////                    modifier = Modifier.fillMaxSize(),
////                    color = MaterialTheme.colors.background
////                ) {
////                    Greeting("Android")
////                }
//
////                DiceRollerApp() // Unit 2; Pathway 2; Page 7
////                DiceRollerAppDebug() // Unit 2; Pathway 2; Class 3; Page 3
//
////                LemonadeApp() // Unit 2; Pathway 2; Class 4
//
////                TipTimeScreen() // Unit 2; Pathway 3; Class 3
////                CustomTipScreen() // Unit 2; Pathway 3; Class 4
////                ArtSpaceScreen() // Unit 2; Pathway 3; Class 5
//            }

            GlobalScope.launch {
                AppDatabase.getDatabase(applicationContext).californiaParkDao().getAll()

            }
        }
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