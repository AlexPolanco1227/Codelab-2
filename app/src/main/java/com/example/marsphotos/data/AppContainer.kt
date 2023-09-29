
package com.example.marsphotos.data
//Importaciones para llevar a cabo este proceso

import com.example.marsphotos.network.MarsApiService
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
//Contenedor de inyección de dependencias a nivel de aplicación.
interface AppContainer {
    val marsPhotosRepository: MarsPhotosRepository
}
//Implementación para el contenedor de Inyección de Dependencias a nivel de aplicación.
//Las variables se inicializan de forma diferida y la misma instancia se comparte en toda la aplicación.
class DefaultAppContainer : AppContainer {
    //Direcion de la API
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    //Utilice el generador de actualización para crear un
    // objeto de actualización utilizando un convertidor de serialización kotlinx.
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
    //Objeto de servicio de actualización para crear llamadas api
    private val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

    //Implementación DI para el repositorio de fotos de Marte.
    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }
}
