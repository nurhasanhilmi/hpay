package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.port.in.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class CreateAccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final AccountOutputMapper accountOutputMapper;

    @PostMapping("/accounts")
    AccountOutputEntity createNewAccount() {
        return accountOutputMapper.mapToOutputEntity(createAccountUseCase.createAccount());
    }

}
