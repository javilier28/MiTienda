package com.example.mitienda.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mitienda.ConfirmacionScreen
import com.example.mitienda.ConsolaUi
import com.example.mitienda.DetallesScreen
import com.example.mitienda.HomeScreen
import com.example.mitienda.R

@Composable
fun NavigationManager() {
    val consolas = listOf(
        ConsolaUi(
            id = "new2dsxl",
            nombre = "New 2DS XL",
            precio = 169.99,
            descripcion = "Consola portátil de Nintendo, cómoda y ligera.",
            imagenRes = R.drawable.new2dsxl
        ),
        ConsolaUi(
            id = "new3dsxl",
            nombre = "New 3DS XL",
            precio = 219.99,
            descripcion = "Pantallas grandes y mejor experiencia 3D.",
            imagenRes = R.drawable.new3dsxl
        ),
        ConsolaUi(
            id = "3ds",
            nombre = "Nintendo 3DS",
            precio = 129.99,
            descripcion = "La clásica Nintendo 3DS.",
            imagenRes = R.drawable.n3ds
        )
    )

    fun getById(id: String): ConsolaUi? = consolas.firstOrNull { it.id == id }

    val backStack: NavBackStack<NavKey> = rememberNavBackStack(Routes.Home)

    fun goHome() {
        while (backStack.size > 1) {
            backStack.removeLastOrNull()
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = {
            val top = backStack.lastOrNull()
            if (top is Routes.Confirmacion) goHome()
            else backStack.removeLastOrNull()
        },
        entryProvider = { key ->
            when (key) {
                is Routes.Home -> NavEntry(key) {
                    HomeScreen(
                        consolas = consolas,
                        onVerDetalles = { id ->
                            backStack.add(Routes.Detalles(id))
                        }
                    )
                }

                is Routes.Detalles -> NavEntry(key) {
                    val consola = getById(key.id)
                    if (consola == null) {
                        backStack.add(Routes.Error)
                    } else {
                        DetallesScreen(
                            consola = consola,
                            onComprar = { backStack.add(Routes.Confirmacion) },
                            onAtras = { backStack.removeLastOrNull() }
                        )
                    }
                }

                is Routes.Confirmacion -> NavEntry(key) {
                    ConfirmacionScreen(
                        onVolverHome = { goHome() }
                    )
                }

                else -> NavEntry(Routes.Error) {
                    goHome()
                }
            }
        }
    )
}
