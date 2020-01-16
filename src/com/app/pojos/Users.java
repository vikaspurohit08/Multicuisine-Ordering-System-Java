package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {
	
	private Integer u_id;
	private String firstname;
	private String lastname;
	private String contact;
	private String email;
	private UserRole role;
	private String Password;
	private List<Orders> orders = new ArrayList<>();
	
	
	public Users() {
		System.out.println("Inside User Parameterless Ctor");
	}
	
	
	public Users(String firstname, String lastname, String contact, String email, UserRole role, String password) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.contact = contact;
		this.email = email;
		this.role = role;
		Password = password;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	
	@Column(name="first_name",length = 50,nullable = false)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name="last_name",length = 50,nullable = false)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name="contact",length = 15,nullable = false)
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Column(name="user_email",length = 50,nullable = false,unique = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="user_role",length = 15,nullable = false)
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	@Column(name="password",length = 50,nullable = false)
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	@OneToMany(mappedBy = "user",cascade=CascadeType.PERSIST,orphanRemoval=true)
	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
	
}
