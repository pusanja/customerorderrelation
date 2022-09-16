package com.orthofx.CustomerOrderRelation.ServiceImplementation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.orthofx.CustomerOrderRelation.exception.ResourceNotFoundException;
import com.orthofx.CustomerOrderRelation.model.Customer;
import com.orthofx.CustomerOrderRelation.model.Order;
import com.orthofx.CustomerOrderRelation.repository.CustomerRepository;
@Service

public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	//private Object customer;
//	get order by customer
	public Set<Order> getall(Long Id) {
		{
			//return orderRepository.findById(customerId);
			Optional<Customer> optionalCustomer = customerRepository.findById(Id);
			if(optionalCustomer.isPresent()) {
				return optionalCustomer.get().getOrders();
			}
			return null;
		}
	}
//get all customer	
	public List<Customer>findAll() {		
		return this.customerRepository.findAll();
	}
	
	
//get customer by Id
	public ResponseEntity<Customer> getCustomerById(Long Id)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + Id));
		return ResponseEntity.ok().body(customer);
	}

//Insert
	public Customer createcustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);	
		}
	
//update
	public ResponseEntity<Customer> updateCustomer(Long Id,Customer CustomerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + Id));
		customer.setFirstName(CustomerDetails.getFirstName());
		customer.setLastName(CustomerDetails.getLastName());
		customerRepository.save(customer);
		return ResponseEntity.ok(customer);
	}
//delete
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "customerId") Long Id)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + Id));
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	}
	
	
	
	


