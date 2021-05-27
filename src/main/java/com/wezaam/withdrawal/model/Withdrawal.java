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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Withdrawal")
@Table(name = "withdrawals")
@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
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

}
