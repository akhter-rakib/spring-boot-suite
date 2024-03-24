package com.rakib.solidprinciple.service;

import com.rakib.solidprinciple.enums.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CalculatorFactory {

    private Map<AccountType, InterestCalculator> map;


    @Autowired
    private void interestCalculatorFactory(Set<InterestCalculator> interestCalculators) {
        createStrategy(interestCalculators);
    }

    private void createStrategy(Set<InterestCalculator> interestCalculators) {
        map = new HashMap<>();
        interestCalculators.forEach(interestCalculator ->
                map.put(interestCalculator.getAccountType(), interestCalculator));
    }

    public InterestCalculator dispatchInterestCalculator(AccountType accountType) {
        return map.get(accountType);
    }
}
