package com.shop.cart.service;

import java.util.List;
import java.util.Map;

import com.shop.cart.model.Cart;

public interface CartService {

	public List<Cart> getCarts();
	
	public Cart getCart(long userId);
	
	public Cart addToCart(Map<String,String> data);
	
	public Cart updateCart(long userId, Map<String,String> data);
	
	public Cart deleteCart(long userId);

	public Cart deleteItemFromCart(long productId, long userId);
}
