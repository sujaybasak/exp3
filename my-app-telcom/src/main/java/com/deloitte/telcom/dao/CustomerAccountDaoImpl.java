package com.deloitte.telcom.dao;

import java.util.HashMap;
import java.util.Map;

import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.exception.CustomerNotFoundException;

public class CustomerAccountDaoImpl implements ICustomerAccountDao {
	private Map<String, CustomerAccount> store = new HashMap<>();

	@Override
	public Map<String, CustomerAccount> getStore() {
		return store;
	}
	
	@Override
	public CustomerAccount findByMobileNo(String mobileNo) {
		CustomerAccount c = store.get(mobileNo);
		if (c == null) {
			throw new CustomerNotFoundException("Customer not found for this id" + mobileNo);
		}
		return c;

	}

	@Override
	public void rechargeAccount(CustomerAccount cust, double amt) {
		cust.addBalance(amt);

	}

	@Override
	public CustomerAccount addCustomerDetails(CustomerAccount c) {
		return store.put(c.getMobileNo(), c);

	}

}
