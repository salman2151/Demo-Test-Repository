package com.example.demoapplication.network

import com.example.demoapplication.network.response.CountryListResponse
import retrofit2.Response

import retrofit2.http.GET

interface Repository {
    @GET("countries")
    suspend fun getCountries(): Response<CountryListResponse>
}