package com.shop.cart.service.implservice;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.cart.exceptions.UserNotFoundException;
import com.shop.cart.model.Cart;
import com.shop.cart.model.User;
import com.shop.cart.repository.UserRepository;
import com.shop.cart.service.UserService;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	public UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		List<User> user = userRepository.findAll();
		logger.info("All User from UserTable");
		return user;
	}

	@Override
	public User getUser(long userId) throws UserNotFoundException {

		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			logger.info("User sucessfully found");
			return user.get();
		} else {
			logger.info("User has not found");
			throw new UserNotFoundException("User not Found.");
		}
	}

	@Override
	@Transactional(readOnly = false)
	public User addUser(User user) {
		user.setCart(new Cart());
		logger.info("Add user Successfull");
		return userRepository.save(user);
	}

}
