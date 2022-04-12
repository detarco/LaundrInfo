package com.fernandogonmar99.myapplication.mockdata

import com.fernandogonmar99.myapplication.domain.ClientModel
import com.fernandogonmar99.myapplication.domain.ClothesModel

class MockLaundryData {
    companion object {

        fun makeClothes() = mutableListOf(
            ClothesModel(
                "Americana",
                "Seco",
                7.50
            ),
            ClothesModel(
                "Pantalón",
                "Seco",
                5.00
            ),
            ClothesModel(
                "Camisa",
                "Seco",
                5.00
            ), ClothesModel(
                "Corbata",
                "Seco",
                2.50
            ), ClothesModel(
                "Abrigo",
                "Seco",
                9.00
            ), ClothesModel(
                "Cazadora",
                "Seco",
                7.50
            )
        )

        fun makeClients() = mutableListOf(
            ClientModel(
                1,
                "Fernando",
                "González Maroto",
                652464502,
                "Calle Toledo n7 p8",
                mutableListOf(
                    ClothesModel(
                        "Camisa",
                        "Seco",
                        5.00
                    ),
                    ClothesModel(
                        "Camisa",
                        "Seco",
                        5.00
                    ),
                    ClothesModel(
                        "Pantalón",
                        "Seco",
                        5.00
                    )
                )
            )
        )
    }
}