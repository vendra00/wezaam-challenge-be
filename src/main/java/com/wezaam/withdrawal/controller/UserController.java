package com.wezaam.withdrawal.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wezaam.withdrawal.controller.form.UpdateUserForm;
import com.wezaam.withdrawal.controller.form.UserForm;
import com.wezaam.withdrawal.dto.UserDto;
import com.wezaam.withdrawal.model.User;
import com.wezaam.withdrawal.repository.AccountRepository;
import com.wezaam.withdrawal.repository.UserRepository;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ApplicationContext context;

    @Cacheable(value = "listAllUsers")
    @GetMapping("/find-all-users-dto")
    public Page<UserDto> findAllDto(@PageableDefault(sort= "id", direction = Direction.ASC, page = 0, size = 10) Pageable pageable) {
        Page<User> users = context.getBean(UserRepository.class).findAll(pageable);
        return UserDto.convert(users);
    }
    
    @Cacheable(value = "listAllUsers")
    @GetMapping("/find-all-users")
    public Page<User> findAll(@PageableDefault(sort= "id", direction = Direction.ASC, page = 0, size = 10) Pageable pageable) {	
        return context.getBean(UserRepository.class).findAll(pageable);
    }
    
    @PostMapping
    @Transactional
    @CacheEvict(value = "listAllUsers", allEntries = true)
    public ResponseEntity<UserDto> createUser(@RequestBody @Validated UserForm form, UriComponentsBuilder builder){	
    	User user = form.convert(context.getBean(AccountRepository.class));
    	context.getBean(UserRepository.class).save(user);
    	URI uri = builder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
    	return ResponseEntity.created(uri).body(new UserDto(user));
    }
    
    @PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listAllUsers", allEntries = true)
	public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Validated UpdateUserForm form) {
		Optional<User> optional = context.getBean(UserRepository.class).findById(id);
		if (optional.isPresent()) {
			User user = form.update(id, context.getBean(UserRepository.class));
			return ResponseEntity.ok(new UserDto(user));
		}
		
		return ResponseEntity.notFound().build();
	}
    
    @DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listAllUsers", allEntries = true)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<User> optional = context.getBean(UserRepository.class).findById(id);
		if (optional.isPresent()) {
			context.getBean(UserRepository.class).deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

    @GetMapping("/find-user-by-id/{id}")
    public User findById(@PathVariable Long id) {
    	return context.getBean(UserRepository.class).findById(id).orElseThrow();    
		
    }
    
    @GetMapping("/find-user-by-email/{email}")
    public User findByEmail(@PathVariable String email) {
        return context.getBean(UserRepository.class).findByEmail(email);
    }
    
    @GetMapping("/find-user-by-full-name/{name}")
    public User findByUser(@PathVariable String name) {
        return context.getBean(UserRepository.class).findByName(name);
    }
    
}
