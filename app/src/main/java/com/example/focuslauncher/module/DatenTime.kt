package com.example.focuslauncher.module

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import java.text.DateFormat

@Preview(showBackground = true)
@Composable
fun DatenTime(){
    val calendar = Calendar.getInstance().time
    val dateFormat = DateFormat.getDateInstance(DateFormat.FULL).format(calendar)
    val timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT).format(calendar)
    
    Column{
        Text(fontWeight = 
        FontWeight.Bold,
            text = timeFormat
        )
         Text(text = dateFormat)
    }
}