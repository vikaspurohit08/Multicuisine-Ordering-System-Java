package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;



@Repository
@Transactional
public class FoodDao implements IFoodDao {
	
	@Autowired
	SessionFactory sf;
	@Autowired
	IRestaurantDao rdao;
	
	List<Integer> ids = new ArrayList<Integer>();
	public List<Integer> addFoodItems(List<FoodItems> fooditems,int rest_id)
	{	
		for (FoodItems fitems : fooditems) {
			System.out.println(fitems.getUnit_price());
			System.out.println(fitems.getItem_name());
			System.out.println(fitems.getCategory());
			 
			 Restaurant rest = rdao.getRestaurantsById(rest_id);
				rest.addFoodItems(fitems);
				fitems.addRestaurant(rest);
				ids.add((Integer) sf.getCurrentSession().save(fitems));
		}
		return ids;
	}
	

}
