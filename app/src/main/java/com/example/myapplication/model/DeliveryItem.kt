package com.example.myapplication.model

/**
 * Representa un elemento de entrega o punto de control de temperatura (APPCC).
 */
data class DeliveryItem(
    val id: String,
    val title: String,
    val supplier: String,
    val targetTemperature: Double,
    val registeredTemperature: Double?,
    val isCompleted: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)
