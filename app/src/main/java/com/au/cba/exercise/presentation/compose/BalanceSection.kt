package com.au.cba.exercise.presentation.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.au.cba.exercise.data.entity.TransactionList
import com.au.cba.exercise.util.Utils.calculatePending


@Composable
fun BalanceSection(
    data: TransactionList
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {
        Text(text = "Available", color = Color(0xFF231F20), fontWeight = FontWeight.Bold )
        data.account?.let { Text(text = it.available,color = Color(0xFF231F20), fontSize = 14.sp, fontWeight = FontWeight.Bold) }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Balance",color = Color(0xFF231F20), modifier = Modifier.padding(end = 5.dp))
            data.account?.let { Text(text = it.balance,color = Color(0xFF231F20), fontSize = 14.sp,fontWeight = FontWeight.Bold) }
        }
        Row() {
            Text(text = "Pending",color = Color(0xFF231F20), modifier = Modifier.padding(end = 5.dp))
            Text(text = calculatePending(data),color = Color(0xFF231F20), fontSize = 14.sp,fontWeight = FontWeight.Bold)
        }

    }
}

