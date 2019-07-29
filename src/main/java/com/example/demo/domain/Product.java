package com.example.demo.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Product {
	
	private long productId;
	
	private String name;
	
	private BigDecimal price;
	
}
