package com.nurhasan.hpay.application.domain.service;

import com.nurhasan.hpay.application.domain.model.Account;
import com.nurhasan.hpay.application.port.in.CreateAccountUseCase;
import com.nurhasan.hpay.application.port.out.SaveAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CreateAccountService implements CreateAccountUseCase {

    private final SaveAccountPort saveAccountPort;

    @Override
    public Account createAccount() {
        return saveAccountPort.saveAccount(new Account(null, 0.0));
    }
}
