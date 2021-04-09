package com.example.demoapplication.network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class NetworkClass {

    companion object {
        private var repository: Repository =
            Retrofit.Builder().baseUrl("http://api.printful.com/")
                .addConverterFactory(GsonConverterFactory.create()) // map server keys on serialized keys in class
                .build()
                .create(Repository::class.java)

        fun getRepository(): Repository {
            return repository
        }

        fun main(work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.Main).launch { work() }
    }
}