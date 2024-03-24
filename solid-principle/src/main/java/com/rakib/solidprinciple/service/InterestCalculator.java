package com.rakib.solidprinciple.service;

import com.rakib.solidprinciple.enums.AccountType;

public interface InterestCalculator {

    double calculateInterest(double balance);

    AccountType getAccountType();
}
