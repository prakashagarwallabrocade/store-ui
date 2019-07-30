package com.example.demo.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data


public class Product {

	private Long id;
	private String name;
	private BigDecimal price;

	public Product() {
		super();
	}
	
	public Product(Long id, String name, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}


	private Category category;
}