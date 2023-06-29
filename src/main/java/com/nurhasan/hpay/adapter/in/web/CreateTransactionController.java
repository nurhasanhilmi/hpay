package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.port.in.CreateTransactionCommand;
import com.nurhasan.hpay.application.port.in.CreateTransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class CreateTransactionController {

    private final CreateTransactionUseCase createTransactionUseCase;
    private final TransactionOutputMapper transactionOutputMapper;

    @PostMapping("/accounts/{accountId}/transactions")
    TransactionOutputEntity createTransaction(@PathVariable Long accountId,
                                              @RequestBody CreateTransactionInputEntity request) {

        var command = new CreateTransactionCommand(accountId, request.amount(), request.description());
        return transactionOutputMapper.mapToOutputEntity(createTransactionUseCase.createTransaction(command));
    }
}
