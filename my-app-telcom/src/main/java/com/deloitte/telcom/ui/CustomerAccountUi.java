package com.deloitte.telcom.ui;

import java.util.Scanner;

import com.deloitte.telcom.dao.CustomerAccountDaoImpl;
import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.exception.CustomerNotFoundException;
import com.deloitte.telcom.exception.IncorrectMobileNoException;
import com.deloitte.telcom.service.CustomerAccountServiceImpl;
import com.deloitte.telcom.service.ICustomerAccountService;

public class CustomerAccountUi {
	private ICustomerAccountService service = new CustomerAccountServiceImpl(new CustomerAccountDaoImpl());
	public static void main(String[] args) {
		CustomerAccountUi ui = new CustomerAccountUi();
		ui.runUi();
	}
	private void runUi() {
		while(true){
		try {
			System.out.println("***Please Select an Option From The Menu:***");
			System.out.println("1: Account Balance Enquiry");
			System.out.println("2: Recharge Account");
			System.out.println("3: Create Account");
			System.out.println("4: Exit");
			System.out.println("Enter Your Choice :");
			
			Scanner sc = new Scanner(System.in);
			int  choice =sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter Your Mobile Number:");
				String mobileNo1 =sc.next();
				CustomerAccount cust1 = service.findByMobileNo(mobileNo1);
				System.out.println("Your Balance is: "+cust1.getBalance());
				break;
			case 2: 
				System.out.println("Enter Your Mobile Number:");
				String mobileNo2 =sc.next();
				System.out.println("Enter The Amount:");
				double recharge = sc.nextDouble();
				CustomerAccount cust2 = service.findByMobileNo(mobileNo2);
				service.rechargeAccount(cust2, recharge);
				System.out.println("Recharge Succesfull");
				System.out.println("Account Details: "+cust2);
				break;
			case 3:
				System.out.println("Enter Your Mobile Number:");
				String mobileNo3 =sc.next();
				System.out.println("Enter Your Name:");
				String name =sc.next();
				System.out.println("Enter Your Account Type(Pre Paid/Post Post):");
				String type =sc.next();
				System.out.println("Enter Your Initial Balance:");
				double balance =sc.nextDouble();
				CustomerAccount cust3 = new CustomerAccount(mobileNo3,name,type,balance);
				service.addCustomerDetails(mobileNo3, name, type, balance);
				System.out.println("*Account Created* "+cust3);
				break;
			case 4:
				System.out.println("Do you want to exit?(y/n)");
				String in =sc.next();
				if(in =="y") {
					break; 
				}
			}
			}
		
		
			
				catch(IncorrectMobileNoException e) {
					System.out.println("Mobile no is wrong");
				}
				catch(CustomerNotFoundException e) {
					System.out.println("Customer not found");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Something went wrong");
				}
		}
		
		
	}
}