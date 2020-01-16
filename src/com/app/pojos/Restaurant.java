package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="restaurant")
public class Restaurant {

	private Integer rest_id;
	private String rest_name;
	private String rest_contact;
	private String rest_email;
	private RestStatus rest_status;
	private float rest_rating;
	private byte[] rest_image;
	private RestType rest_type;
	
	
	public Restaurant() {
		System.out.println("Restaurant Parameterless Ctor");
	}
	
	
	public Restaurant(String rest_name, String rest_contact, String rest_email, RestStatus rest_status,
			float rest_rating, RestType rest_type) {
		
		this.rest_name = rest_name;
		this.rest_contact = rest_contact;
		this.rest_email = rest_email;
		this.rest_status = rest_status;
		this.rest_rating = rest_rating;
		this.rest_type = rest_type;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getRest_id() {
		return rest_id;
	}
	public void setRest_id(Integer rest_id) {
		this.rest_id = rest_id;
	}
	
	@Column(length = 100,nullable = false)
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	
	@Column(length = 15,nullable = false)
	public String getRest_contact() {
		return rest_contact;
	}
	public void setRest_contact(String rest_contact) {
		this.rest_contact = rest_contact;
	}
	
	@Column(length = 50,nullable = false,unique=true)
	public String getRest_email() {
		return rest_email;
	}
	public void setRest_email(String rest_email) {
		this.rest_email = rest_email;
	}
	
	@Column(length = 50,nullable = false)
	public RestStatus getRest_status() {
		return rest_status;
	}
	public void setRest_status(RestStatus rest_status) {
		this.rest_status = rest_status;
	}
	
	@Column(nullable = false)
	public float getRest_rating() {
		return rest_rating;
	}
	public void setRest_rating(float rest_rating) {
		this.rest_rating = rest_rating;
	}
	public byte[] getRest_image() {
		return rest_image;
	}
	public void setRest_image(byte[] rest_image) {
		this.rest_image = rest_image;
	}
	
	@Column(length = 50,nullable = false)
	public RestType getRest_type() {
		return rest_type;
	}
	public void setRest_type(RestType rest_type) {
		this.rest_type = rest_type;
	}
	
	
	
}
