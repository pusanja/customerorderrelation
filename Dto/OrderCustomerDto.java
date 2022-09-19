package com.orthofx.CustomerOrderRelation.Dto;

import com.orthofx.CustomerOrderRelation.model.Customer;

public class OrderCustomerDto {
	private Customer customer;
	private String name;
	private int quantity;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	


}
