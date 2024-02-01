package com.wipro.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Account;
import com.wipro.repository.AccountRepository;
import com.wipro.repository.CustomerRepository;
import com.wipro.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService{
	
	@Autowired
	AccountRepository acctrepository;
	
	@Autowired
	CustomerRepository custrepository;
	
	public Account fundTransfer(int fromacct, int toacct, float fund)
	{
		Account from = acctrepository.findById(fromacct).get();
		Account to  = acctrepository.findById(toacct).get();
		from.setAccBal(from.getAccBal() - fund);
		to.setAccBal(to.getAccBal() + fund);
		acctrepository.save(from);
		return acctrepository.save(to);
	}

}
