package com.au.cba.exercise.presentation.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.au.cba.exercise.constant.DateDiffPeriod
import com.au.cba.exercise.util.Utils

@Composable
fun ListItemDate(
    date:String
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start =  20.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = Utils.dateFormatter(date),
            fontSize = 16.sp,
            color = Color(0xFF231F20),
            modifier = Modifier.padding(end = 5.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = Utils.getDateDifference(date,DateDiffPeriod.valueOf("days".uppercase())),
            color = Color(0xFF231F20), fontSize = 14.sp)
    }
}

