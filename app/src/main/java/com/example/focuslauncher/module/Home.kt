package com.example.focuslauncher.module

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.runtime.Composable

@Composable
fun Home(applist: MutableList<ApplicationInfo>, packageManagerO: PackageManager) {
    DatenTime(applist,packageManagerO)
    QuickApps(applist,packageManagerO)

}