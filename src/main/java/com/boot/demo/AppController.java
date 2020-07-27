package com.boot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	
	@RequestMapping("/products")
	public String getProducts(Model model)
	{
		model.addAttribute("title", "PLP");
		
		return "productListPage";
	}
	
}
