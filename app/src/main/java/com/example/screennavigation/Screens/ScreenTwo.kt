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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.*
import kotlinx.serialization.*

@Composable
fun ScreenTwo(navController: NavController, modifier : Modifier = Modifier) {
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

            val stringRollNumber = navController.currentBackStackEntry?.arguments?.getString("rollNo")?: "0" // anything you pass here is converted to a string
            val rollNo= stringRollNumber.toInt()
            val student = myApplication.getRepository().getStudent(rollNo)

            Log.i("ScreenTwo", "Roll Number received $student")

            Text(text = "Screen Two data received:$student")

            Button(onClick = { navController.navigate("screen-three") }) {
                Text(text = "Screen 3")
            }
        }
    }
}