package com.example.mitienda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConfirmacionScreen(
    onVolverHome: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.CheckCircle,
            contentDescription = "Compra realizada",
            modifier = Modifier.size(90.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "¡Compra realizada!",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(18.dp))

        Button(onClick = onVolverHome) {
            Text(text = "Volver a la Tienda")
        }
    }
}