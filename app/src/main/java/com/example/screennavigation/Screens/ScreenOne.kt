package com.example.screennavigation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.screennavigation.data.Student
import com.example.screennavigation.viewmodel.SharedViewModel
import kotlinx.serialization.json.Json


@Composable
fun ScreenOne(navController: NavController,
              modifier : Modifier = Modifier,
              sharedViewModel: SharedViewModel
) {
    
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

            Text(text = "Below is implementation of passing data using route parameter mechanism")
            Button(onClick = { 
                navController.navigate("sampleDialog")
            }) {
                Text(text = "Show Dialog")
            }
            
            val rollNo = 101
            Text(text = "Screen One")

            Button(onClick = {
                sharedViewModel.rollNo.value = 102
                navController.navigate("screen-two")
            }) {
                Text(text = "Click for Screen 2")
            }
        }
    }
}