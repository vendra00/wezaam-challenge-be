package com.wezaam.withdrawal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Transaction")
@Table(name = "transaction")
@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id", updatable = false)
	
	private Long id;

	@Column(name = "comment", nullable = false, columnDefinition = "TEXT")
	private String comment;

	@ManyToOne
	@JoinColumn(name = "accountNumber")
	private Account account;

	@OneToOne(mappedBy = "transaction")
	@JoinColumn(name = "withdrawal_id", nullable = false)
	private Withdrawal withdrawal;

}
