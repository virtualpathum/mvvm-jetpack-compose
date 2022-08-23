package com.au.cba.exercise.presentation.compose


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.au.cba.exercise.R
import com.au.cba.exercise.data.entity.Account


@Composable
fun TitleSection(
    item: Account,
    onRefresh:()->Unit
) {
    TopAppBar(
        backgroundColor = Color(0xFFF3F3F3),
        title = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = item.accountName,
                    textAlign = TextAlign.Center,

                )
            } },
        actions = {
            IconButton(onClick = onRefresh) {
                Icon(
                    Icons.Filled.Refresh,
                    contentDescription = stringResource(R.string.cd_refresh)
                )
            }
        }
    )
}
