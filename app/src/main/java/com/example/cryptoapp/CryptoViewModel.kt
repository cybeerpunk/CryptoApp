package com.example.cryptoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.api.ListCryptoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoViewModel (val mRepository: ListCryptoRepository) : ViewModel(){
    private var _listCryptoDTO = MutableLiveData<List<ListCryptoDTO>>()
    val mListCryptoDTO: LiveData<List<ListCryptoDTO>> get() = _listCryptoDTO

    private var _detalhesCrypto = MutableLiveData<DetalhesCryptoDTO>()
    val mDetalhesCryptoDTO: LiveData<DetalhesCryptoDTO> get() = _detalhesCrypto

    private var _response = MutableLiveData<String>()
    val mResponse: LiveData<String> get() = _response

    fun getListCrypto (){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _listCryptoDTO.postValue(mRepository.getListCrypto())
            } catch (e: Exception) {
                _response.postValue(e.message.toString())
            }
        }
    }
    fun getDetalhesCrypto(aIdCrypto: String){
        CoroutineScope(Dispatchers.IO).launch {
            try{
                _detalhesCrypto.postValue(mRepository.getDetalhesCrypto(aIdCrypto))
            }catch (e: Exception){
                _response.postValue(e.message.toString())
            }
        }
    }
}