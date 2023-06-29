package com.nurhasan.hpay.application.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {
    private Long id;
    private Account account;
    private Double amount;
    private String description;
    private TransactionType type;
    private TransactionStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Transaction(Long id, Account account, Double amount, String description, TransactionType type, TransactionStatus status) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.status = status;
    }
}
