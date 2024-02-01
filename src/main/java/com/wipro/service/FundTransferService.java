package com.wipro.service;

import org.springframework.stereotype.Service;

import com.wipro.entity.Account;

@Service
public interface FundTransferService {
	public Account fundTransfer(int fromacct, int toacct, float fund);

}
