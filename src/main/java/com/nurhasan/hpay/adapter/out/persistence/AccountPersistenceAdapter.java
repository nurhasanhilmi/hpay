package com.nurhasan.hpay.adapter.out.persistence;

import com.nurhasan.hpay.application.domain.model.Account;
import com.nurhasan.hpay.application.port.out.LoadAccountPort;
import com.nurhasan.hpay.application.port.out.SaveAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class AccountPersistenceAdapter implements LoadAccountPort, SaveAccountPort {

    private final AccountRepository accountRepository;
    private final AccountPersistenceMapper accountPersistenceMapper;

    @Override
    public Account saveAccount(Account account) {
        var savedAccount = accountRepository.save(accountPersistenceMapper.mapToJpaEntity(account));
        return accountPersistenceMapper.mapToDomainEntity(savedAccount);
    }

    @Override
    public Optional<Account> loadAccount(Long id) {
        return accountRepository.findById(id).map(accountPersistenceMapper::mapToDomainEntity);
    }
}
