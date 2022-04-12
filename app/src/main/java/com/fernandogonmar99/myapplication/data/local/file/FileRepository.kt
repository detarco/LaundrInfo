package com.fernandogonmar99.myapplication.data.local.file

import android.content.Context
import com.fernandogonmar99.myapplication.data.local.LocalDataSource
import com.fernandogonmar99.myapplication.domain.ClientModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type

class FileRepository(
    context: Context,
    private val gson: Gson
) : LocalDataSource {

    private val file = File(context.cacheDir, "Clients.txt")

    init {
        createFile()
    }

    private fun createFile() {
        if (!file.exists()) {
            file.createNewFile()
        }
    }

    override fun saveClient(clientModel: ClientModel) {
        val jsonClient = gson.toJson(clientModel)
        file.writeText(jsonClient)
    }

    override fun saveClients(clientModels: List<ClientModel>) {
        val jsonClients = gson.toJson(clientModels)
        file.writeText(jsonClients)
    }

    override fun getClients(): List<ClientModel> {
        val clients = file.readText()
        val clientListType: Type =
            object : TypeToken<List<ClientModel>>() {}.type
        return gson.fromJson(clients, clientListType)
    }

    override fun getClient(clientId: Int): ClientModel {
        val clients = getClients()
        return clients.first { it.id == clientId }
    }


    override fun updateClient(clientModel: ClientModel) {
        saveClient(clientModel)
    }

    override fun removeClient(clientId: String) {
        file.writeText("")
    }
}