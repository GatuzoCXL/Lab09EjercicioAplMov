package com.example.lab09ejercicio.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lab09ejercicio.Api.ProductApiService
import com.example.lab09ejercicio.Models.ProductModel

@Composable
fun ProductDetailScreen(navController: NavHostController, servicio: ProductApiService, productId: Int) {
    var product by remember { mutableStateOf<ProductModel?>(null) }
    LaunchedEffect(productId) {
        product = servicio.getProductById(productId)
    }

    if (product != null) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(product!!.title, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text("Price: $${product!!.price}")
            Text(product!!.description)
            //detalles
        }
    } else {
        Text("Loading...")
    }
}