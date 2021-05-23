package com.wezaam.withdrawal.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Withdrawal")
@Table(name = "withdrawals")
public class Withdrawal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "withdrawals_id")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transaction_id")
	private Transaction transaction;

	@OneToOne(mappedBy = "withdrawals")
	@JoinColumn(name = "payment_methods_id", nullable = false)
	private PaymentMethod paymentMethod;

	@Column(name = "amount", nullable = false, columnDefinition = "DOUBLE")
	private Double amount;

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

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public WithdrawalStatus getStatus() {
		return status;
	}

	public void setStatus(WithdrawalStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Withdrawal [id=" + id + ", transaction=" + transaction + ", paymentMethod=" + paymentMethod
				+ ", amount=" + amount + ", createdAt=" + createdAt + ", status=" + status + "]";
	}

}
