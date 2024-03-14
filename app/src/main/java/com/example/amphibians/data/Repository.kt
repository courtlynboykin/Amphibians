package com.example.amphibians.data

import com.example.amphibians.network.Api

interface Repository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkRepository() : Repository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return Api.retrofitService.getAmphibians()
    }
}