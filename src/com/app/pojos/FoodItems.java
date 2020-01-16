package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "fooditems")
public class FoodItems {

	private Integer fi_id;
	private String item_name;
	private Double unit_price;
	private Category category;
	
	public FoodItems() {
		System.out.println("inside fooditems ctor");
	}

	public FoodItems(String item_name, Double unit_price, Category category) {
		super();
		this.item_name = item_name;
		this.unit_price = unit_price;
		this.category = category;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fooditem_id")
	public Integer getFi_id() {
		return fi_id;
	}

	public void setFi_id(Integer fi_id) {
		this.fi_id = fi_id;
	}
	@Column(name = "itemname",length = 30,nullable = false)
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	@Column(name = "unit_price",nullable = false)
	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}
	@Column(name = "category",nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "FoodItems [fi_id=" + fi_id + ", item_name=" + item_name + ", unit_price=" + unit_price + ", category="
				+ category + "]";
	}
	
	
}
