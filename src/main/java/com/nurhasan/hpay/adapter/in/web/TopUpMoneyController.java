package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.port.in.TopUpMoneyCommand;
import com.nurhasan.hpay.application.port.in.TopUpMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class TopUpMoneyController {

    private final TopUpMoneyUseCase topUpMoneyUseCase;
    private final TransactionOutputMapper transactionOutputMapper;

    @PostMapping("/accounts/{accountId}/topup")
    TransactionOutputEntity topUp(@PathVariable Long accountId,
                              @RequestBody TopUpMoneyInputEntity request) {

        var command = new TopUpMoneyCommand(accountId, request.amount());
        return transactionOutputMapper.mapToOutputEntity(topUpMoneyUseCase.topUp(command));
    }
}
