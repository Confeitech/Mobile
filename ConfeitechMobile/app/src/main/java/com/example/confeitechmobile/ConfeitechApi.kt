package com.example.confeitechmobile

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ConfeitechApi {
    @GET("encomendas")
    suspend fun get(): List<EncomendaDTO>

}



object ConfeitechApiSla {

    private val BASE_URL = "http://10.0.2.2:8080/"

    val api: ConfeitechApi by lazy {

        // Opcional, mas bem útil para debugar: criando um interceptor de Log
        // só funciona se incluir a dependência do OkHttp no build.gradle
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val clienteHttp = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clienteHttp) // interceptor de log, opcional
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConfeitechApi::class.java)
    }
}
