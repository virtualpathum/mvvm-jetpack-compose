package com.au.cba.exercise

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.au.cba.exercise.base.Resource
import com.au.cba.exercise.data.entity.TransactionList
import com.au.cba.exercise.presentation.compose.AccountScreen
import com.au.cba.exercise.presentation.compose.TitleSection
import com.au.cba.exercise.presentation.viewmodel.TransactionViewModel
import com.au.cba.exercise.theme.CBAExerciseTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: TransactionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CBAExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    DisplayView(viewModel)
                }
            }
        }
    }
}


@Composable
fun DisplayView(viewModel: TransactionViewModel) {

    var isLoading = false
    val data:TransactionList

    when (val response = viewModel.data.collectAsState(initial = Resource.Loading<TransactionList>()).value) {
        is Resource.Loading -> {
            isLoading = true
            data = TransactionList.EMPTY
        }
        is Resource.Success -> {
            data = response.data as TransactionList

        }
        is Resource.Error -> {
            Log.i("MyTag","Error : ${response.message}")
            data = TransactionList.EMPTY

        }
    }

    CBAExerciseTheme {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isLoading),
            onRefresh = { viewModel.refreshData() },
        ) {
            Scaffold(
                topBar = { data.account?.let { TitleSection(it){
                    viewModel.refreshData()
                } } },
            ){ padding->
                AccountScreen(data, Modifier.padding(padding))
            }
        }

    }
}