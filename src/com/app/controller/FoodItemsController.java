package com.app.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.*;
import com.app.dao.*;

@RestController
@RequestMapping("/fooditems")
@CrossOrigin(origins = "http://localhost:4200")
public class FoodItemsController {

	@Autowired
	IFoodDao fdao;
	@Autowired
	IRestaurantDao rdao;
	
	@GetMapping("/list/{rest_id}")
	public List<FoodItems> getAllItems(@PathVariable String rest_id)
	{
		System.out.println("rest id = " + rest_id);
		Restaurant restaurant = rdao.getRestaurantsById(Integer.parseInt(rest_id));
		System.out.println("restaurant = " + restaurant);
		return restaurant.getFooditems();
	}
	
	
	@PutMapping("/add/{rest_id}")
	public ResponseEntity<?> addFoodItems(@PathVariable String rest_id, @RequestBody List<FoodItems> fooditems)
	{
		
		System.out.println(rest_id);
		for (FoodItems foodItems2 : fooditems) {
			System.out.println(foodItems2);
		}
		return new ResponseEntity<List<Integer>>(fdao.addFoodItems(fooditems,Integer.parseInt(rest_id)), CREATED);
	}
}
