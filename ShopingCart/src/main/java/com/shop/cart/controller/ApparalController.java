package com.shop.cart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cart.model.Apparal;
import com.shop.cart.service.ApparalService;

@RestController
@RequestMapping(value = "/Apparal")
public class ApparalController {

	@Autowired
	public ApparalService apparalService;

	@GetMapping("/getAllApparal")
	private List<Apparal> getApparal() {
		return apparalService.getAllApparal();
	}

	@PostMapping("/addApparal")
	private Apparal addApparal(@RequestBody Map<String, String> data) {
		return apparalService.addApparal( data );
	}
}
