package com.wezaam.withdrawal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wezaam.withdrawal.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Account findByAccountNumber(int accountNumber);
}
