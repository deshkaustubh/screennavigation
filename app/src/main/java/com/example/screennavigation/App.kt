package com.example.screennavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.screennavigation.Screens.ScreenOne
import com.example.screennavigation.Screens.ScreenThree
import com.example.screennavigation.Screens.ScreenTwo

// Under this file nav controller, host and graph is to be implemented

// Nav Graph - first in sequence

fun NavGraphBuilder.navigationGraph(navController: NavController) {

    composable("screen-one") {
        ScreenOne(navController)
    }

    composable("screen-two") {
        ScreenTwo(navController)
    }

    composable("screen-three") {
        ScreenThree(navController)
    }
}


@Composable
fun App() {
    // Nav Controller
    val navController = rememberNavController()
    // Nav Host
    NavHost(navController = navController, startDestination = "screen-one") {
        navigationGraph(navController = navController)
    }
}