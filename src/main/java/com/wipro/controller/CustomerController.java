package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Customer;
import com.wipro.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
    CustomerService customerService;
	
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);		
	}

	@GetMapping("/list")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customerById/{custno}")
	public Customer getCustomerById(@PathVariable int custno) {
		return customerService.getCustomerById(custno);
	}
	
	@GetMapping("/customerByMailId/{mailid}")
	public Customer getCustomerByMailId(@PathVariable String mailid) {
		return customerService.getCustomerByMailId(mailid);
	}
	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/delete/{custno}")
	public String deleteCustomer(@PathVariable int custno) {
		customerService.deleteCustomer(custno);
		return "Customer Deleted Successfully";
	}

}
