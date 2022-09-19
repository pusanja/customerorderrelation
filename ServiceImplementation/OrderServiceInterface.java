package com.orthofx.CustomerOrderRelation.ServiceImplementation;

import java.util.List;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.orthofx.CustomerOrderRelation.Dto.OrderCustomerDto;
import com.orthofx.CustomerOrderRelation.Dto.OrderDto;
import com.orthofx.CustomerOrderRelation.exception.ResourceNotFoundException;
import com.orthofx.CustomerOrderRelation.model.Order;

public interface OrderServiceInterface {
	public List<Order>getAll();
	
	public ResponseEntity<OrderDto> getCustomerById (Long orderId) throws ResourceNotFoundException;
	
	public void createOrder(  OrderCustomerDto order,  Long id)throws ResourceNotFoundException;
	
	public ResponseEntity<Order> updateOrder( Long orderId,OrderDto SOrderDetails) throws ResourceNotFoundException;
	
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "orderId") Long orderId)
			throws ResourceNotFoundException ;

}
