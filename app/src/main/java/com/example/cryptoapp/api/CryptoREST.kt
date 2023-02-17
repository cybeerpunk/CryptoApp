package com.example.cryptoapp.api

import com.example.cryptoapp.DetalhesCryptoDTO
import com.example.cryptoapp.ListCryptoDTO
import retrofit2.Call

class CryptoREST : BaseREST<ICryptoREST>(ICryptoREST::class.java) {
    fun getListCrypto (): Call<List<ListCryptoDTO>> {
        return service.getListCrypto()
    }
   fun getDetalhesCrypto(idCrypto: String): Call<DetalhesCryptoDTO>{
       return service.getDetalhesCrypto(idCrypto)
   }


}