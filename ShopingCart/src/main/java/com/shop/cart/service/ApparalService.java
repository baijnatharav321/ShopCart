package com.shop.cart.service;

import java.util.List;
import java.util.Map;

import com.shop.cart.model.Apparal;


public interface ApparalService {

	public List<Apparal> getAllApparal();
	
	public Apparal addApparal( Map<String,String> data );
}
