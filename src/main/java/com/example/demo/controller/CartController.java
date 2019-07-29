package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Cart;
import com.example.demo.domain.Catalog;
import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.service.CartService;
import com.example.demo.service.CatelogService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private CatelogService catelogService;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public String showCartPage(ModelMap model) {

		List<Product> selectedProdsList = new ArrayList<>();
		BigDecimal totalValue = new BigDecimal("0");
		String[] selectedProds = request.getParameterValues("selectedProds");
		RestTemplate restTemplate = new RestTemplate();
		/*
		 * for (int i = 0; i < selectedProds.length; i++) {
		 * System.out.println("CartController.showCalaogPage()" + (selectedProds[i]));
		 * 
		 * String resourceUrl = "http://localhost:8080/product/" + selectedProds[i];
		 * Product product = restTemplate.getForObject(resourceUrl, Product.class);
		 * totalValue= totalValue.add(product.getPrice());
		 * selectedProdsList.add(product); }
		 */

		// ForTimeBeing
		Catalog catalog = catelogService.retrieveCatalog();
		for (int i = 0; i < catalog.getCategories().size(); i++) {
			selectedProdsList = catalog.getCategories().get(0).getProducts();
		}

		Cart cart = new Cart();
		cart.setProducts(selectedProdsList);
		cart.setTotalValue(totalValue);
		model.put("cart", cart);
		return "cart";
	}

}
