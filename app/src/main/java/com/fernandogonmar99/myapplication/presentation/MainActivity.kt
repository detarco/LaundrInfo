package com.fernandogonmar99.myapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fernandogonmar99.myapplication.R
import com.fernandogonmar99.myapplication.data.local.LocalDataSource
import com.fernandogonmar99.myapplication.data.local.file.FileRepository
import com.fernandogonmar99.myapplication.data.local.xml.XmlRepository
import com.fernandogonmar99.myapplication.mockdata.MockLaundryData
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fileSave()
        xmlSave()
    }

    /**
     * Función para probar el guardado de información por medio de la librería File
     */
    private fun fileSave() {
        val fileRepository: LocalDataSource = FileRepository(
            this, Gson()
        )
        //Se guardan los datos de ejemplo para su comprobación
        fileRepository.saveClients(
            MockLaundryData.makeClients()
        )
        val fileClients = fileRepository.getClients()
        //El log nos ayuda momentáneamente a ver los datos
        // obtenidos ya que no tenemos interfaz todavía
        Log.d("dev-file-clients", "$fileClients")
    }

    /**
     * Función para probar el guardado de información por medio de la librería SharedPreferences
     */
    private fun xmlSave() {
        val xmlRepository: LocalDataSource = XmlRepository(
            this, Gson()
        )
        //Se guardan los datos de ejemplo para su comprobación
        xmlRepository.saveClients(
            MockLaundryData.makeClients()
        )
        val xmlClients = xmlRepository.getClients()
        //El log nos ayuda momentáneamente a ver los datos
        // obtenidos ya que no tenemos interfaz todavía
        Log.d("dev-xml-clients", "$xmlClients")
    }
}