package com.example.logincap3
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.logincap3.Login.LoginContentScreen
import com.example.logincap3.ui.theme.LoginCap3Theme
import com.example.logincap3.util.Destination
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.composable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginCap3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Navigation(navController = navController)
                }

            }
        }
    }
}
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = Destination.LoginScreen.route) {
        composable(Destination.LoginScreen.route) {
            LoginContentScreen(loginViewModel = hiltViewModel())
        }

    }
}

