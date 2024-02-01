package com.wipro.ServiceImpl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.wipro.entity.Account;
import com.wipro.entity.Customer;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.repository.AccountRepository;
import com.wipro.repository.CustomerRepository;
import com.wipro.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountRepository acctrepository;
	
	@Autowired
	CustomerRepository custrepository;

	public String addAccount(Account account) {
		List<Account> acc=acctrepository.findByEmail(account.getEmail());
		Iterator<Account> itr=acc.iterator();
		while(itr.hasNext()) {
			Account a=(Account) itr.next();
			if(a.getAcctype().equals(account.getAcctype())) {
				return "Account Already existed for this customer of account type"  +account.getAccno();
			}
		}
		Customer customer =custrepository.findByMailid(account.getEmail());
		if(ObjectUtils.isEmpty(customer)) {
			acctrepository.save(account);
		}else {
			customer.getAccounts().add(account);
			custrepository.save(customer);
		}
		return "account added";
	}

	public Account getAccountByID(int acctno) {
		return acctrepository.findById(acctno).orElseThrow(()->new ResourceNotFoundException());
	}

	public Account getAcctBal(int acctno) {
		Account acct = acctrepository.findById(acctno).get();
		acct.setAccBal(acct.getAccBal());
		return acct;
	}

	public void deleteAccount(int accno) {
		acctrepository.deleteById(accno);
		
	}

	@Override
	public void deleteAccount(Long accountId) {
		// TODO Auto-generated method stub
		
	}

}
