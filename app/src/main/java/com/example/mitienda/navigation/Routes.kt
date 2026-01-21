package com.example.mitienda.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {

    @Serializable
    data object Home : Routes()

    @Serializable
    data class Detalles(val id: String) : Routes()

    @Serializable
    data object Confirmacion : Routes()

    @Serializable
    data object Error : Routes()
}
