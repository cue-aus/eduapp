@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.eduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eduapp.screen.GameScreen
import com.example.eduapp.screen.LandingScreen
import com.example.eduapp.screen.ScoreScreen
import com.example.eduapp.screen.SettingScreen
import com.example.eduapp.ui.theme.EduAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EduAppTheme {
                AppNav()
            }
        }
    }
}

@Composable
fun AppNav() {
    //obtain navController
    val navController = rememberNavController()
    //set navHost and the routes
    NavHost(navController, startDestination = "landing"){
        //define the home route (landing)
        composable("landing"){ LandingScreen(navController) }
        //define the game route
        composable("game") { GameScreen(navController) }
        //define the setting route
        composable("setting") { SettingScreen(navController) }
        //define the score route
        composable("score") { ScoreScreen(navController) }

    }

}