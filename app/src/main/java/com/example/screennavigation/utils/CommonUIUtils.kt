package com.example.screennavigation.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.example.screennavigation.Screens.ScreenOne
import com.example.screennavigation.Screens.ScreenThree
import com.example.screennavigation.Screens.ScreenTwo


// another way to do Nav Graph
fun getMyNavGraph(startDestination: String ,controller: NavController, paddingvalues: PaddingValues): NavGraph {
    return controller.createGraph(startDestination ) {
        composable("screen-one") {
            ScreenOne(navController = controller, modifier = Modifier.padding(paddingvalues))
        }
        composable("screen-two/{data}") {
            val data = it.arguments?.getString("data") ?: "No Data Available"
            controller.currentBackStackEntry?.arguments?.apply {
                putString("data",data)
            }
            ScreenTwo(navController = controller,modifier = Modifier.padding(paddingvalues))
        }
        composable("screen-three") {
            ScreenThree(navController = controller, modifier = Modifier.padding(paddingvalues))
        }
    }
}




// Redundant Code

//fun NavGraphBuilder.navigationGraph(navController: NavController) {
//
//    composable("screen-one") {
//        ScreenOne(navController)
//    }
//
//    composable("screen-two") {
//        ScreenTwo(navController)
//    }
//
//    composable("screen-three") {
//        ScreenThree(navController)
//    }
//}
