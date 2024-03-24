package com.rakib.solidprinciple.repository;

import com.rakib.solidprinciple.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
