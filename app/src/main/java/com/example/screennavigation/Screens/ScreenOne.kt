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


@Composable
fun ScreenOne(navController: NavController, modifier : Modifier = Modifier) {

    val sampleStudent = Student(
        name = "Yash Shah",
        age = 25,
        address = "San Fransisco, USA",
        contact = "123654789",
        email = "yash@shah.com",
        rollNo = 23,
        standard = 14
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val rollNo = 101
            Text(text = "Screen One")
            Button(onClick = { navController.navigate("screen-two/$rollNo") }) {
                Text(text = "Click for Screen 2")
            }
        }
    }
}