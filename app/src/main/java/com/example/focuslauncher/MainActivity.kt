package com.example.focuslauncher

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.focuslauncher.module.AppList
import com.example.focuslauncher.module.Home
import com.example.focuslauncher.ui.theme.FocusLauncherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FocusLauncherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        val packageManagerO = LocalContext.current.packageManager
                        val applist = packageManagerO.getInstalledApplications(PackageManager.MATCH_DEFAULT_ONLY)
//                        Home()
                        val navController = rememberNavController()

                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") {
                                Home(applist,packageManagerO,navController)
                            }
                            composable("appList") {
                                AppList(applist,packageManagerO)
                            }
                        }



                    }
                }
            }
        }
    }
}
