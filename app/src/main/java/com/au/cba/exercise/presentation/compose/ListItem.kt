package com.au.cba.exercise.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.au.cba.exercise.data.entity.Transaction
import com.au.cba.exercise.constant.Category
import java.util.*

@Composable
fun ListItem(
    item: Transaction,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(20.dp).clickable {onClick},
        horizontalArrangement = Arrangement.SpaceEvenly,


    ) {
        Image(
            painter = painterResource(id = getIconByCategory(
                Category.valueOf(
                item.category.uppercase(
                    Locale.ENGLISH
                )
            ))),
            contentDescription = "Shopping Icon",
            modifier = Modifier.padding(end = 20.dp).
            clip(CircleShape).
            background(color = Color.LightGray).weight(
                weight = 0.2f,
                fill = false
            )
        )
        var pending = if(item.isPending) "PENDING:" else ""

        Text(text = pending.plus(item.description),
                color = Color(0xFF231F20),
                fontSize = 14.sp,
                modifier = Modifier.weight(
                    weight = 0.8f,
                    fill = true
                )
            )
        Text(text = item.amount,fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.weight(
                weight = 0.2f,
                fill = true
            ),
            textAlign = TextAlign.End
        )
    }
    Divider(color = Color.LightGray, thickness = 1.dp,modifier = Modifier.padding(start = 20.dp))
}

private fun getIconByCategory(category: Category):Int = when(category){
       Category.SHOPPING -> com.au.cba.exercise.R.drawable.icon_category_shopping
       Category.BUSINESS -> com.au.cba.exercise.R.drawable.icon_category_business
       Category.ENTERTAINMENT -> com.au.cba.exercise.R.drawable.icon_category_entertainment
       Category.GROCERIES -> com.au.cba.exercise.R.drawable.icon_category_groceries
       Category.EATINGOUT -> com.au.cba.exercise.R.drawable.icon_category_eating_out
       Category.TRANSPORT -> com.au.cba.exercise.R.drawable.icon_category_transportation
       Category.CASH -> com.au.cba.exercise.R.drawable.icon_category_cash
       Category.UNCATEGORISED -> com.au.cba.exercise.R.drawable.icon_category_uncategorised
}

