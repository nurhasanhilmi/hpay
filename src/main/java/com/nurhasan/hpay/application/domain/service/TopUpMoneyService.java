package com.nurhasan.hpay.application.domain.service;

import com.nurhasan.hpay.application.domain.model.Transaction;
import com.nurhasan.hpay.application.domain.model.TransactionStatus;
import com.nurhasan.hpay.application.domain.model.TransactionType;
import com.nurhasan.hpay.application.port.in.TopUpMoneyCommand;
import com.nurhasan.hpay.application.port.in.TopUpMoneyUseCase;
import com.nurhasan.hpay.application.port.out.LoadAccountPort;
import com.nurhasan.hpay.application.port.out.SaveAccountPort;
import com.nurhasan.hpay.application.port.out.SaveTransactionPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopUpMoneyService implements TopUpMoneyUseCase {

    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;
    private final SaveTransactionPort saveTransactionPort;

    @Override
    public Transaction topUp(TopUpMoneyCommand command) {
        var accountId = command.accountId();
        var amount = command.amount();

        var account = loadAccountPort.loadAccount(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account with id: " + accountId + " does not exist"));

        account.setBalance(account.getBalance() + amount);
        saveAccountPort.saveAccount(account);

        var topUpTransaction = new Transaction(
                null,
                account,
                amount,
                "Top up via bank",
                TransactionType.DEPOSIT,
                TransactionStatus.SUCCEED
                );

        return saveTransactionPort.saveTransaction(topUpTransaction);
    }
}
