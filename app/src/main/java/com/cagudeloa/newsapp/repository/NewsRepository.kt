package com.cagudeloa.newsapp.repository

import com.cagudeloa.newsapp.api.RetrofitInstance
import com.cagudeloa.newsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
    // We also need RetrofitInstance (api val), but when can call that directly from here
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

}