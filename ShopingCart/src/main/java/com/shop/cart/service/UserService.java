package com.shop.cart.service;

import java.util.List;

import com.shop.cart.exceptions.UserNotFoundException;
import com.shop.cart.model.User;


public interface UserService {

	public List<User> getAllUsers();
	
	public User getUser(long userId) throws UserNotFoundException;
	
	public User addUser(User user);
}
