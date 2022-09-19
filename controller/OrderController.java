package com.orthofx.CustomerOrderRelation.controller;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orthofx.CustomerOrderRelation.Dto.OrderCustomerDto;
import com.orthofx.CustomerOrderRelation.Dto.OrderDto;
import com.orthofx.CustomerOrderRelation.ServiceImplementation.OrderServiceInterface;
import com.orthofx.CustomerOrderRelation.exception.ResourceNotFoundException;
import com.orthofx.CustomerOrderRelation.model.Order;

@RestController
@RequestMapping("/api/order/")
public class OrderController {
	@Autowired
	private OrderServiceInterface orderServiceInterface;

	 
	
//getAll
	@GetMapping("allOrders")
	public List<Order>AllOrders() {		
			return this.orderServiceInterface.getAll();
	}
		
	
		
//get By ID
	@GetMapping("{orderId}")
	public ResponseEntity<OrderDto> getCustomerById(@PathVariable(value = "orderId") Long orderId)
	throws ResourceNotFoundException {
	        return orderServiceInterface.getCustomerById(orderId);
	}
	
	
//insert
	@PostMapping("customer/{id}/order")
	public void   createOrder( @RequestBody OrderCustomerDto order, @PathVariable Long id)throws ResourceNotFoundException {
	orderServiceInterface.createOrder(order,id);
    }
		
		
//update
	@RequestMapping(value = "{orderId}", method = RequestMethod.PUT)
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "orderId") Long orderId,
	@Validated @RequestBody OrderDto OrderDetails) throws ResourceNotFoundException {
			return orderServiceInterface.updateOrder(orderId,OrderDetails);
	}
			
			
//deleteByCID
	@RequestMapping(value="/{orderId}", method = RequestMethod.DELETE)
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "orderId") Long orderId)
	throws ResourceNotFoundException {
		    return orderServiceInterface.deleteOrder(orderId);
			}	
		

}
