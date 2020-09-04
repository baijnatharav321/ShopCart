package com.shop.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.cart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value="select p from PRODUCT where lower(p.product_type) = lower(book)", nativeQuery=true)
	public List<Product> findOnlyBook();

	@Query(value="select p from PRODUCT where lower(p.product_type) = lower(apparal)",nativeQuery=true)
	public List<Product> findOnlyApparal();

	@Query(value ="select p from PRODUCT where product_name =?1", nativeQuery=true)
	public List<Product> findByProductName();

}
