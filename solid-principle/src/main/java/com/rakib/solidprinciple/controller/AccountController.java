package com.rakib.solidprinciple.controller;

import com.rakib.solidprinciple.entity.Account;
import com.rakib.solidprinciple.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts")
    public void registerAccount(@RequestBody Account account) {
        accountService.registerAccount(account);
    }

}
