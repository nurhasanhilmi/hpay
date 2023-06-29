package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.port.in.GetAccountQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class GetAccountController {

    private final GetAccountQuery getAccountQuery;
    private final AccountOutputMapper accountOutputMapper;

    @GetMapping("/accounts/{accountId}")
    AccountOutputEntity getAccount(@PathVariable Long accountId) {
        return accountOutputMapper.mapToOutputEntity(getAccountQuery.getAccount(accountId));
    }
}
