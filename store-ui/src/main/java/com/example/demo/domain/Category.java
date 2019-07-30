package com.example.demo.domain;

import java.util.List;

import lombok.Data;

@Data
public class Category {

	private Long Id;

	private String name;

	private Catalog catalog;

	private List<Product> products;

}
