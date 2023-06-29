package com.nurhasan.hpay.adapter.in.web.advice;

import com.nurhasan.hpay.application.domain.service.UnprocessableTransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class UnprocessableTransactionAdvice {

    @ExceptionHandler(UnprocessableTransactionException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String unprocessableTransactionHandler(UnprocessableTransactionException exception) {
        return exception.getMessage();
    }
}
