package com.rakib.solidprinciple.service.impl;

import com.rakib.solidprinciple.enums.AccountType;
import com.rakib.solidprinciple.service.InterestCalculator;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountInterestCalculator implements InterestCalculator {
    private static final double INTEREST_RATE = 0.05;

    @Override
    public double calculateInterest(double balance) {
        return balance * INTEREST_RATE;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }
}
