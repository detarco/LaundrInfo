package com.fernandogonmar99.myapplication.data.remote

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