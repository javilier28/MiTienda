package com.example.mitienda

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DetallesScreen(
    consola: ConsolaUi,
    onComprar: () -> Unit,
    onAtras: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = consola.imagenRes),
            contentDescription = consola.nombre,
            modifier = Modifier.size(220.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(consola.nombre, style = MaterialTheme.typography.titleLarge)
        Text(String.format("%.2f €", consola.precio), style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(12.dp))
        Text(consola.descripcion, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onComprar, modifier = Modifier.fillMaxWidth()) { Text("Comprar ahora") }

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(onClick = onAtras, modifier = Modifier.fillMaxWidth()) { Text("Atrás") }
    }
}
