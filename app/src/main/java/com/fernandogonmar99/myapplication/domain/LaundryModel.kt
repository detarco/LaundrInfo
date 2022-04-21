package com.fernandogonmar99.myapplication.domain

data class ClothesModel(
    val clothes_name: String,
    val washing_type: String,
    val charge: Double
)

data class ClientModel(
    val id: Int,
    val name: String,
    val surname: String,
    val telephone: Int,
    val address: String,
    val order: List <ClothesModel>
)