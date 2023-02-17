package com.example.cryptoapp.api


import com.example.cryptoapp.DetalhesCryptoDTO
import com.example.cryptoapp.ListCryptoDTO


class ListCryptoRepository {

    fun getListCrypto(): List<ListCryptoDTO>  {
        val response = CryptoREST()
            .getListCrypto()
            .execute()
       if (response.code() != 200 && response.code() != 201)
           throw CryptoException.fromHTTPErrorBody(response.errorBody())
       return response.body()!!

    }

    fun getDetalhesCrypto(idCrypto: String): DetalhesCryptoDTO {
        val response = CryptoREST()
            .getDetalhesCrypto(idCrypto)
            .execute()
        if (response.code() != 200 && response.code() != 201)
            throw CryptoException.fromHTTPErrorBody(response.errorBody())
        return response.body()!!

    }
}
