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

@Composable
fun AccountDetailsSection(
    item: TransactionList
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "BSB",color = Color(0xFF231F20), modifier = Modifier.padding(end = 5.dp),fontWeight = FontWeight.Bold)
        item.account?.let { Text(text = it.bsb,color = Color(0xFF231F20),modifier = Modifier.padding(end = 5.dp), fontSize = 14.sp) }

        Text(text = "Account",color = Color(0xFF231F20), modifier = Modifier.padding(end = 5.dp),fontWeight = FontWeight.Bold)
        item.account?.let { Text(text = it.accountNumber,color = Color(0xFF231F20), fontSize = 14.sp) }
    }
}