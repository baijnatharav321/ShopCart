package com.shop.cart.model.builder;

import com.shop.cart.model.Apparal;

public class ApparalBuilder {

	private String productName;
	private float productPrice;
	private String type;
	private String design;
	private String brand;
	
	public ApparalBuilder setProductName(String productName) {
		this.productName = productName;
		return this;
	}
	public ApparalBuilder setProductPrice(float productPrice) {
		this.productPrice = productPrice;
		return this;
	}
	public ApparalBuilder setType(String type) {
		this.type = type;
		return this;
	}
	public ApparalBuilder setDesign(String design) {
		this.design = design;
		return this;
	}
	public ApparalBuilder setBrand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public Apparal setApparal() {
		Apparal apparal = new Apparal(productName, productPrice, type, design, brand);
		return apparal;
	}
	
}
