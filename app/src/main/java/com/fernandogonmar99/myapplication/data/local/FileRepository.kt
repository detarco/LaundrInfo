package com.fernandogonmar99.myapplication.data.local

import com.fernandogonmar99.myapplication.domain.ClientModel

interface FileRepository {

    //Guardar un listado de clientes (al menos 10 clientes).
    fun saveClients(clientList: List<ClientModel>)

    //Recuperar un listado de clientes.
    fun getClients(): List<ClientModel>

    //Recuperar un cliente en concreto.
    fun getClient(clientID: Int): ClientModel

    //Eliminar un cliente en concreto.
    fun delClient(clientID: Int)

    //Modificar los datos de un cliente (nombre, apellidos, email o teléfono)
    fun updClient(clientModel: ClientModel)

}