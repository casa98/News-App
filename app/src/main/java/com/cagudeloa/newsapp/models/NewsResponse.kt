package com.cagudeloa.newsapp.models

import com.cagudeloa.newsapp.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)