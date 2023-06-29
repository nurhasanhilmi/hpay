package com.nurhasan.hpay.application.port.in;

import com.nurhasan.hpay.application.domain.model.Transaction;

import java.util.List;

public interface ListTransactionQuery {

    List<Transaction> getListTransaction(Long accountId);
}
