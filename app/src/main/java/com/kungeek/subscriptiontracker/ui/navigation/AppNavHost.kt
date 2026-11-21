package com.kungeek.subscriptiontracker.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kungeek.subscriptiontracker.ui.subscriptions.SubscriptionListRoute
import kotlinx.serialization.Serializable

@Serializable object SubscriptionList

@Serializable object AddSubscription




@Composable
fun AppNavHost(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SubscriptionList, modifier = modifier){
        composable<SubscriptionList> {
            SubscriptionListRoute(onAddClick = {navController.navigate(AddSubscription)})
        }

        composable<AddSubscription> {
            Scaffold(

            ) { innerPadding ->
                Text(
                    text = "Add Subscription",
                    modifier = Modifier.padding(innerPadding)
                )
            }

        }
    }
}