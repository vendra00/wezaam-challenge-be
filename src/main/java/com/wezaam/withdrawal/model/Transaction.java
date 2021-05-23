package com.wezaam.withdrawal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Transaction")
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id", updatable=false)
	private Long id;
	
	@Column(name = "date", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "comment", nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Column(name = "amount", nullable = false, columnDefinition = "DOUBLE")
    private double amount;
	
	@ManyToOne
    @JoinColumn(name = "accountNumber")
    private Account account;

}
