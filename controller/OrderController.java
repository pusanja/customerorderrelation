package com.orthofx.CustomerOrderRelation.controller;

import java.util.ArrayList;
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

import com.orthofx.CustomerOrderRelation.ServiceImplementation.OrderService;
import com.orthofx.CustomerOrderRelation.exception.ResourceNotFoundException;
import com.orthofx.CustomerOrderRelation.model.Order;

@RestController
@RequestMapping("/api/order/")
public class OrderController {
	
	 

	@Autowired
	private OrderService orderService;

	 
	
	//getAll
		@GetMapping("allOrders")
		public List<Order>AllOrders() {		
			return this.orderService.getAll();
		}
		
	
		
		//get By ID
		@GetMapping("{orderId}")
		public ResponseEntity<Order> getCustomerById(@PathVariable(value = "orderId") Long orderId)
		throws ResourceNotFoundException {
		return orderService.getCustomerById(orderId);
		}
		
		//get customer by orderid
	//@GetMapping("/customer/{Customer_id}/order/allorders")
	   // public List<Order> getAll( Long Customer_Id){
	        //return orderService.getAll(Customer_Id);}
	        
			//orderRepository.findByCustomerId(Customer_Id );
	        
//		}   
		//insert
		@PostMapping("customer/{id}/order")
	    public Order createOrder( @RequestBody Order order, @PathVariable Long id) {
	        return orderService.createOrder(order,id);
    }
		
		
		//update
		@RequestMapping(value = "{orderId}", method = RequestMethod.PUT)
		public ResponseEntity<Order> updateOrder(@PathVariable(value = "orderId") Long orderId,
				@Validated @RequestBody Order OrderDetails) throws ResourceNotFoundException {
			return orderService.updateOrder(orderId,OrderDetails);
	}
			
			
		//deleteByCID
			@RequestMapping(value="/{orderId}", method = RequestMethod.DELETE)
			public Map<String, Boolean> deleteOrder(@PathVariable(value = "orderId") Long orderId)
					throws ResourceNotFoundException {
				 return orderService.deleteOrder(orderId);
			}	
		

}
