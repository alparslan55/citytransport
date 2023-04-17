package com.alparslanguney.citytransport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alparslanguney.citytransport.presentation.ui.home.Home
import com.alparslanguney.citytransport.presentation.ui.navigation.Router
import com.alparslanguney.citytransport.presentation.ui.splash.Splash
import com.alparslanguney.citytransport.presentation.ui.theme.CitytransportTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nav = rememberNavController()
            CityTransport(nav)
        }
    }
}

@Composable
fun CityTransport(nav: NavHostController) {
    CitytransportTheme {
        NavHost(navController = nav, startDestination = Router.Home.route) {
            composable(Router.Splash.route) {
                Splash(viewModel = hiltViewModel()) {
                    nav.navigate(Router.Home.route)
                }
            }
            composable(Router.Home.route) {
                Home(viewModel = hiltViewModel())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CitytransportTheme {
        CityTransport(nav = rememberNavController())
    }
}