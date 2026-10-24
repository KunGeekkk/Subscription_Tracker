package com.kungeek.subscriptiontracker.ui.subscriptions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kungeek.subscriptiontracker.data.fakeSubscriptions
import com.kungeek.subscriptiontracker.model.Subscription
import com.kungeek.subscriptiontracker.ui.theme.SubscriptionTrackerTheme

@Composable
fun SubscriptionCard(subscription: Subscription, onRemove: ()->Unit, modifier: Modifier = Modifier){
    Card(modifier = modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column{
                Text(
                    text = subscription.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "next payment - ${subscription.debitDate}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${subscription.cost} ${subscription.currency}",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${subscription.period}",
                    style = MaterialTheme.typography.labelSmall
                )

                TextButton(onClick = onRemove) { Text("Remove") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SubscriptionCardPreview(){
    SubscriptionTrackerTheme {
        SubscriptionCard(subscription = fakeSubscriptions.first(), onRemove = {})
    }
}
