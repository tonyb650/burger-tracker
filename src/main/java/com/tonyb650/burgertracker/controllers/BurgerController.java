package com.tonyb650.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tonyb650.burgertracker.models.Burger;
import com.tonyb650.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	@Autowired
	BurgerService burgerService;
	
	@GetMapping("")
	public String main() {
		return "redirect:/burgers";
	}
	

	@GetMapping("/burgers")
	public String main(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgerList = burgerService.allBurgers();
		model.addAttribute("allBurgers", burgerList);
		return "index.jsp";
	}
	
	@PostMapping("/burgers")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		// handle create new burger here
		if(result.hasErrors()) {
			List<Burger> burgerList = burgerService.allBurgers();
			model.addAttribute("allBurgers", burgerList);
			return "index.jsp";
		} else
		burgerService.createBurger(burger);
		return "redirect:/burgers";
	}
}
