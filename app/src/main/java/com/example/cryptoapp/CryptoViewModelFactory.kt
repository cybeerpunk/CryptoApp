package com.example.cryptoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.api.ListCryptoRepository


class CryptoViewModelFactory constructor(private val repository: ListCryptoRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CryptoViewModel::class.java)) {
            return CryptoViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found!")
        }
    }
}