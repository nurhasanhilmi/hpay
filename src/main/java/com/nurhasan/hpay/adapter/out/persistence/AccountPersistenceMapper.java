package com.nurhasan.hpay.adapter.out.persistence;

import com.nurhasan.hpay.application.domain.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface AccountPersistenceMapper {
    AccountJpaEntity mapToJpaEntity(Account account);
    Account mapToDomainEntity(AccountJpaEntity account);
}
