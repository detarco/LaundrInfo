package com.fernandogonmar99.myapplication.data.remote

import com.fernandogonmar99.myapplication.domain.ClientModel
import com.fernandogonmar99.myapplication.domain.ClothesModel

class ClothesRemoteModel {
    var charge: Double = 0.0
    var clothes_name: String = ""
    var washing_type: String = ""

    companion object{
        fun toModel(dbRemoteModel: ClothesRemoteModel) =
            ClothesModel(
                dbRemoteModel.clothes_name,
                dbRemoteModel.washing_type,
                dbRemoteModel.charge
            )
    }
}

class ClientsRemoteModel{
    var id: Int = 0
    var client_name: String = ""
    var client_surname: String = ""
    var client_tlp: Int = 0
    var client_address: String = ""
    lateinit var order: List<ClothesModel>

    companion object{
        fun toModel(dbRemoteModel: ClientsRemoteModel) =
            ClientModel(
                dbRemoteModel.id,
                dbRemoteModel.client_name,
                dbRemoteModel.client_surname,
                dbRemoteModel.client_tlp,
                dbRemoteModel.client_address,
                dbRemoteModel.order
            )
    }
}