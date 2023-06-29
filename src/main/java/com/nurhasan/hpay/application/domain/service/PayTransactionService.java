package com.nurhasan.hpay.application.domain.service;

import com.nurhasan.hpay.application.domain.model.Transaction;
import com.nurhasan.hpay.application.domain.model.TransactionStatus;
import com.nurhasan.hpay.application.domain.model.TransactionType;
import com.nurhasan.hpay.application.port.in.PayTransactionUseCase;
import com.nurhasan.hpay.application.port.out.LoadAccountPort;
import com.nurhasan.hpay.application.port.out.LoadTransactionPort;
import com.nurhasan.hpay.application.port.out.SaveAccountPort;
import com.nurhasan.hpay.application.port.out.SaveTransactionPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayTransactionService implements PayTransactionUseCase {

    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;
    private final LoadTransactionPort loadTransactionPort;
    private final SaveTransactionPort saveTransactionPort;

    @Override
    public Transaction pay(Long accountId, Long transactionId) {
        var account = loadAccountPort.loadAccount(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account with id: " + accountId + " does not exist"));

        var transaction = loadTransactionPort.loadTransaction(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction with id: " + transactionId + " does not exist"));

        if (!accountId.equals(transaction.getAccount().getId()))
            throw new EntityNotFoundException("Transaction with id: " + transactionId + " does not exist for account with id: " + accountId);

        if (!transaction.getType().equals(TransactionType.WITHDRAWAL))
            throw new UnprocessableTransactionException("Transaction with id: " + transactionId + " is not WITHDRAWAL type");

        if (!transaction.getStatus().equals(TransactionStatus.PENDING))
            throw new UnprocessableTransactionException("Transaction with id: " + transactionId + " is in " + transaction.getStatus() + " status");

        if (account.getBalance() < transaction.getAmount())
            throw new UnprocessableTransactionException("Insufficient account balance");

        account.setBalance(account.getBalance() - transaction.getAmount());
        transaction.setAccount(account);
        transaction.setStatus(TransactionStatus.SUCCEED);

        saveAccountPort.saveAccount(account);
        saveTransactionPort.saveTransaction(transaction);

        return transaction;
    }
}
