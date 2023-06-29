package com.nurhasan.hpay.adapter.out.persistence;

import com.nurhasan.hpay.application.domain.model.Transaction;
import com.nurhasan.hpay.application.port.out.LoadTransactionPort;
import com.nurhasan.hpay.application.port.out.SaveTransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class TransactionPersistenceAdapter implements LoadTransactionPort, SaveTransactionPort {

    private final TransactionRepository transactionRepository;
    private final TransactionPersistenceMapper transactionPersistenceMapper;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        var savedTransaction = transactionRepository.save(transactionPersistenceMapper.mapToJpaEntity(transaction));
        return transactionPersistenceMapper.mapToDomainEntity(savedTransaction);
    }

    @Override
    public Optional<Transaction> loadTransaction(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .map(transactionPersistenceMapper::mapToDomainEntity);
    }

    @Override
    public List<Transaction> loadTransactions(Long accountId) {
        return transactionRepository.findByAccount_IdOrderByModifiedAtDesc(accountId).stream()
                .map(transactionPersistenceMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }
}
