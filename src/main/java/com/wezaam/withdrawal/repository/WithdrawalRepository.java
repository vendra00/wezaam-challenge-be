package com.wezaam.withdrawal.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wezaam.withdrawal.model.Withdrawal;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
	
	List<Withdrawal> findAllByExecuteAtBefore(Instant date);
}
