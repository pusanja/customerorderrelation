package com.orthofx.CustomerOrderRelation.ServiceImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.orthofx.CustomerOrderRelation.Dto.OrderCustomerDto;
import com.orthofx.CustomerOrderRelation.Dto.OrderDto;
import com.orthofx.CustomerOrderRelation.Dto.OrderListDto;
import com.orthofx.CustomerOrderRelation.exception.ResourceNotFoundException;
import com.orthofx.CustomerOrderRelation.model.Customer;
import com.orthofx.CustomerOrderRelation.model.Order;
import com.orthofx.CustomerOrderRelation.repository.CustomerRepository;
import com.orthofx.CustomerOrderRelation.repository.OrderRepository;

@Service

public class OrderService implements OrderServiceInterface {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
//	get all order
	public List<Order>getAll() {
		OrderListDto orderlist = new OrderListDto();
		orderlist.setorderList(orderRepository.findAll());
		return (orderlist.getorderList());

	}
	
//get by ID
	public ResponseEntity<OrderDto> getCustomerById (Long orderId) throws ResourceNotFoundException{
			Order order = orderRepository.findById(orderId)
					.orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + orderId));
			OrderDto orderdto = new OrderDto();
			orderdto.setName(order.getName());
			orderdto.setQuantity(order.getQuantity());
			return ResponseEntity.ok().body(orderdto);
	}
	
//insert order
	  public  void  createOrder( OrderCustomerDto order,  Long id)throws ResourceNotFoundException {
		  Customer customer = customerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: " + id));
		  Order order1 = new Order();
			order1.setCustomer(customer);
			order1.setName(order.getName());
			order1.setQuantity(order.getQuantity());
			orderRepository.save(order1);

  }
	  
//update
	  public ResponseEntity<Order> updateOrder( Long orderId,OrderDto OrderDetails) throws ResourceNotFoundException {
			Order order = orderRepository.findById(orderId)
					.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
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
					.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
			orderRepository.delete(order);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}	
	  
	
	
	
	
	

}
