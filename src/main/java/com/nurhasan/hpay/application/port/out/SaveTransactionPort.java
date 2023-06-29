package com.nurhasan.hpay.application.port.out;

import com.nurhasan.hpay.application.domain.model.Transaction;

public interface SaveTransactionPort {

    Transaction saveTransaction(Transaction transaction);
}
