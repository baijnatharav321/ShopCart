package com.shop.cart.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Comparable<Cart> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	@OneToOne(/* #cascade = CascadeType.ALL */targetEntity=Product.class)
	private List<Product> product = new ArrayList<Product>();

	@ElementCollection
	private Map<Long, Integer> quantity = new HashMap<Long, Integer>();

	public Long getId() {
		return cartId;
	}

	public void setId(Long id) {
		this.cartId = id;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Map<Long, Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(Map<Long, Integer> quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", product=" + product + ", quantity=" + quantity + "]";
	}

	@Override
	public int compareTo(Cart o) {
		return 0;
	}

}
