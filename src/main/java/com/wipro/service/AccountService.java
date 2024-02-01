package com.wipro.service;

import org.springframework.stereotype.Service;

import com.wipro.entity.Account;


@Service
public interface AccountService {
	
	public String addAccount(Account account);
	public Account getAccountByID(int acctno);
	public Account getAcctBal(int acctno);
	public void deleteAccount(int accno);
	void deleteAccount(Long accountId);
	
	

}
