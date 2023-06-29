package com.nurhasan.hpay.application.port.out;

import com.nurhasan.hpay.application.domain.model.Account;

import java.util.Optional;

public interface LoadAccountPort {

    Optional<Account> loadAccount(Long id);
}
