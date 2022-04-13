package com.fernandogonmar99.myapplication.data.local.xml

import android.content.Context
import com.fernandogonmar99.myapplication.data.local.LocalDataSource
import com.fernandogonmar99.myapplication.domain.ClientModel
import com.google.gson.Gson

class XmlRepository(
    context: Context,
    private val gson: Gson
) : LocalDataSource {

    private val sharPref = context.getSharedPreferences("clients.xml", Context.MODE_PRIVATE)
    private val edit = sharPref.edit()

    override fun saveClient(clientModel: ClientModel) {
        edit.putString(
            clientModel.id.toString(),
            gson.toJson(clientModel, ClientModel::class.java)
        )
        edit.commit()
    }

    override fun saveClients(clientModels: List<ClientModel>) {
        clientModels.forEach { clientModel ->
            saveClient(clientModel)
        }
    }

    override fun getClients(): List<ClientModel> {
        return sharPref.all.values.map {
            gson.fromJson((it as String), ClientModel::class.java)
        }
    }

    override fun getClient(clientId: Int): ClientModel {
        return gson.fromJson(
            sharPref.getString(clientId.toString(), "{}"),
            ClientModel::class.java
        )
    }

    override fun updateClient(clientModel: ClientModel) {
        getClients().map {
            if (it.id == clientModel.id) {
                saveClient(clientModel)
            }
        }
    }

    override fun removeClient(clientId: String) {
        val oldClient = gson.fromJson(
            sharPref.getString(clientId, "{}"),
            ClientModel::class.java
        )
        getClients().map {
            if (it.id.toString() == clientId) {
                edit.remove(oldClient.toString())
            }
        }

    }
}