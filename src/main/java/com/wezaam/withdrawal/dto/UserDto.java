package com.wezaam.withdrawal.dto;

import org.springframework.data.domain.Page;

import com.wezaam.withdrawal.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
	
	private String name;
	private String email;

	public UserDto(User user) {
		this.name = user.getName();
		this.email = user.getEmail();

	}

	public static Page<UserDto> convert(Page<User> users) {
		return users.map(UserDto::new);
	}

}
