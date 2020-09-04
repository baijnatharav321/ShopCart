package com.shop.cart.service.implservice;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.shop.cart.model.Book;
import com.shop.cart.model.builder.BookBuilder;
import com.shop.cart.repository.BookRepository;
import com.shop.cart.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookRepository bookRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Book> getAllBooks() {
		logger.info("All books info is fetched");
		return bookRepo.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Book addBook(Map<String, String> data) {

		Book book = BookServiceImpl.bookMapper(data);
		bookRepo.save(book);
		logger.info("Book Data has sucessfully add");
		return book;
	}

	public static Book bookMapper(Map<String, String> data) {
		BookBuilder bookBuilder = new BookBuilder();
		String productName = data.get("productName");
		String gener = data.get("gener");
		String author = data.get("author");
		String publications = data.get("publications");
		float productPrice = Float.parseFloat(data.get("productPrice"));

		return bookBuilder.setAuthor(author).
				setGener(gener).
				setProductName(productName).
				setPublications(publications)
				.setProductPrice(productPrice).
				bookBuilder();
	}
}
