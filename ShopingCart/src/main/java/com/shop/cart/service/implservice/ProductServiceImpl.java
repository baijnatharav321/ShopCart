package com.shop.cart.service.implservice;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.cart.exceptions.ProductNotFoundException;
import com.shop.cart.model.Product;
import com.shop.cart.repository.ProductRepository;
import com.shop.cart.service.ProductService;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

	private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	public ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		logger.info("Get all product Sucessfull");
		return productRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> searchProduct(Map<String, String> data) {
		if (data.get("type") == "book") {
			logger.info("Get Books Sucessfull");
			return productRepository.findOnlyBook();
		} else if (data.get("type") == "Apparal") {
			logger.info("Get Apparal Sucessfull");
			return productRepository.findOnlyApparal();
		} else if (data.get("name") == "name") {
			logger.info("Get Product by Name");
			return productRepository.findByProductName();
		} else
			logger.info("Product not Found");
		throw new ProductNotFoundException("Product Not Found");
	}

}
