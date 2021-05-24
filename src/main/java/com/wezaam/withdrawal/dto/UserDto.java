package com.wezaam.withdrawal.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.wezaam.withdrawal.model.User;

public class UserDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private double maxWithdrawalAmount;

	public UserDto(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.maxWithdrawalAmount = user.getMaxWithdrawalAmount();
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public double getMaxWithdrawalAmount() {
		return maxWithdrawalAmount;
	}

	public static List<UserDto> convert(List<User> users) {
		return users.stream().map(UserDto::new).collect(Collectors.toList());
	}
	
}
