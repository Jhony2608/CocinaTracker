package com.example.myapplication.data

import com.example.myapplication.model.DeliveryItem

/**
 * Repositorio de datos para la gestión de registros APPCC.
 */
interface AppccRepository {
    fun getPendingDeliveries(): List<DeliveryItem>
    fun saveDeliveryCheck(item: DeliveryItem)
}
