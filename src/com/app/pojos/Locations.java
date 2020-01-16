package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Locations {
	private Integer l_id;
	private String Street;
	private String Area;
	private City city;
	private List<Users> users = new ArrayList<>();
	private List<Restaurant> restaurants = new ArrayList<>();
	
	public Locations() {
		System.out.println("inside locations ctor");
	}

	public Locations(Integer l_id, String street, String area) {
		super();
		this.l_id = l_id;
		Street = street;
		Area = area;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	public Integer getL_id() {
		return l_id;
	}

	public void setL_id(Integer l_id) {
		this.l_id = l_id;
	}
	@Column(name = "street",length = 50,nullable = false)
	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}
	@Column(name = "area",length = 50,nullable = false)
	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Locations [l_id=" + l_id + ", Street=" + Street + ", Area=" + Area + "]";
	}

	@OneToMany(mappedBy = "location",cascade=CascadeType.PERSIST,orphanRemoval=true)
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	@OneToMany(mappedBy="location",cascade=CascadeType.PERSIST,orphanRemoval=true)
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	
	
}
