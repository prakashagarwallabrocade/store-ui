package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Cart;
import com.example.demo.domain.Product;

@Controller
public class CartController {

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public String showCartPage(ModelMap model) {

		List<Product> selectedProdsList = new ArrayList<>();
		BigDecimal totalValue = new BigDecimal("0");
		String[] selectedProds = request.getParameterValues("selectedProds");
		RestTemplate restTemplate = new RestTemplate();
	
		 for (int i = 0; i < selectedProds.length; i++) {		 
		  String resourceUrl = "http://localhost:8080/product/" + selectedProds[i];
		  Product product = restTemplate.getForObject(resourceUrl, Product.class);
		  totalValue= totalValue.add(product.getPrice());
		  selectedProdsList.add(product); 
		  }

		Cart cart = new Cart();
		cart.setProducts(selectedProdsList);
		cart.setTotalValue(totalValue);

		model.put("cart", cart);
		return "cart";
	}

}
