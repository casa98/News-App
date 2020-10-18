package com.cagudeloa.newsapp

import androidx.room.Entity
import androidx.room.PrimaryKey

// Because we want to save some articles into local DB:
@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,     // Not all articles will have an ID, only the ones I'll store locally
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)