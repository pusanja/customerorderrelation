package com.orthofx.CustomerOrderRelation.ServiceImplementation;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.orthofx.CustomerOrderRelation.Dto.CustomerDto;
import com.orthofx.CustomerOrderRelation.Dto.CustomerListDto;
import com.orthofx.CustomerOrderRelation.Dto.OrderListDto;
import com.orthofx.CustomerOrderRelation.exception.ResourceNotFoundException;
import com.orthofx.CustomerOrderRelation.model.Customer;
import com.orthofx.CustomerOrderRelation.model.Order;
import com.orthofx.CustomerOrderRelation.repository.CustomerRepository;
@Service
public class CustomerService implements CustomerServiceInterface {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
//	get order by customer
	Customer customer;
	public  List<Order> getall(Long Id) throws ResourceNotFoundException {
		Customer optionalCustomer = customerRepository.findById(Id)
			.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + Id));
			
		OrderListDto orderlist = new OrderListDto();
		orderlist.setorderList(optionalCustomer.getOrders());
		return (orderlist.getorderList());
}
	
//get all customer	
	public List<Customer>findAll() {
		
		CustomerListDto customerdto = new CustomerListDto();
		customerdto.setcustomerList(customerRepository.findAll());
		return (customerdto.getcustomerList());
}
	
	
//get customer by Id
	public ResponseEntity<CustomerDto> getCustomerById(Long Id)throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + Id));
		
		CustomerDto customer1=new CustomerDto();
		customer1.setFirstName(customer.getFirstName());
		customer1.setLastName(customer.getLastName());
		
		return ResponseEntity.ok().body(customer1);
	}

//Insert
	public Customer createcustomer(@RequestBody CustomerDto customer) {
		
		Customer customer1=new Customer();
		customer1.setFirstName(customer.getFirstName());
		customer1.setLastName(customer.getLastName());
		return customerRepository.save(customer1);	
		}
	
//update
	public ResponseEntity<Customer> updateCustomer(Long Id,CustomerDto CustomerDetails) throws ResourceNotFoundException {
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
	
	
	
	


