package com.example.focuslauncher.module
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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

        LazyVerticalGrid(GridCells.Fixed(2), horizontalArrangement = Arrangement.SpaceEvenly) {
            items(filteredApps) { appInfo ->
                Surface(
                    tonalElevation = 1.dp, // Add elevation to the tab
                    modifier = Modifier.padding(16.dp),
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.inverseOnSurface
                ){
                Text(
                    text = appInfo.loadLabel(packageManagerO).toString(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.clickable {
                        val launchIntent =
                            packageManagerO.getLaunchIntentForPackage(appInfo.packageName)
                        launchIntent?.let {
                            context.startActivity(it)
                        }
                    }.padding(8.dp)
                )

            }
            }
        }
    }