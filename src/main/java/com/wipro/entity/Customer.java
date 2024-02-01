package com.wipro.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int custno;
	
	private String custname;
	
	private String mailid;
	
	private int phnno;
	
	
	@OneToMany(targetEntity=Account.class,cascade=CascadeType.ALL)
	@JoinColumn(name="custno",referencedColumnName="custno")
	private List<Account> accounts;

	public Customer() {
		
	}

	public Customer(int custno, String custname, String mailid, int phnno, List<Account> accounts) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.mailid = mailid;
		this.phnno = phnno;
		this.accounts = accounts;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public int getPhnno() {
		return phnno;
	}

	public void setPhnno(int phnno) {
		this.phnno = phnno;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
