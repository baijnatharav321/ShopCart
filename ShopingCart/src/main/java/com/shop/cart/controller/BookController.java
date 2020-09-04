package com.shop.cart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cart.model.Book;
import com.shop.cart.service.BookService;

@RestController
@RequestMapping(value="/books")
public class BookController {
	
	@Autowired
	public BookService bookservice;
	
	@GetMapping("/getBooks")
	public List<Book> getAllBooks(){
		return bookservice.getAllBooks();
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Map<String,String> data) {
		return bookservice.addBook(data);
	}
}
