package com.nurhasan.hpay.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import static com.nurhasan.hpay.common.Validation.validate;

public record CreateTransactionCommand(@NotNull Long accountId,
                                       @NotNull @Positive Double amount,
                                       @NotBlank String description) {

    public CreateTransactionCommand(Long accountId, Double amount, String description) {
        this.accountId = accountId;
        this.amount = amount;
        this.description = description;
        validate(this);
    }
}
