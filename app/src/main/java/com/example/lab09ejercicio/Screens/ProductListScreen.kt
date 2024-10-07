package com.example.lab09ejercicio.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lab09ejercicio.Api.ProductApiService
import com.example.lab09ejercicio.Models.ProductModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController: NavHostController, servicio: ProductApiService) {
    val productList = remember { mutableStateListOf<ProductModel>() }

    LaunchedEffect(Unit) {
        val response = servicio.getProducts()
        productList.addAll(response.products)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text("Lista de Productos") }
        )

        LazyColumn {
            items(productList) { product ->
                ProductListItem(product) {
                    navController.navigate("productDetail/${product.id}")
                }
            }
        }
    }
}

@Composable
fun ProductListItem(product: ProductModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            //no pude colocar imágenes :c
            Column(modifier = Modifier.weight(1f)) {
                Text(product.title, fontWeight = FontWeight.Bold)
                Text("$${product.price}")
            }
        }
    }
}
