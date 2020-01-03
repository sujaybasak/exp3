package com.deloitte.telcom.dao;


import java.util.Map;

import com.deloitte.telcom.entities.CustomerAccount;

public interface ICustomerAccountDao {
	CustomerAccount findByMobileNo(String mobileNo);
	void rechargeAccount(CustomerAccount cust ,double amt);
	 CustomerAccount addCustomerDetails(CustomerAccount c);
	Map<String, CustomerAccount> getStore();
	
	 

}
