package com.example.lab09ejercicio.Api

import com.example.lab09ejercicio.Models.ProductModel
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.lab09ejercicio.Models.ProductResponse

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): ProductModel
}