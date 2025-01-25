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
import com.example.screennavigation.viewmodel.SharedViewModel


// another way to do Nav Graph
fun getMyNavGraph(startDestination: String ,
                  controller: NavController,
                  paddingvalues: PaddingValues,
                  sharedViewModel: SharedViewModel
): NavGraph {
    return controller.createGraph(startDestination ) {
        composable("screen-one") {
            ScreenOne(navController = controller, modifier = Modifier.padding(paddingvalues), sharedViewModel)
        }
        composable("screen-two") {

            val stringRollNumber = it.arguments?.getString("rollNo")?: "0" // anything you pass here is converted to a string
            val data = stringRollNumber.toInt()
            controller.currentBackStackEntry?.arguments?.apply {
                putInt("rollNo", data)
            }
            ScreenTwo(navController = controller,modifier = Modifier.padding(paddingvalues), sharedViewModel)
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
