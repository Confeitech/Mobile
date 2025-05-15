package com.example.confeitechmobile

import com.example.confeitechmobile.dto.AndamentoDTO
import com.example.confeitechmobile.dto.BoloDTO
import com.example.confeitechmobile.dto.EncomendaDTO
import com.example.confeitechmobile.dto.UsuarioDTO
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface ConfeitechApi {
    @GET("encomendas/aguardando")
    suspend fun get(): List<EncomendaDTO>

    @PATCH("encomendas/{id}")
    suspend fun atualizarAndamento(
        @Path("id") id: Long,
        @Body andamento: AndamentoDTO
    ): EncomendaDTO

    @GET("encomendas/aceitas")
    suspend fun getAceitas(): List<EncomendaDTO>

    @GET("encomendas/user/1")
    suspend fun getEncomendasByUsuario(): List<EncomendaDTO>

    @GET("/cakes")
    suspend fun getCardapio(): List<BoloDTO>

    @GET("cakes/1")
    suspend fun getBolo1(): BoloDTO

    @GET("/users")
    suspend fun getUsers(): List<UsuarioDTO>

    @GET("/users/login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): UsuarioDTO
}

object ConfeitechApiSla {

//    NUVEM
//    private val BASE_URL = "http://52.54.253.70:8080/"

//    LOCALHOST
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
