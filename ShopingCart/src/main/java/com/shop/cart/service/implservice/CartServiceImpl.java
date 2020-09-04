package com.shop.cart.service.implservice;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.cart.exceptions.CartEmptyException;
import com.shop.cart.exceptions.ProductNotFoundException;
import com.shop.cart.exceptions.UserNotFoundException;
import com.shop.cart.model.Cart;
import com.shop.cart.model.Product;
import com.shop.cart.model.User;
import com.shop.cart.repository.CartRepository;
import com.shop.cart.repository.ProductRepository;
import com.shop.cart.repository.UserRepository;
import com.shop.cart.service.CartService;

@Service
@Transactional(readOnly = false)
public class CartServiceImpl implements CartService {

	private Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	public CartRepository cartRepository;

	@Autowired
	public UserRepository userRepo;

	@Autowired
	public ProductRepository productRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Cart> getCarts() {
		logger.info("Get All Carts Sucessfully");
		return cartRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cart getCart(long userId) {
		Optional<User> userOptional = userRepo.findById(userId);
		if (userOptional.isPresent()) {
			if (userOptional.get().getCart() != null) {
				logger.info("Get Cart Sucessfull");
				return userOptional.get().getCart();
			} else {
				logger.info("Cart Not Found");
				throw new CartEmptyException("Cart not Found");
			}
		} else {
			logger.info("User not found");
			throw new UserNotFoundException("User not Found");
		}
	}

	@Override
	@Transactional(readOnly=false)
	public Cart addToCart(Map<String, String> data) {
		Long userId;
		Long productId;

		userId = Long.parseLong(data.get("userId"));
		productId = Long.parseLong(data.get("productId"));

		Optional<User> userOptional = userRepo.findById(userId);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			Optional<Product> productOptional = productRepo.findById(productId);
			logger.info("product" + productOptional.toString());
			if (productOptional.isPresent()) {
				Product product = productOptional.get();
				if (user.getCart().getQuantity().containsKey(productId)) {
					user.getCart().getQuantity().put(productId, user.getCart().getQuantity().get(productId) + 1);
				} else {
					user.getCart().getProduct().add(product);
					user.getCart().getQuantity().put(productId, 1);
				}
				logger.info("Add Cart Sucessfully");
				return userRepo.save(user).getCart();
			} else {
				logger.info("Product not Found");
				throw new ProductNotFoundException("Product not Found Exceptionn");
			}
		} else {
			logger.info("User not Found");
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	@Transactional(readOnly = false)
	public Cart updateCart(long userId, Map<String, String> data) {
		Long productId;
		productId = Long.parseLong(data.get("productId"));
		Optional<User> userOptional = userRepo.findById(userId);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			if (user.getCart().getQuantity().containsKey(productId)) {
				if (user.getCart().getQuantity().get(productId) > 1) {
					user.getCart().getQuantity().put(productId, user.getCart().getQuantity().get(productId) - 1);
				} else {
					Product product = productRepo.findById(productId).get();
					user.getCart().getQuantity().remove(productId);
					user.getCart().getProduct().remove(user.getCart().getProduct().indexOf(product));
				}
				logger.info("Cart Updated Sucessfully");
				return userRepo.save(user).getCart();
			} else {
				logger.info("Product Not found");
				throw new ProductNotFoundException("Product Not fournd");
			}
		} else {
			logger.info("User not Found Exception");
			throw new UserNotFoundException("User Not Found");
		}

	}

	@Override
	@Transactional(readOnly = false)
	public Cart deleteItemFromCart(long productId, long userId) {
		Optional<User> userOptional = userRepo.findById(userId);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			if (user.getCart().getQuantity().containsKey(productId)) {
				Product product = productRepo.findById(productId).get();
				user.getCart().getQuantity().remove(productId);
				user.getCart().getProduct().remove(user.getCart().getProduct().indexOf(product));
			}
			logger.info("Product Deleted form the Cart Sucessfully");
			return userRepo.save(user).getCart();
		} else
			logger.info("User Not Found");
		throw new UserNotFoundException("User not found");
	}

	@Override
	@Transactional(readOnly=false)
	public Cart deleteCart(long userId) {
		Optional<User> userOptional = userRepo.findById(userId);
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			user.getCart().getProduct().clear();
			user.getCart().getQuantity().clear();
			logger.info("All Cart Product are removed");
			return userRepo.save(user).getCart();
		}else {
			logger.info("User Not Found");
			throw new UserNotFoundException("User not Found");
		}
	}

}
