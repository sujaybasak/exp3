package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.ICustomerAccountDao;
import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.exception.IncorrectMobileNoException;

public class CustomerAccountServiceImpl implements ICustomerAccountService {
 ICustomerAccountDao dao;
 public ICustomerAccountDao getDao() {
		return dao;
	}
 
 public CustomerAccountServiceImpl(ICustomerAccountDao dao) {
		this.dao = dao;
	}

	@Override
	public CustomerAccount findByMobileNo(String mobileNo) {
		if(mobileNo ==null || mobileNo.length()!=10) {
			throw new IncorrectMobileNoException("Incorrect mobile number"+mobileNo);
		}
		CustomerAccount c= dao.findByMobileNo(mobileNo);
		return c;
	}

	@Override
	public void rechargeAccount(CustomerAccount cust, double amt) {
		dao.rechargeAccount(cust, amt);
		
	}

	@Override
	public CustomerAccount addCustomerDetails(String mobileNo, String name, String accountType, double balance) {
		if(mobileNo ==null || mobileNo.length()!=10) {
			throw new IncorrectMobileNoException("Incorrect mobile number"+mobileNo);
		}
	CustomerAccount d = new CustomerAccount(mobileNo,name,accountType,balance);
		dao.addCustomerDetails(d);
		return d;
		
	}

	@Override
	public CustomerAccount getAccountDetails(String mobileNo) {
		return this.findByMobileNo(mobileNo);
		
	}

	

}
