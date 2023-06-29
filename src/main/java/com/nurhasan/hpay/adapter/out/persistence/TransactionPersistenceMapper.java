package com.nurhasan.hpay.adapter.out.persistence;

import com.nurhasan.hpay.application.domain.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface TransactionPersistenceMapper {

    Transaction mapToDomainEntity(TransactionJpaEntity transaction);
    TransactionJpaEntity mapToJpaEntity(Transaction transaction);
}
