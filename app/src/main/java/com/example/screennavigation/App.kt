package com.example.screennavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.screennavigation.Screens.ScreenOne
import com.example.screennavigation.Screens.ScreenThree
import com.example.screennavigation.Screens.ScreenTwo
import com.example.screennavigation.components.MyAppScaffold

// Under this file nav controller, host and graph is to be implemented

// Nav Graph - first in sequence




@Composable
fun App() {
//    // Nav Controller
//    val navController = rememberNavController()
//    // Nav Host
//    NavHost(navController = navController, startDestination = "screen-one") {
//        navigationGraph(navController = navController)
//    }
    // Alternate way
    val navController = rememberNavController()
    MyAppScaffold(navController)
}

