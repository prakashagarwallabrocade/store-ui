package com.example.demo.domain;

import java.util.List;

import lombok.Data;

@Data
public class Category {
	
	
	private String name;

	private List<Product> products;

	

}
