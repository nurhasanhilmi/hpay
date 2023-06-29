package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.port.in.PayTransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class PayTransactionController {

    private final PayTransactionUseCase payTransactionUseCase;
    private final TransactionOutputMapper transactionOutputMapper;

    @PatchMapping("/accounts/{accountId}/transactions/{transactionId}/pay")
    TransactionOutputEntity payTransaction(@PathVariable Long accountId,
                                           @PathVariable Long transactionId) {

        return transactionOutputMapper.mapToOutputEntity(payTransactionUseCase.pay(accountId, transactionId));
    }
}
