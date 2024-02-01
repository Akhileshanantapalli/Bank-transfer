package com.wipro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{
	
	List<Account> findByEmail(String email);
	
	

}
