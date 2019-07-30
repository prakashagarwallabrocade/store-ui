package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Catalog;

@Service
public class CatelogService {

	public Catalog retrieveCatalog() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://localhost:8080/catalog";
		ResponseEntity<Catalog[]> response =restTemplate.getForEntity(
				resourceUrl, Catalog[].class);
		return Arrays.asList(response.getBody()).get(0);	
	}

}
