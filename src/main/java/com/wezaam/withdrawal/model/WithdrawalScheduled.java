package com.wezaam.withdrawal.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "scheduled_withdrawals")
public class WithdrawalScheduled {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "withdrawal_scheduled_id")
	private Long id;

	@Column(name = "transaction_id", nullable = false)
	private Long transactionId;

	@Column(name = "amount", nullable = false)
	private Double amount;

	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@Column(name = "execute_at", nullable = false)
	private Instant executeAt;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	@Column(name = "paymentMethod_id", nullable = false)
	private Long paymentMethodId;

	@Enumerated(EnumType.STRING)
	@Column(name = "withdrawal_status", nullable = false)
	private WithdrawalStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Instant getExecuteAt() {
		return executeAt;
	}

	public void setExecuteAt(Instant executeAt) {
		this.executeAt = executeAt;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public WithdrawalStatus getStatus() {
		return status;
	}

	public void setStatus(WithdrawalStatus status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	@Override
	public String toString() {
		return "WithdrawalScheduled [id=" + id + ", transactionId=" + transactionId + ", amount=" + amount
				+ ", createdAt=" + createdAt + ", executeAt=" + executeAt + ", userId=" + userId + ", paymentMethodId="
				+ paymentMethodId + ", status=" + status + "]";
	}

}
