package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Account;
import com.wipro.entity.FundTransfer;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.service.AccountService;
import com.wipro.service.FundTransferService;

@RestController
@RequestMapping("/ft")
public class FundTransferController {
	@Autowired
	FundTransferService fundservice;
	
	@Autowired
	AccountService acctservice;
	
	@PutMapping("/transfer")
	public ResponseEntity<Account> fundTransfer(@RequestBody FundTransfer fundtransfer) throws ResourceNotFoundException 
	{
		Account account = acctservice.getAcctBal(fundtransfer.getFromacc());
		if (account.getAccBal() < fundtransfer.getFund())
		{
			throw new ResourceNotFoundException("Insufficient Balance");
		}
		else
		{
			Account acct = fundservice.fundTransfer(fundtransfer.getFromacc(), fundtransfer.getToacc(), fundtransfer.getFund());
			
			return new ResponseEntity<Account>(acct, HttpStatus.OK);
		}
		
	}

}
