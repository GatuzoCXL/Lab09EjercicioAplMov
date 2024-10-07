package com.example.lab09ejercicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab09ejercicio.ui.theme.Lab09EjercicioTheme
import androidx.navigation.compose.rememberNavController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.lab09ejercicio.Api.ProductApiService
import com.example.lab09ejercicio.Screens.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://dummyjson.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val servicio = retrofit.create(ProductApiService::class.java)

                AppNavigation(servicio)
            }
        }
    }
}