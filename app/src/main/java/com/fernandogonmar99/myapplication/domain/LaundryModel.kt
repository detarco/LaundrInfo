package com.fernandogonmar99.myapplication.domain

data class ClothesModel(
    val type: String,
    val cMode: String,
    val cost: Double
)

data class ClientModel(
    val id: Int,
    val name: String,
    val surname: String,
    val telephone: Int,
    val address: String,
    val order: List <ClothesModel>
)