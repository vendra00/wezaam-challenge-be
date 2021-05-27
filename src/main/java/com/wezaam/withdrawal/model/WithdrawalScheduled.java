package com.wezaam.withdrawal.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "WithdrawalScheduled")
@Table(name="scheduled_withdrawals")
@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
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

}
