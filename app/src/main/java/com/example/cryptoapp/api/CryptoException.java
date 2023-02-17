package com.example.cryptoapp.api;


public class CryptoException extends BaseHTTPException {
        public CryptoException (String errorMessage) {
            super(errorMessage);
        }
    }

