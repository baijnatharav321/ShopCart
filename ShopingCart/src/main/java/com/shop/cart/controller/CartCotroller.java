package com.shop.cart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cart.model.Cart;
import com.shop.cart.service.CartService;

@RestController
@RequestMapping("/Cart")
public class CartCotroller {

	@Autowired
	public CartService cartService;

	@GetMapping("/getCarts")
	public List<Cart> getCarts() {
		return cartService.getCarts();
	}

	@GetMapping("/{userId}")
	public Cart getCart(@PathVariable("userId") long userId) {
		return cartService.getCart(userId);
	}

	@PostMapping
	public Cart addCart(@RequestBody Map<String, String> body) {
		return cartService.addToCart(body);
	}

	@PutMapping("/update/{userId}")
	public Cart updateCart(@PathVariable("userId") long userId, @RequestBody Map<String, String> body) {
		return cartService.updateCart(userId, body);
	}

	@DeleteMapping("/{userId}/{productId}")
	public Cart deleteCart(@PathVariable("userId") long userId, @PathVariable("productId") long productId) {
		return cartService.deleteItemFromCart(productId, userId);

	}
	
	@DeleteMapping("/clear/{userId}")
	public Cart deleteWholeCart(@PathVariable("userId") long userId) {
		return cartService.deleteCart(userId);
	}
}
