package com.example.demo.domain;

import java.util.List;

import lombok.Data;


@Data

public class Catalog {


	private Long Id;
	private List<Category> categories;
}
