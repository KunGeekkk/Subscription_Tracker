package com.kungeek.subscriptiontracker.ui.subscriptions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kungeek.subscriptiontracker.data.fakeSubscriptions
import com.kungeek.subscriptiontracker.model.Subscription
import com.kungeek.subscriptiontracker.ui.theme.SubscriptionTrackerTheme

@Composable
fun SubscriptionListRoute(modifier: Modifier = Modifier, viewModel: SubscriptionViewModel = viewModel()){
    val subscriptions by viewModel.subscriptions.collectAsStateWithLifecycle()
    SubscriptionListScreen(
        modifier = modifier,
        subscriptions = subscriptions,
        onRemoveSubscription = {id -> viewModel.removeSub(id)}
    )
}




@Composable
fun SubscriptionListScreen(
    subscriptions: List<Subscription>,
    onRemoveSubscription: (Long) -> Unit,
    modifier: Modifier = Modifier
) {

    var title by rememberSaveable { mutableStateOf("") }
    var cost by rememberSaveable { mutableStateOf("") }
    var currency by rememberSaveable { mutableStateOf("") }



    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        item {
            OutlinedTextField( value = title, onValueChange = {title = it}, label = { Text("Title") })
            OutlinedTextField( value = cost, onValueChange = {cost = it}, label = { Text("Cost") })
            OutlinedTextField( value = currency, onValueChange = {currency = it}, label = { Text("Currency") })
            Button(onClick = {}) { Text("Add") }
        }
        items(subscriptions, key = { it.id }) { subscription ->
            SubscriptionCard(subscription = subscription, onRemove = {onRemoveSubscription(subscription.id)})
        }
    }
}




@Preview(showBackground = true)
@Composable
fun SubscriptionListScreenPreview() {
    SubscriptionTrackerTheme {
        SubscriptionListScreen(subscriptions = fakeSubscriptions, onRemoveSubscription = { })
    }
}
