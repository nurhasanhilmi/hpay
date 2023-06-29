package com.nurhasan.hpay.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private Long id;
    private Double balance;
}
