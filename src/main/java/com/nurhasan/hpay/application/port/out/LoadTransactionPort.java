package com.nurhasan.hpay.application.port.out;

import com.nurhasan.hpay.application.domain.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface LoadTransactionPort {

    Optional<Transaction> loadTransaction(Long transactionId);
    List<Transaction> loadTransactions(Long accountId);
}
