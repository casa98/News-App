package com.cagudeloa.newsapp.api

import com.cagudeloa.newsapp.NewsResponse
import com.cagudeloa.newsapp.api.ApiKey.Companion.API_kEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    /**
     * STEPS TO MAKE NETWORK REQUESTS USING RETROFIT:
     * - Create the response objects we need (done in this file), we'll get the answer as JSON strings.
     * - Create kotlin objects that represent those answers
     *   (data classes using the cool extension, e.g. I call it, NewsResponse, check it out).
     *
     * This file will be used to define our single requests we'll execute from code
     */

    // To bring all breaking news from API, it's a GET request
    @GET("v2/top-headlines")    // Specify the part after BASE_URL
    suspend fun getBreakingNews(
        // Let's add some parameters
        @Query("country")       // These details vary from API to API, check their docs
        countryCode: String = "co",
        // Each page contains 20 items, how many will it bring at once? Once 1 (20 news)
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")    // Because this app required API key
        apiKey: String = API_kEY
    ): Response<NewsResponse>   // What this will return


    // To make our Search requests
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") // I'll get this parameter directly from the view
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_kEY
    ): Response<NewsResponse>

}