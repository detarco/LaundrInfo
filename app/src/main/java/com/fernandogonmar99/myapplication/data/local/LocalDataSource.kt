package com.fernandogonmar99.myapplication.data.local

import com.fernandogonmar99.myapplication.domain.ClientModel

interface LocalDataSource {

    /**
     * Método que guarda un cliente
     */
    fun saveClient(clientModel: ClientModel)

    /**
     * Método que guarda una lista de clientes
     */
    fun saveClients(clientModels: List<ClientModel>)

    /**
     * Método que devuelve todos los clientes guardados
     */
    fun getClients(): List<ClientModel>

    /**
     * Método que devuelve un cliente en específico
     */
    fun getClient(clientId: Int): ClientModel

    /**
     * Método que actualiza un cliente con información nueva
     */
    fun updateClient(clientModel: ClientModel)

    /**
     * Método que borra un cliente
     */
    fun removeClient(clientId: String)

}