package com.rakib.solidprinciple.service.impl;

import com.rakib.solidprinciple.entity.Account;
import com.rakib.solidprinciple.repository.AccountRepository;
import com.rakib.solidprinciple.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public void registerAccount(Account account) {
        accountRepository.save(account);
    }
}
