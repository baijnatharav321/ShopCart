package com.shop.cart.model.builder;

import com.shop.cart.model.Book;

public class BookBuilder {

	private String productName;
	private float productPrice;
	private String gener;
	private String author;
	private String publications;
	
	public BookBuilder setProductName(String productName) {
		this.productName = productName;
		return this;
	}
	public BookBuilder setProductPrice(float productPrice) {
		this.productPrice = productPrice;
		return this;		
	}
	public BookBuilder setGener(String gener) {
		this.gener = gener;
		return this;
	}
	public BookBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}
	public BookBuilder setPublications(String publications) {
		this.publications = publications;
		return this;
	}
	
	public Book bookBuilder() {
		Book book = new Book(gener, author, publications, productName, productPrice);
		return book;
	}
}
