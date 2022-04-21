package com.fernandogonmar99.myapplication.data.remote

import com.fernandogonmar99.myapplication.domain.ClientModel
import com.fernandogonmar99.myapplication.domain.ClothesModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class RemoteSource : RemoteRepository {

    private var db: DatabaseReference = Firebase.database.reference

    override suspend fun getClothes(): List<ClothesModel> {
        val clothesList = mutableListOf<ClothesModel>()
        val dataSnapshot = db
            .child("Clothes")
            .get()
            .await()

        dataSnapshot.children.forEach { data ->
            data.getValue(ClothesRemoteModel::class.java)?.let { dbClothes ->
                clothesList.add(ClothesRemoteModel.toModel(dbClothes))
            }
        }

        return clothesList
    }

    override suspend fun getClients(): List<ClientModel> {
        val clientsList = mutableListOf<ClientModel>()
        val dataSnapshot = db
            .child("clients")
            .get()
            .await()

        dataSnapshot.children.forEach { data ->
            data.getValue(ClientsRemoteModel::class.java)?.let { dbClient ->
                clientsList.add(ClientsRemoteModel.toModel(dbClient))
            }
        }

        return clientsList
    }

    override suspend fun addNewClient(newClientModel: ClientModel) {
        db.child("clients")
            .child("client "+newClientModel.id.toString())
            .setValue(newClientModel)
    }

}