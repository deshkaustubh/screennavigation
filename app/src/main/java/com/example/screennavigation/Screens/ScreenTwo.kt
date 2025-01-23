package com.example.screennavigation.Screens

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
import androidx.navigation.NavController
import com.example.screennavigation.data.Student
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.*
import kotlinx.serialization.*

@Composable
fun ScreenTwo(navController: NavController, modifier : Modifier = Modifier) {
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

            val jsonData  = navController.currentBackStackEntry?.arguments?.getString("data") ?: "No Data"
            val sampleStudent = Json { prettyPrint = true }.decodeFromString(Student.serializer(), jsonData )

            Text(text = "Screen Two data received: $sampleStudent")

            Button(onClick = { navController.navigate("screen-three") }) {
                Text(text = "Screen 3")
            }
        }
    }
}