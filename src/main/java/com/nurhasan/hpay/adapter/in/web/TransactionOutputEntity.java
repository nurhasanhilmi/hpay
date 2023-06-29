package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.domain.model.TransactionStatus;
import com.nurhasan.hpay.application.domain.model.TransactionType;

import java.time.LocalDateTime;

record TransactionOutputEntity(Long id,
                               AccountOutputEntity account,
                               Double amount,
                               String description,
                               TransactionType type,
                               TransactionStatus status,
                               LocalDateTime createdAt,
                               LocalDateTime modifiedAt) {
}
