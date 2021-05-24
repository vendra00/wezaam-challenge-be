package com.wezaam.withdrawal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wezaam.withdrawal.dto.UserDto;
import com.wezaam.withdrawal.model.User;
import com.wezaam.withdrawal.repository.UserRepository;

import io.swagger.annotations.Api;

@Api
@RestController
public class UserController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/find-all-users")
    public List<UserDto> findAll() {
        List<User> users = context.getBean(UserRepository.class).findAll();
        return UserDto.convert(users);
    }

    @GetMapping("/find-user-by-id/{id}")
    public User findById(@PathVariable Long id) {
    	return context.getBean(UserRepository.class).findById(id).orElseThrow();    
    	
		
    }
    
    @GetMapping("/find-user-by-email/{email}")
    public User findByEmail(@PathVariable String email) {
        return context.getBean(UserRepository.class).findByEmail(email);
    }
    
    @GetMapping("/find-user-by-full-name/{fistName+lastName}")
    public User findByUser(@PathVariable String fistName, String lastName) {
        return context.getBean(UserRepository.class).findByFirstNameAndLastName(fistName, lastName);
    }
    
}
