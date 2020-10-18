package com.cagudeloa.newsapp.ui

import androidx.lifecycle.ViewModel
import com.cagudeloa.newsapp.repository.NewsRepository

// As I'm sending a parameter to the ViewModel constructor, I'll need ViewModelFactory
class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {

}