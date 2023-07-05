package com.example.focuslauncher.module

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Home(
    applist: MutableList<ApplicationInfo>,
    packageManagerO: PackageManager,
    navController: NavHostController
) {
    Column( horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            DatenTime(applist, packageManagerO)
        }
        QuickApps(applist, packageManagerO)
        Surface(
            tonalElevation = 1.dp,
            modifier = Modifier.padding(16.dp),
            shape = MaterialTheme.shapes.small,
            color = MaterialTheme.colorScheme.inverseOnSurface
        ) {
            Text(text = "Menu",textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .clickable {
                        navController.navigate("appList")
                    }.fillMaxWidth()
                    .padding(8.dp))
        }
    }
}