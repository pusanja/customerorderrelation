package com.orthofx.CustomerOrderRelation.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.orthofx.CustomerOrderRelation.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
