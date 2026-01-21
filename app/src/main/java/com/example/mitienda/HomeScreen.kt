package com.example.mitienda

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class ConsolaUi(
    val id: String,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    @DrawableRes val imagenRes: Int
)

@Composable
fun HomeScreen(
    consolas: List<ConsolaUi>,
    onVerDetalles: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Catálogo disponible:", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 12.dp)
        ) {
            items(consolas, key = { it.id }) { consola ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = consola.imagenRes),
                            contentDescription = consola.nombre,
                            modifier = Modifier.size(60.dp)
                        )

                        Spacer(modifier = Modifier.size(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(consola.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(String.format("%.2f €", consola.precio))
                        }

                        Button(onClick = { onVerDetalles(consola.id) }) {
                            Text("Ver")
                        }
                    }
                }
            }
        }
    }
}
