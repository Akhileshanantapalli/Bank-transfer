package com.wipro.entity;

public class FundTransfer {
	
	private int fromacc;
	private int toacc;
	private float fund;
	public FundTransfer() {
		
	}
	public FundTransfer(int fromacc, int toacc, float fund) {
		super();
		this.fromacc = fromacc;
		this.toacc = toacc;
		this.fund = fund;
	}
	public int getFromacc() {
		return fromacc;
	}
	public void setFromacc(int fromacc) {
		this.fromacc = fromacc;
	}
	public int getToacc() {
		return toacc;
	}
	public void setToacc(int toacc) {
		this.toacc = toacc;
	}
	public float getFund() {
		return fund;
	}
	public void setFund(float fund) {
		this.fund = fund;
	}
}
