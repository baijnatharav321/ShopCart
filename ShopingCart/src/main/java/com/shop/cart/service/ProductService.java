package com.shop.cart.service;

import java.util.List;
import java.util.Map;

import com.shop.cart.model.Product;

public interface ProductService {

	public List<Product> getAllProduct();
	
	public List<Product> searchProduct(Map<String, String> data);
}
