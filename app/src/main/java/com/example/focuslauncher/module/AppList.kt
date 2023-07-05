package com.example.focuslauncher.module

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focuslauncher.R

@Composable
    fun AppList(applist: MutableList<ApplicationInfo>, packageManagerO: PackageManager) {
        val filteredApps = applist.filter { appinfo ->
            val launchIntent = packageManagerO.getLaunchIntentForPackage(appinfo.packageName)
            launchIntent != null
        }.filter { appinfo -> appinfo.loadLabel(packageManagerO).toString()
            !appinfo.loadLabel(packageManagerO).contains(R.string.app_name.toChar()) }
        filteredApps.stream().forEach { a -> println(a.loadLabel(packageManagerO)) }
        val context = LocalContext.current

        LazyColumn {
            items(filteredApps) { apps ->

Surface(
    tonalElevation = 1.dp,
    modifier = Modifier.padding(16.dp),
    shape = MaterialTheme.shapes.small,
    color = MaterialTheme.colorScheme.inverseOnSurface) {
    Text(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 18.sp,
        fontStyle = FontStyle.Italic,
        text = apps.loadLabel(packageManagerO).toString(),
        modifier = Modifier
            .clickable {
                val launchIntent =
                    packageManagerO.getLaunchIntentForPackage(apps.packageName)
                launchIntent.let {
                    context.startActivity(it)
                }
            }
            .fillMaxWidth()
            .padding(8.dp)
    )
}



            }
        }
    }
