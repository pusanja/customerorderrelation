package com.orthofx.CustomerOrderRelation.Dto;

import java.util.List;

import com.orthofx.CustomerOrderRelation.model.Customer;


public class CustomerListDto {
	private List<Customer> customerList;
	public List<Customer> getcustomerList(){
	return customerList;
	}
	public void setcustomerList(List<Customer> customerList) {
	this.customerList = customerList;
	}
	    
}
