package com.shop.cart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cart.model.Product;
import com.shop.cart.service.ProductService;

@RestController
@RequestMapping(value = "/Product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/allproducts")
	public List<Product> getAllProducts() {
		return productService.getAllProduct();
	}

	@GetMapping(value = "/search")
	private List<Product> searchProduct(Map<String, String> data) {
		return productService.searchProduct(data);
	}
}
