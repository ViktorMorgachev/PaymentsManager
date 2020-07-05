package com.sedi.viktor.paymentsmanager.data

import java.util.*

data class PaymentData(
    val dateMessages: Map<String, Map<String, Double>> // <Дата, <Категория, Начисления>>
)