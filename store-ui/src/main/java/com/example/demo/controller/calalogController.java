package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.CatelogService;

@Controller
public class calalogController {
	
	@Autowired
	private CatelogService  catelogService;
	
	@RequestMapping(value="/catalog", method = RequestMethod.GET)
    public String showCalaogPage(ModelMap model){
		//System.out.println("calalogController.showCalaogPage()::catelogService.retrieveCatalog():: "+catelogService.retrieveCatalog());
		model.put("catalog", catelogService.retrieveCatalog());
	       return "catalog";
    }

}
