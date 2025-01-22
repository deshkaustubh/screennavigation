package com.example.screennavigation.components

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.example.screennavigation.Screens.ScreenOne
import com.example.screennavigation.Screens.ScreenThree
import com.example.screennavigation.Screens.ScreenTwo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppScaffold(navController: NavController) {

    var isBackEnabled = remember {
        mutableStateOf(false)
    }

    navController.addOnDestinationChangedListener { controller,
                                                    destination,
                                                    arguments ->
        Log.i("NavController", "Destination : ${destination.route}")
        isBackEnabled.value = destination.route == "screen-one"
    }

    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(text = "SimpleAppNavigation", style = MaterialTheme.typography.labelLarge)
                },
                
                navigationIcon = {

                    var navIcon = if(isBackEnabled.value) {
                        Icons.Filled.Home
                    } else {
                        Icons.Filled.ArrowBack
                    }

                    IconButton(onClick = {
                        if( !isBackEnabled.value) {
                            navController.popBackStack()
                        }
                    }) {
                        Icon(imageVector = navIcon, contentDescription = "Nav Icon")
                    }
                }
            )
        }
    ){ paddingvalues ->

        NavHost(navController = navController as NavHostController, graph = getMyNavGraph(navController, paddingvalues))

    }
}


// another way to do Nav Graph
fun getMyNavGraph(controller: NavController, paddingvalues: PaddingValues): NavGraph {
    return controller.createGraph(startDestination = "screen-one") {
        composable("screen-one") {
            ScreenOne(navController = controller, modifier = Modifier.padding(paddingvalues))
        }
        composable("screen-two") {
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
