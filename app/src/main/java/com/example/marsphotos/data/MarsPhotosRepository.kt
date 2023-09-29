package com.example.marsphotos.data

import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApiService

interface MarsPhotosRepository {
    //Se obtiene la lista de las fotos desde la API
    suspend fun getMarsPhotos(): List<MarsPhoto>
}
//Implementamos mecanismos de recuperacion para evitar la perdida de los datos de la API
class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    //Obtenemos esa lista de datos de la API
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}
