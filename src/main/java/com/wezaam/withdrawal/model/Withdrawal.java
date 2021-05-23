package com.wezaam.withdrawal.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Withdrawal")
@Table(name = "withdrawals")
public class Withdrawal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "withdrawals_id")
	private Long id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "payment_methods_id", nullable = false)
	private PaymentMethod paymentMethod;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Transaction transaction;

	@Column(name = "amount", nullable = false, columnDefinition = "Decimal(10,2) default '0.00'")
	private double amount;

	@Column(name = "created_at", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Instant createdAt;

	@Column(name = "execute_at", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Instant executeAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "withdrawal_status", nullable = false, columnDefinition = "TEXT")
	private WithdrawalStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Instant getExecuteAt() {
		return executeAt;
	}

	public void setExecuteAt(Instant executeAt) {
		this.executeAt = executeAt;
	}

	public WithdrawalStatus getStatus() {
		return status;
	}

	public void setStatus(WithdrawalStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Withdrawal [id=" + id + ", paymentMethod=" + paymentMethod + ", transaction=" + transaction
				+ ", amount=" + amount + ", createdAt=" + createdAt + ", executeAt=" + executeAt + ", status=" + status
				+ "]";
	}

}
