package com.shop.cart.service.implservice;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.cart.model.Apparal;
import com.shop.cart.model.builder.ApparalBuilder;
import com.shop.cart.repository.ApparalRepository;
import com.shop.cart.service.ApparalService;

@Service
public class ApparalServiceImpl implements ApparalService {

	private static Logger logger = LoggerFactory.getLogger(ApparalServiceImpl.class);

	@Autowired
	ApparalRepository apparalRepsoitory;

	@Override
	public List<Apparal> getAllApparal() {
		logger.info("All Apparal data has fetched");
		return apparalRepsoitory.findAll();
	}

	@Override
	public Apparal addApparal(Map<String, String> data) {
		Apparal apparal = ApparalServiceImpl.setApparal(data);
		apparalRepsoitory.save(apparal);
		logger.info("Apparal Data has sucessfully saved");
		return apparal;
	}

	public static Apparal setApparal(Map<String, String> data) {
		ApparalBuilder apparalBuilder = new ApparalBuilder();

		String productName = data.get("productName");
		String design = data.get("design");
		String type = data.get("type");
		String brand = data.get("brand");
		float productPrice = Float.parseFloat(data.get("productPrice"));

		return apparalBuilder.setBrand(brand).setDesign(design).setProductName(productName)
				.setProductPrice(productPrice).setType(type).setProductPrice(productPrice).setApparal();
	}
}
