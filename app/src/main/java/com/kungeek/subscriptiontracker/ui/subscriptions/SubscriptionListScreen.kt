package com.kungeek.subscriptiontracker.ui.subscriptions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
    SubscriptionListScreen(modifier = modifier, subscriptions = subscriptions)
}




@Composable
fun SubscriptionListScreen(
    subscriptions: List<Subscription>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(subscriptions, key = { it.id }) { subscription ->
            SubscriptionCard(subscription)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SubscriptionListScreenPreview() {
    SubscriptionTrackerTheme {
        SubscriptionListScreen(subscriptions = fakeSubscriptions)
    }
}
