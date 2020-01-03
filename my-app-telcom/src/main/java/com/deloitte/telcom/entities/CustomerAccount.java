package com.deloitte.telcom.entities;

public class CustomerAccount {
	private String mobileNo;
	private String name;
	private String accountType;
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	private double balance;
	public String getMobileNo() {
		return mobileNo;
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addBalance(double balance) {
		this.balance += balance;
	}
	public CustomerAccount(String mobileNo, String name, String accountType, double balance) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.accountType = accountType;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return mobileNo + " " + name + " " + accountType + " "+ balance;
	}
	@Override
	public int hashCode() {
		return mobileNo.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof CustomerAccount)) {
			return false;
		}
		CustomerAccount c = (CustomerAccount) obj;
			return c.mobileNo.equals(this.mobileNo) ;
	}
	
}
