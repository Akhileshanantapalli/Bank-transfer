package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.wipro.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	Customer findByMailid(String mailid);

}
