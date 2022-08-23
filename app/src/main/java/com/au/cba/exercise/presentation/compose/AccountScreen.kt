package com.au.cba.exercise.presentation.compose


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.au.cba.exercise.base.Screen
import com.au.cba.exercise.data.entity.Transaction
import com.au.cba.exercise.data.entity.TransactionList
import com.au.cba.exercise.presentation.compose.details.TransactionDetails


@Composable
fun AccountScreen(
    data: TransactionList,
    padding: Modifier
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ){
        composable(route = Screen.MainScreen.route){

        }
        composable(
            route = Screen.DetailScreen.route+"/name",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Test"
                }
            )
        ){ entry ->
            TransactionDetails(name = entry.arguments?.getString("name"))
        }
    }

    val map = getGroupBySortedList(data.transactions)
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {

                BalanceSection(data)
                Divider(color = Color.LightGray, thickness = 1.dp)
                AccountDetailsSection(data)
                Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }

        //TODO:Look for a better way
        map.forEach { entry ->
            items(1) {
                ListItemDate(date = entry.key)
                    entry.value.forEach{
                        ListItem(item = it){
                            navController.navigate(Screen.DetailScreen.withArgs())
                        }
                }
            }
        }
    }
}

private fun getGroupBySortedList(list: List<Transaction>): Map<String, List<Transaction>> {
    return list.groupBy { it.effectiveDate }.toSortedMap(reverseOrder())
}