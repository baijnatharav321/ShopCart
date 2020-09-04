package com.shop.cart.service;

import java.util.List;
import java.util.Map;

import com.shop.cart.model.Book;


public interface BookService {

	public List<Book> getAllBooks();
	
	public Book addBook(Map<String,String> data);
}
