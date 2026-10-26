package com.kungeek.subscriptiontracker.ui.subscriptions

import androidx.lifecycle.ViewModel
import com.kungeek.subscriptiontracker.data.fakeSubscriptions
import com.kungeek.subscriptiontracker.model.Subscription
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal
import java.time.LocalDate

class SubscriptionViewModel: ViewModel(){
    private val _subscriptions = MutableStateFlow(fakeSubscriptions)

    val subscriptions: StateFlow<List<Subscription>> = _subscriptions.asStateFlow()


    fun removeSub(id: Long){
        _subscriptions.update { current -> current.filter { it.id != id }}
    }

    fun addSub(title: String, cost: BigDecimal, currency: String){
        _subscriptions.update { currentList ->
            val newId = (currentList.maxOfOrNull { it.id } ?: 0L ) + 1
            val newSub = Subscription(
                id = newId,
                title = title,
                currency = currency,
                cost = cost,
                debitDate = LocalDate.now().plusMonths(1)
            )
            currentList + newSub
        }
    }

}