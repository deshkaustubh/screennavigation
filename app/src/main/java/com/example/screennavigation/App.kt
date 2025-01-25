package com.example.screennavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.screennavigation.viewmodel.SharedViewModel

// Under this file nav controller, host and graph is to be implemented

// Nav Graph - first in sequence




@Composable
fun App(startDestination: String = "screen-one") {
//    // Nav Controller
//    val navController = rememberNavController()
//    // Nav Host
//    NavHost(navController = navController, startDestination = "screen-one") {
//        navigationGraph(navController = navController)
//    }
    // Alternate way
    val navController = rememberNavController()
    val context = LocalContext.current
    val application = context.applicationContext as MyApplication

    val sharedViewModel = remember {
        SharedViewModel(application.getRepository())
    }
    MyAppScaffold(startDestination, navController, sharedViewModel)
}

