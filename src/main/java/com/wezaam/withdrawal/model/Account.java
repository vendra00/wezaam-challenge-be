package com.wezaam.withdrawal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Account")
@Table(name = "account", uniqueConstraints = {
		@UniqueConstraint(name = "account_account_number_unique", columnNames = "account_number") })
@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Transaction> transactionList = new ArrayList<>();

	@Column(name = "account_number", nullable = false)
	private Integer accountNumber;
	
	@Column(name = "max_withdrawal_amount", nullable = false, columnDefinition = "Decimal(10,2) default '0.00'")
	private double maxWithdrawalAmount;

	@Column(name = "balance", nullable = false, columnDefinition = "Decimal(10,2) default '0.00'")
	private double balance;

}
