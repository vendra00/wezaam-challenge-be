package com.wezaam.withdrawal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Transaction")
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id", updatable = false)
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

	@OneToOne(mappedBy = "transaction")
	@JoinColumn(name = "withdrawal_id", nullable = false)
	private Withdrawal withdrawal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Withdrawal getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(Withdrawal withdrawal) {
		this.withdrawal = withdrawal;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", comment=" + comment + ", amount="
				+ amount + ", account=" + account + ", withdrawal=" + withdrawal + "]";
	}

}
