package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Account;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.service.AccountService;
import com.wipro.service.CustomerService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService acctservice;
	
	@Autowired
	CustomerService custservice;
	
	@PostMapping("/add")
	public ResponseEntity<String> addAccount(@RequestBody Account account){
		return new ResponseEntity<String>(acctservice.addAccount(account),HttpStatus.CREATED);
	}
	
	@GetMapping("/accountById/{acctno}")
	public ResponseEntity<Account> getAccountById(@PathVariable int acctno) throws ResourceNotFoundException 
	{
		Account acct = acctservice.getAccountByID(acctno);
		return new ResponseEntity<Account>(acct, HttpStatus.OK);
	}
	
	@GetMapping("/balance/{acctno}")
	public Float getAccountBalance(@PathVariable int acctno) throws ResourceNotFoundException
	{
		Account acct = acctservice.getAcctBal(acctno);
		if(acct == null)
		{
			throw new ResourceNotFoundException("Account Number " + acctno + " is not found");
		}
		return acct.getAccBal();
	}
	
	@DeleteMapping("/delete/{acctno}")
	public ResponseEntity<Account> deleteAccount(@PathVariable int acctno)
	{
		acctservice.deleteAccount(acctno);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
