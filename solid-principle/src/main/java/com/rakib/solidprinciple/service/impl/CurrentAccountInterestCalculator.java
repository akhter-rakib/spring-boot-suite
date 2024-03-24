package com.rakib.solidprinciple.service.impl;

import com.rakib.solidprinciple.service.InterestCalculator;
import org.springframework.stereotype.Service;

@Service
public class CurrentAccountInterestCalculator implements InterestCalculator {
    private static final double INTEREST_RATE = 0.02;

    @Override
    public double calculateInterest(double balance) {
        return balance * INTEREST_RATE;
    }
}
