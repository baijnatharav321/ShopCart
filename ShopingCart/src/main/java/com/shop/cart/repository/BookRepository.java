package com.shop.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.cart.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
