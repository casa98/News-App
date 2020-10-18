package com.cagudeloa.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cagudeloa.newsapp.Article

@Dao
interface ArticleDao {

    /**
     * Here we define the functions that allow us access our local data and the way we will
     * Same as we create functions to get data from API, but now locally
     */

        // An if an article already exists? That's what onConflict is for. Upsert means Update it Insert haha
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  upsert(article: Article): Long     // Returns article ID

    @Query("SELECT * FROM articles")
    // Not suspend because it'll return LiveData
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}