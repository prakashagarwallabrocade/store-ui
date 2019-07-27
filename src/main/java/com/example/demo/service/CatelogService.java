package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Catalog;

@Service
public class CatelogService {

	public Catalog retrieveCatalog() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://localhost:8080/catalog";
		Catalog catalog = restTemplate.getForObject(resourceUrl, Catalog.class);

		return catalog;
	}

}
