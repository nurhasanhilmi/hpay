package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.port.in.RefundTransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class RefundTransactionController {

    private final RefundTransactionUseCase refundTransactionUseCase;
    private final TransactionOutputMapper transactionOutputMapper;

    @PatchMapping("/accounts/{accountId}/transactions/{transactionId}/refund")
    TransactionOutputEntity refundTransaction(@PathVariable Long accountId,
                                              @PathVariable Long transactionId) {

        return transactionOutputMapper.mapToOutputEntity(refundTransactionUseCase.refund(accountId, transactionId));
    }

}
