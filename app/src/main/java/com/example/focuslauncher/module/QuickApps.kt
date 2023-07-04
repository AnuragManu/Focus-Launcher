package com.example.focuslauncher.module
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun QuickApps(applist: MutableList<ApplicationInfo>, packageManagerO: PackageManager) {
    val filteredApps = mutableListOf<ApplicationInfo>()
    var contactsAdded = false
    var messagesAdded = false
    var clockAdded = false
    var calendarAdded = false

    for (appInfo in applist) {
        val packageName = appInfo.loadLabel(packageManagerO).toString()

        if (packageName.equals("Contacts", ignoreCase = true) && !contactsAdded) {
            filteredApps.add(appInfo)
            contactsAdded = true
        } else if (packageName.equals("Messages", ignoreCase = true) && !messagesAdded) {
            filteredApps.add(appInfo)
            messagesAdded = true
        } else if (packageName.equals("Clock", ignoreCase = true) && !clockAdded) {
            filteredApps.add(appInfo)
            clockAdded = true
        } else if (packageName.equals("Calendar", ignoreCase = true) && !calendarAdded) {
            filteredApps.add(appInfo)
            calendarAdded = true
        }
    }

    val context = LocalContext.current

    LazyVerticalGrid(GridCells.Fixed(2)) {
        items(filteredApps) { appInfo ->
            Text(
                text = appInfo.loadLabel(packageManagerO).toString(),
                modifier = Modifier
                    .clickable {
                        val launchIntent =
                            packageManagerO.getLaunchIntentForPackage(appInfo.packageName)
                        launchIntent?.let {
                            context.startActivity(it)
                        }
                    }
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}