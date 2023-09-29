package com.example.marsphotos

import android.app.Application
import com.example.marsphotos.data.AppContainer
import com.example.marsphotos.data.DefaultAppContainer

//Esta clase se hereda del objeto de la aplicación, por lo que debes agregarla a la declaración de la clase.
class MarsPhotosApplication : Application() {
   //Instancia de AppContainer utilizada por el resto de clases para obtener dependencias
    //La variable se inicializa durante la llamada
    //a onCreate(), por lo que debe marcarse con el modificador lateinit.
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
