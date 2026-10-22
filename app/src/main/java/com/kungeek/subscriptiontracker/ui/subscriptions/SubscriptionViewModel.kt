package com.kungeek.subscriptiontracker.ui.subscriptions

import androidx.lifecycle.ViewModel
import com.kungeek.subscriptiontracker.model.BillingPeriod
import com.kungeek.subscriptiontracker.model.Subscription
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.math.BigDecimal
import java.time.LocalDate

class SubscriptionViewModel: ViewModel(){
    private val _subscribes = MutableStateFlow(listOf(
        Subscription(id = 1, title = "YouTube", cost = BigDecimal("120"), currency = "UAH", period = BillingPeriod.MONTHLY, debitDate = LocalDate.now().plusDays(5)),
        Subscription(id = 2, title = "GZM", cost = BigDecimal("75"), currency = "PLN", period = BillingPeriod.MONTHLY, debitDate = LocalDate.now().plusDays(28)),
        Subscription(id = 3, title = "Google One", cost = BigDecimal("229"), currency = "UAH", period = BillingPeriod.MONTHLY, debitDate = LocalDate.now().plusDays(13)),
        Subscription(id = 4, title = "T-Mobile", cost = BigDecimal("30"), currency = "PLN", period = BillingPeriod.MONTHLY, debitDate = LocalDate.now().plusDays(29)),
        Subscription(id = 5, title = "Gemini", cost = BigDecimal("25"), currency = "PLN", period = BillingPeriod.MONTHLY, debitDate = LocalDate.now().plusDays(21))
    ))

    val subscribe: StateFlow<List<Subscription>> = _subscribes.asStateFlow()


    fun addSubscribe(){

    }
}