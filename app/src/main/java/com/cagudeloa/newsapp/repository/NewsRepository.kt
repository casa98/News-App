package com.cagudeloa.newsapp.repository

import com.cagudeloa.newsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
    // We also need RetrofitInstance (api val), but when can call that directly from here
) {

}