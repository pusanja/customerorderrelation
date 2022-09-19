package com.orthofx.CustomerOrderRelation.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customerTable")
public class Customer {
	
	@JsonIgnore
	@OneToMany(fetch= FetchType.EAGER, mappedBy="customer")
    private List<Order> orders=new ArrayList<>();
	 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	public List<Order> getOrders() {
		return orders;
	}
	public void ListOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}

	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Customer(Long Id, String firstName, String lastName) {
        this.Id = Id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer() {}
	

	
	
	

}
