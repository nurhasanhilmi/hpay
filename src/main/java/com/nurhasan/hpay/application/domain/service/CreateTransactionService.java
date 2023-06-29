package com.nurhasan.hpay.application.domain.service;

import com.nurhasan.hpay.application.domain.model.Transaction;
import com.nurhasan.hpay.application.domain.model.TransactionStatus;
import com.nurhasan.hpay.application.domain.model.TransactionType;
import com.nurhasan.hpay.application.port.in.CreateTransactionCommand;
import com.nurhasan.hpay.application.port.in.CreateTransactionUseCase;
import com.nurhasan.hpay.application.port.out.LoadAccountPort;
import com.nurhasan.hpay.application.port.out.SaveTransactionPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTransactionService implements CreateTransactionUseCase {

    private final LoadAccountPort loadAccountPort;
    private final SaveTransactionPort saveTransactionPort;

    @Override
    public Transaction createTransaction(CreateTransactionCommand command) {
        var accountId = command.accountId();
        var transactionAmount = command.amount();
        var transactionDescription = command.description();

        var account = loadAccountPort.loadAccount(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account with id: " + accountId + " does not exist"));

        var transaction = new Transaction(
                null,
                account,
                transactionAmount,
                transactionDescription,
                TransactionType.WITHDRAWAL,
                TransactionStatus.PENDING
        );

        return saveTransactionPort.saveTransaction(transaction);
    }
}
