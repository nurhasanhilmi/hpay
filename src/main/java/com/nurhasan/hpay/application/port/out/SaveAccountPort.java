package com.nurhasan.hpay.application.port.out;

import com.nurhasan.hpay.application.domain.model.Account;

public interface SaveAccountPort {
    Account saveAccount(Account account);
}
