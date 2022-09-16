package com.orthofx.CustomerOrderRelation.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orthofx.CustomerOrderRelation.ServiceImplementation.CustomerService;
import com.orthofx.CustomerOrderRelation.exception.ResourceNotFoundException;
import com.orthofx.CustomerOrderRelation.model.Customer;
import com.orthofx.CustomerOrderRelation.model.Order;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	//get order by customer Id
	@GetMapping("customerId/{id}")
	public Set<Order> getall(@PathVariable(value = "id") long  id){
		return customerService.getall(id);
	}
	
	//getAll
	@GetMapping("allCustomers")
	public List<Customer>AllCustomers() {		
		try {
			return this.customerService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	//getBy ID
	@GetMapping("{customerId}")
	
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "customerId") Long customerId) throws ResourceNotFoundException{
		return customerService.getCustomerById(customerId);
	}
	
	//insert
	@PostMapping("customer")
	public Customer createCustomer(@RequestBody Customer customer) {
	return customerService.createcustomer(customer);	
	}	
	
	//update
	@RequestMapping(value = "{Id}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "Id") Long Id,
    @RequestBody Customer CustomerDetails) throws ResourceNotFoundException {
		return customerService.updateCustomer(Id,CustomerDetails);
		
	}
  //deleteByID
	@RequestMapping(value="/{customerId}", method = RequestMethod.DELETE)
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "customerId") Long customerId)
			throws ResourceNotFoundException {
		return customerService.deleteCustomer(customerId);
	}

}
