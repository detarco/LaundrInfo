package com.fernandogonmar99.myapplication.data.local

import com.fernandogonmar99.myapplication.domain.ClientModel

interface LocalDataSource {

    fun saveClient(clientModel: ClientModel)

    fun saveClients(clientModels: List<ClientModel>)

    fun getClients(): List<ClientModel>

    fun getClient(clientId: Int): ClientModel

    fun updateClient(clientModel: ClientModel)

    fun removeClient(clientId: String)

}