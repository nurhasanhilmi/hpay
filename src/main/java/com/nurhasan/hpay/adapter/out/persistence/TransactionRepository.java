package com.nurhasan.hpay.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface TransactionRepository extends JpaRepository<TransactionJpaEntity, Long> {

    List<TransactionJpaEntity> findByAccount_IdOrderByModifiedAtDesc(Long account_id);
}
