package com.example.screennavigation

import androidx.compose.runtime.Composable
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
//    // Nav Controller
//    val navController = rememberNavController()
//    // Nav Host
//    NavHost(navController = navController, startDestination = "screen-one") {
//        navigationGraph(navController = navController)
//    }
    // Alternate way
    val navController = rememberNavController()
    NavHost(navController = navController, graph = getMyNavGraph(navController))
}

// another way to do Nav Graph
fun getMyNavGraph(controller: NavController): NavGraph {
    return controller.createGraph(startDestination = "screen-one") {
        composable("screen-one") {
            ScreenOne(navController = controller)
        }
        composable("screen-two") {
            ScreenTwo(navController = controller)
        }
        composable("screen-three") {
            ScreenThree(navController = controller)
        }
    }
}