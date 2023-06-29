package com.nurhasan.hpay.application.domain.service;

public class UnprocessableTransactionException extends RuntimeException {

    public UnprocessableTransactionException(String message) {
        super(message);
    }
}
