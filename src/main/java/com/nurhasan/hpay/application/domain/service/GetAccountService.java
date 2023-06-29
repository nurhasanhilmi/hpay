package com.nurhasan.hpay.application.domain.service;

import com.nurhasan.hpay.application.domain.model.Account;
import com.nurhasan.hpay.application.port.in.GetAccountQuery;
import com.nurhasan.hpay.application.port.out.LoadAccountPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GetAccountService implements GetAccountQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Account getAccount(Long id) {
        return loadAccountPort.loadAccount(id)
                .orElseThrow(() -> new EntityNotFoundException("Account with id: " + id + " does not exist"));
    }
}
