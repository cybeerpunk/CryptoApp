package com.example.cryptoapp.api

import com.example.cryptoapp.DetalhesCryptoDTO
import com.example.cryptoapp.ListCryptoDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ICryptoREST {
    @GET ("https://api.coingecko.com/api/v3/coins/list")
    fun getListCrypto(): Call<List<ListCryptoDTO>>

    @GET ("https://api.coingecko.com/api/v3/coins/{idCoin}")
    fun getDetalhesCrypto(
    @Path ("idCoin")  idCoin: String
    ): Call<DetalhesCryptoDTO>


}