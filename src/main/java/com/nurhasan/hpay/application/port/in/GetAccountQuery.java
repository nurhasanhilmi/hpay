package com.nurhasan.hpay.application.port.in;

import com.nurhasan.hpay.application.domain.model.Account;

public interface GetAccountQuery {
    Account getAccount(Long id);
}
