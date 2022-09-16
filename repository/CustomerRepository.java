package com.orthofx.CustomerOrderRelation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.orthofx.CustomerOrderRelation.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
