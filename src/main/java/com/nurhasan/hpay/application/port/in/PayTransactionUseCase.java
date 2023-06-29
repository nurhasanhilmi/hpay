package com.nurhasan.hpay.application.port.in;

import com.nurhasan.hpay.application.domain.model.Transaction;

public interface PayTransactionUseCase {

    Transaction pay(Long accountId, Long transactionId);
}
