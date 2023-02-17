package com.example.cryptoapp.api;

import retrofit2.Retrofit;

abstract public class BaseREST<T> {
    protected T service;
    protected Retrofit retrofit;
    protected BaseREST(Class<T> classType) {
        this.retrofit = CryptoHTTP.create();
        this.service = retrofit.create(classType);

    }

}
