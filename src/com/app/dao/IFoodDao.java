package com.app.dao;

import java.util.List;

import com.app.pojos.FoodItems;
import com.app.pojos.Restaurant;

public interface IFoodDao {

	List<Integer> addFoodItems(List<FoodItems> fooditems,int rest_id);
}
