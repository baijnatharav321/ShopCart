package com.shop.cart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.cart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}
