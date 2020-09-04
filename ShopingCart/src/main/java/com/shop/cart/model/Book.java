package com.shop.cart.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book extends Product {

	@Column
	private String gener;
	@Column
	private String author;
	@Column
	private String publications;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}

	public Book(String genre, String author, String publications, String productName, float productPrice) {
		super(productName, productPrice);
		this.gener = genre;
		this.author = author;
		this.publications = publications;
	}

	@Override
	public String toString() {
		return "Book [gener=" + gener + ", author=" + author + ", publications=" + publications + "]";
	}

}
