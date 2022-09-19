package com.orthofx.CustomerOrderRelation.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orthofx.CustomerOrderRelation.model.Customer;
import com.orthofx.CustomerOrderRelation.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
	public List<Order> findByCustomer(Customer customer);
	}
