package com.cagudeloa.newsapp.db

import android.content.Context
import androidx.room.*
import com.cagudeloa.newsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {

        // First, get instance of the ArticleDB
        @Volatile
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()    // To ensure there's only one instance of my db in all the app

        // What is executed when I instance my DB from any place of my app
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            // Only one thread or instance will be able to access here at a time
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db"
            ).build()
    }
}