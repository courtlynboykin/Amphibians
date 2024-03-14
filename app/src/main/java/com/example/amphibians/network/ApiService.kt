package com.example.amphibians.network

import com.example.amphibians.data.Amphibian
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/amphibians"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application.json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("all")
    suspend fun getAmphibians(): List<Amphibian>
}

object Api { val retrofitService: ApiService by lazy {
    retrofit.create(ApiService::class.java)
}

}