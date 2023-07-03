package com.example.focuslauncher.module

import android.content.pm.PackageManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.focuslauncher.R

@Composable
    fun AppList() {
        val packageManagerO = LocalContext.current.packageManager
        val applist = packageManagerO.getInstalledApplications(PackageManager.MATCH_DEFAULT_ONLY)
        val filteredApps = applist.filter { appinfo ->
            val launchIntent = packageManagerO.getLaunchIntentForPackage(appinfo.packageName)
            launchIntent != null
        }.filter { appinfo -> appinfo.loadLabel(packageManagerO).toString()
            !appinfo.loadLabel(packageManagerO).contains(R.string.app_name.toChar()) }
        filteredApps.stream().forEach { a -> println(a.loadLabel(packageManagerO)) }
        val context = LocalContext.current
        LazyColumn {
            items(filteredApps) { apps ->
                Text(
                    text = apps.loadLabel(packageManagerO).toString(),
                    modifier = Modifier.clickable {
                        val launchIntent = packageManagerO.getLaunchIntentForPackage(apps.packageName)
                        launchIntent.let {
                            context.startActivity(it)
                        }
                    }.fillMaxWidth().padding(8.dp)
                )
            }
        }
    }
