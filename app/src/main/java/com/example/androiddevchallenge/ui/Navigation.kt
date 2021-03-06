/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.HomeScreen
import com.example.androiddevchallenge.Login
import com.example.androiddevchallenge.MyApp

object MainDestinations {
    const val WELCOME = "welcome"
    const val LOG_IN = "logIn"
    const val HOME = "home"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.WELCOME) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.WELCOME) {
            MyApp(actions.goToLoginScreen)
        }

        composable(MainDestinations.LOG_IN) {
            Login(actions.goToHomeScreen)
        }

        composable(MainDestinations.HOME) {
            HomeScreen()
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val goToLoginScreen: () -> Unit = {
        navController.navigate(MainDestinations.LOG_IN)
    }
    val goToHomeScreen: () -> Unit = {
        navController.navigate(MainDestinations.HOME)
    }
}
