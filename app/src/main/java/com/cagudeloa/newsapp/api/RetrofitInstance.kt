package com.cagudeloa.newsapp.api

import com.cagudeloa.newsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {

        /**
         * My Retrofit singleton class, to make calls from everywhere of the code
         */

        private val retrofit by lazy {
            // For logging responses, useful for debugging
            val logging = HttpLoggingInterceptor()  // Attach it to the retrofit object later
            logging.setLevel(HttpLoggingInterceptor.Level.BODY) // Body, the whole response itself
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            // Now use the client and pass it to the retrofit instance
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // To convert response to objects Kotlin understands
                .client(client)     // Attached
                .build()

        }

        // This is what I'll use in our code to make our network requests and bring the data
        val api: NewsAPI by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}