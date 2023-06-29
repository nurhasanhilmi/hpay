package com.nurhasan.hpay.application.port.in;

import com.nurhasan.hpay.application.domain.model.Transaction;

public interface TopUpMoneyUseCase {
    Transaction topUp(TopUpMoneyCommand command);
}
