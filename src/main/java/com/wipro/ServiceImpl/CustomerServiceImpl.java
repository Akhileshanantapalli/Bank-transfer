package com.wipro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Customer;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.repository.CustomerRepository;
import com.wipro.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
		
	}
	
	public Customer getCustomerById(int custno) {
		return customerRepository.findById(custno).orElseThrow(()->new ResourceNotFoundException());
	}
	
	public Customer getCustomerByMailId(String mailid) {
		return customerRepository.findByMailid(mailid);
	}
	
	public Customer updateCustomer(Customer customer){
		Customer cust=customerRepository.findById(customer.getCustno()).orElseThrow(()->new ResourceNotFoundException());
		cust.setMailid(customer.getMailid());
		return customerRepository.save(cust);
		
	}

	public void deleteCustomer(int custno) {
		customerRepository.deleteById(custno);
		
	}

}
