package com.example.android_war_ssau_app

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_war_ssau_app.composables.LoginPage
import com.example.android_war_ssau_app.ui.theme.AndroidwarssauappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            AndroidwarssauappTheme {
                Surface { Login() }
            }
        }
    }
}

@Preview
@Composable
fun Login() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login_page", builder = {
        composable("login_page", content = { LoginPage() })
    })


}