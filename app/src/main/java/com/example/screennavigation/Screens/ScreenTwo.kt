package com.example.screennavigation.Screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.screennavigation.MyApplication
import com.example.screennavigation.data.Student
import com.example.screennavigation.viewmodel.SharedViewModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.*
import kotlinx.serialization.*

@Composable
fun ScreenTwo(navController: NavController,
              modifier : Modifier = Modifier,
              sharedViewModel: SharedViewModel
) {
    val context = LocalContext.current
    val myApplication = context.applicationContext as MyApplication

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Screen Two")
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Click to Go Back")
            }

            Text(text = "Screen Two data received:${sharedViewModel.getStudent()}")

            Button(onClick = { navController.navigate("screen-three") }) {
                Text(text = "Screen 3")
            }
        }
    }
}