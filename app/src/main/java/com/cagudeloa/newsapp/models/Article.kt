package com.cagudeloa.newsapp.models

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
    // Room only handles primitives data types, so this will make us do an extra job
    val source: Source,     // We'll create a type Converter to tell Room how to treat this class
    val title: String,
    val url: String,
    val urlToImage: String
)