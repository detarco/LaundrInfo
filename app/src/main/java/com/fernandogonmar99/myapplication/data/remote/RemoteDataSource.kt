package com.fernandogonmar99.myapplication.data.remote

import com.fernandogonmar99.myapplication.domain.ClientModel
import com.fernandogonmar99.myapplication.domain.ClothesModel

interface RemoteDataSource {
    suspend fun getClothes(): List<ClothesModel>

    suspend fun getClients(): List<ClientModel>
    suspend fun addNewClient(clientModel: ClientModel)
}