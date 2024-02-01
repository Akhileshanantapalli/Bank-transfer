package com.wipro.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.wipro.entity.Customer;

@Service
public interface CustomerService {

	
	
	
	public Customer addCustomer(Customer customer);
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(int custno);
	
	public Customer getCustomerByMailId(String mailid);
	
	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(int custno) ;
	

}
