package com.example.cryptoapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class CryptoHTTP {

    public static Retrofit create() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.coingecko.com/api/v3/coins/list/")
                .build();

    }
}