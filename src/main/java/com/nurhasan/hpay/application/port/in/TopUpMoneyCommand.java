package com.nurhasan.hpay.application.port.in;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import static com.nurhasan.hpay.common.Validation.validate;

public record TopUpMoneyCommand(
        @NotNull Long accountId,
        @NotNull @Positive Double amount) {

    public TopUpMoneyCommand(Long accountId, Double amount) {
        this.accountId = accountId;
        this.amount = amount;
        validate(this);
    }
}
