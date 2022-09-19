package com.orthofx.CustomerOrderRelation.ServiceImplementation;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.orthofx.CustomerOrderRelation.Dto.CustomerDto;
import com.orthofx.CustomerOrderRelation.exception.ResourceNotFoundException;
import com.orthofx.CustomerOrderRelation.model.Customer;
import com.orthofx.CustomerOrderRelation.model.Order;

public interface CustomerServiceInterface {
	public List<Order> getall(Long Id)throws ResourceNotFoundException;;
	
	public List<Customer>findAll();
	
	public ResponseEntity<CustomerDto> getCustomerById(Long Id)throws ResourceNotFoundException;
	
	public Customer createcustomer(@RequestBody CustomerDto customer);
	
	public ResponseEntity<Customer> updateCustomer(Long Id,CustomerDto CustomerDetails) throws ResourceNotFoundException ;
	
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "customerId") Long Id)throws ResourceNotFoundException ;
}
