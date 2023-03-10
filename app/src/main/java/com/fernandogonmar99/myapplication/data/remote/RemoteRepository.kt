package com.fernandogonmar99.myapplication.data.remote

import com.fernandogonmar99.myapplication.domain.CustomerModel

interface RemoteRepository {

    suspend fun getClientsAndItems(): List<CustomerModel>

    suspend fun addClientsAndItems(customerModel: CustomerModel)

    suspend fun delCustomerAndItems(customerId: Int)

}