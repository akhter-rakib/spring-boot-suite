package com.rakib.solidprinciple.service.impl;

import com.rakib.solidprinciple.entity.Account;
import com.rakib.solidprinciple.repository.AccountRepository;
import com.rakib.solidprinciple.service.AccountService;
import com.rakib.solidprinciple.service.CalculatorFactory;
import com.rakib.solidprinciple.service.InterestCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CalculatorFactory calculatorFactory;

    @Override
    public void registerAccount(Account account) {
        InterestCalculator calculator = calculatorFactory.dispatchInterestCalculator(account.getAccountType());
        account.setInterest(calculator.calculateInterest(account.getInterest()));
        accountRepository.save(account);
    }
}
