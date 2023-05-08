package com.project.at.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InfoViewModelFactory(private val id: Long)  : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InfoViewModel(id) as T
    }
}