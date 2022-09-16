package com.orthofx.CustomerOrderRelation.ServiceImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.orthofx.CustomerOrderRelation.exception.ResourceNotFoundException;
import com.orthofx.CustomerOrderRelation.model.Customer;
import com.orthofx.CustomerOrderRelation.model.Order;
import com.orthofx.CustomerOrderRelation.repository.OrderRepository;

@Service

public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	//private Object order;
	
	
//	get all order
	public List<Order>getAll() {		
		return this.orderRepository.findAll();
	}
//get by ID
	public ResponseEntity<Order> getCustomerById (Long orderId) throws ResourceNotFoundException{
			Order order = orderRepository.findById(orderId)
			.orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + orderId));
			return ResponseEntity.ok().body(order);
			}
//get customer by order id
	public List<Order> getAll(@PathVariable Long Customer_Id){
        List<Order> orders = new ArrayList<>();
        
		//orderRepository.findByCustomerId(Customer_Id );
        return orders;
	}
//insert order
	  public Order createOrder( @RequestBody Order order, @PathVariable Long id) {
			
			order.setCustomer(new Customer(id,"",""));
	        return orderRepository.save(order);
  }
//update
	  public ResponseEntity<Order> updateOrder( Long orderId,Order OrderDetails) throws ResourceNotFoundException {
			Order order = orderRepository.findById(orderId)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + orderId));
			//order.setOrderId(OrderDetails.getOrderId());
			order.setName(OrderDetails.getName());
			order.setQuantity(OrderDetails.getQuantity());
			orderRepository.save(order);
			return ResponseEntity.ok(order);
}
//delete
	  public Map<String, Boolean> deleteOrder(@PathVariable(value = "orderId") Long orderId)
				throws ResourceNotFoundException {
			Order order = orderRepository.findById(orderId)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + orderId));
			orderRepository.delete(order);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}	
	  
	
	
	
	
	

}
