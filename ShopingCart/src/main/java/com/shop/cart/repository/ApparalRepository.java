package com.shop.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.cart.model.Apparal;

@Repository
public interface ApparalRepository extends JpaRepository<Apparal, Long> {

}
