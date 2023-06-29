package com.nurhasan.hpay.application.domain.service;

import com.nurhasan.hpay.application.domain.model.Transaction;
import com.nurhasan.hpay.application.port.in.ListTransactionQuery;
import com.nurhasan.hpay.application.port.out.LoadAccountPort;
import com.nurhasan.hpay.application.port.out.LoadTransactionPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListTransactionService implements ListTransactionQuery {

    private final LoadAccountPort loadAccountPort;
    private final LoadTransactionPort loadTransactionPort;

    @Override
    public List<Transaction> getListTransaction(Long accountId) {
        if (loadAccountPort.loadAccount(accountId).isEmpty())
            throw new EntityNotFoundException("Account with id: " + accountId + " does not exist");

        return loadTransactionPort.loadTransactions(accountId);
    }
}
