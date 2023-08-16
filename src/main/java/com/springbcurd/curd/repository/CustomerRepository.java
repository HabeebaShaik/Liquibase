package com.springbcurd.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbcurd.curd.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	

}
