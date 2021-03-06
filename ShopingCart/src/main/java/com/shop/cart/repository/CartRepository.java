package com.shop.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.cart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
