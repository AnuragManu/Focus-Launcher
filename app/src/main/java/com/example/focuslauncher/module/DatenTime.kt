package com.example.focuslauncher.module

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun DatenTime(applist: MutableList<ApplicationInfo>, packageManagerO: PackageManager) {
    var currentDateTime by remember { mutableStateOf(LocalDateTime.now()) }

    val dateFormatter = remember { DateTimeFormatter.ofPattern("EEEE, d MMMM, yyyy") }
    val timeFormatter = remember { DateTimeFormatter.ofPattern("h:mm a") }

    LaunchedEffect(Unit) {
        while (true) {
            currentDateTime = LocalDateTime.now()
            delay(1000)
        }
    }
Surface(
    modifier = Modifier.fillMaxSize(0.9f),
    color = MaterialTheme.colorScheme.surface,
    shadowElevation = 16.dp,
    tonalElevation = 1.dp,
    shape = MaterialTheme.shapes.small
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Text(
            text = "${currentDateTime.format(dateFormatter)}",
            textAlign = TextAlign.Center, fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraBold, fontSize = 18.sp, fontStyle = FontStyle.Italic,
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.padding(8.dp)
        )

        Text(
            textAlign = TextAlign.Center, fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraBold, fontSize = 18.sp, fontStyle = FontStyle.Italic,
            text = "${currentDateTime.format(timeFormatter)}",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.padding(8.dp)
        )
    }
}
}


