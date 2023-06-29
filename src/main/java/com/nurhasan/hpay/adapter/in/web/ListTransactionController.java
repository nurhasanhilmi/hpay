package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.port.in.ListTransactionQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
class ListTransactionController {

    private final ListTransactionQuery listTransactionQuery;
    private final TransactionOutputMapper transactionOutputMapper;

    @GetMapping("/accounts/{accountId}/transactions")
    List<TransactionOutputEntity> getAllTransactions(@PathVariable Long accountId) {
        return listTransactionQuery.getListTransaction(accountId).stream()
                .map(transactionOutputMapper::mapToOutputEntity)
                .collect(Collectors.toList());
    }
}
