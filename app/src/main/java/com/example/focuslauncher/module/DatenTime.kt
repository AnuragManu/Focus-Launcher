package com.example.focuslauncher.module

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Composable
fun DatenTime(applist: MutableList<ApplicationInfo>, packageManagerO: PackageManager) {
    val currentDateTime by remember { mutableStateOf(LocalDateTime.now()) }

    val dateFormatter = remember { DateTimeFormatter.ofPattern("EEEE, d MMMM, yyyy") }
    val timeFormatter = remember { DateTimeFormatter.ofPattern("h:mm a") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${currentDateTime.format(dateFormatter)}",
            style = TextStyle(fontSize = 20.sp, textDecoration = TextDecoration.Underline),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "${currentDateTime.format(timeFormatter)}",
            style = TextStyle(fontSize = 20.sp, textDecoration = TextDecoration.Underline)
        )
    }
}


