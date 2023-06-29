package com.nurhasan.hpay.adapter.in.web;

import com.nurhasan.hpay.application.domain.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface AccountOutputMapper {
    AccountOutputEntity mapToOutputEntity(Account account);
}
