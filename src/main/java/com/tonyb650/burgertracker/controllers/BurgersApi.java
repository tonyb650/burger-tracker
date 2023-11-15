package com.tonyb650.burgertracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tonyb650.burgertracker.models.Burger;
import com.tonyb650.burgertracker.services.BurgerService;

// This file not actually used for the assignment, but used for testing with Postman

@RestController
public class BurgersApi {
	private final BurgerService burgerService;
	
	public BurgersApi(BurgerService burgerService) {
		this.burgerService = burgerService;
	}
	
	@GetMapping("/api/burgers")
	public List<Burger> listAll() {
		return burgerService.allBurgers();
	}
	
	@RequestMapping(value="/api/burgers", method=RequestMethod.POST)
	public Burger create(@RequestParam(value="burgerName") String name, @RequestParam(value="restaurantName") String restaurant, @RequestParam(value="rating") Integer rating, @RequestParam(value="burgerNotes") String notes) {
		Burger burger1 = new Burger(name, restaurant, rating, notes);
		return burgerService.createBurger(burger1);
	}
	@RequestMapping("/api/burgers/{id}")
	public Burger show(@PathVariable("id") Long id) {
		Burger burger = burgerService.findBurger(id);
		return burger;
	}
	
}
