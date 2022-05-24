package com.zee.zee5Dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/zee5dashboard")
	public String viewHomePage(Model model)
	{
		return "Home";
	}

	
	
}
