package com.wipro.entity;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	private int accno;
	
	private String acctype;
	
	private String email;
	
	private float accBal;

	public Account() {
		
	}

	public Account(int accno, String acctype, String email, float accBal) {
		super();
		this.accno = accno;
		this.acctype = acctype;
		this.email = email;
		this.accBal = accBal;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public float getAccBal() {
		return accBal;
	}

	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
