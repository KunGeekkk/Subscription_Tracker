package com.kungeek.subscriptiontracker.model

import java.math.BigDecimal
import java.time.LocalDate

data class Subscription(
    val id: Long = 0,
    val title: String,
    val cost: BigDecimal,  //Avoids Double precision issues in financial calculations
    val currency: String,
    val period: BillingPeriod = BillingPeriod.MONTHLY,
    val debitDate: LocalDate
)


enum class BillingPeriod{WEEKLY, MONTHLY, YEARLY}