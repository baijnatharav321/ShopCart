package com.shop.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cart.model.User;
import com.shop.cart.service.UserService;

@RestController
@RequestMapping(value = "/User")
public class UserController {

	@Autowired
	public UserService userService;

	@GetMapping("/Allusers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") long userId) {
		return userService.getUser(userId);
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
