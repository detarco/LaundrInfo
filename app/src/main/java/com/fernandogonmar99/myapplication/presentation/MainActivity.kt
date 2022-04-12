package com.fernandogonmar99.myapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fernandogonmar99.myapplication.R
import com.fernandogonmar99.myapplication.data.local.LocalDataSource
import com.fernandogonmar99.myapplication.data.local.file.FileRepository
import com.fernandogonmar99.myapplication.mockdata.MockLaundryData
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fileSave()
    }

    private fun fileSave() {
        val fileRepository: LocalDataSource = FileRepository(
            this, Gson()
        )
        fileRepository.saveClients(
            MockLaundryData.makeClients()
        )
        val clients = fileRepository.getClients()
        Log.d("dev-clients", "$clients")
    }
}