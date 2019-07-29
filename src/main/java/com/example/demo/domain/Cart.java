package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data

public class Cart {
	
	private List<Product> products;
	
	private BigDecimal totalValue;

}
