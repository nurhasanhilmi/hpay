package com.nurhasan.hpay.application.port.in;

import com.nurhasan.hpay.application.domain.model.Transaction;

public interface CreateTransactionUseCase {

    Transaction createTransaction(CreateTransactionCommand command);
}
