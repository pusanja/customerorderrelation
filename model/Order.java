package com.orthofx.CustomerOrderRelation.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderTable")
public class Order {
	
	@ManyToOne
		private Customer customer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(name="ordername")
	private String name;
	
	@Column(name="quantity")
	private int quantity;
	
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Order(String name, int quantity, Customer customer) {
		super();
		this.customer = new Customer("","");
		this.name = name;
		this.quantity = quantity;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Order() {
		super();
	}
	
	

}
