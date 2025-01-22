package com.example.screennavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.screennavigation.Screens.ScreenOne
import com.example.screennavigation.Screens.ScreenThree
import com.example.screennavigation.Screens.ScreenTwo
import com.example.screennavigation.ui.theme.ScreenNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun ScreenOnePreview() {
//    val navController = rememberNavController()
//    ScreenNavigationTheme {
//        ScreenOne(navController)
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun ScreenTwoPreview() {
//    val navController = rememberNavController()
//    ScreenNavigationTheme {
//        ScreenTwo( navController)
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun ScreenThreePreview() {
//    val navController = rememberNavController()
//    ScreenNavigationTheme {
//        ScreenThree(navController)
//    }
//}

