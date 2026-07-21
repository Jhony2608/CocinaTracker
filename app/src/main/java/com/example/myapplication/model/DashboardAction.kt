package com.example.myapplication.model

import androidx.annotation.DrawableRes

/**
 * Modelo de datos para las acciones rápidas del panel de control APPCC.
 *
 * @param id Identificador único de la acción.
 * @param title Título descriptivo de la acción.
 * @param iconResId Identificador de recurso del icono/pictograma (@DrawableRes).
 */
data class DashboardAction(
    val id: Int,
    val title: String,
    @DrawableRes val iconResId: Int
)
