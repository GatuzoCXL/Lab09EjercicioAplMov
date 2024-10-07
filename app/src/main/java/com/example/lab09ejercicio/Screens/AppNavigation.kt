package com.example.lab09ejercicio.Screens


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab09ejercicio.Api.ProductApiService

@Composable
fun AppNavigation(servicio: ProductApiService) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "productList") {
        composable("productList") { ProductListScreen(navController, servicio) }
        composable("productDetail/{id}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
            ProductDetailScreen(navController, servicio, productId)
        }
    }
}