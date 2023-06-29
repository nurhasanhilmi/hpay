package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.domain.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface TransactionOutputMapper {

    TransactionOutputEntity mapToOutputEntity(Transaction transaction);
}
