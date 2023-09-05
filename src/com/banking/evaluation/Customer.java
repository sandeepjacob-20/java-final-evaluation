/*
 * Class that implements the customer menu interface and provides the customer functionalities
 */
package com.banking.evaluation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer implements CustomerMenu {
	static Scanner scan =  new Scanner(System.in);

	@Override
	public boolean deposit(ArrayList<CustomerDetails> cust) {
		System.out.print("Enter the account number : ");
		String accNo = checkAccountNumber(scan.next());
		System.out.println("Enter the deposit amount : ");
		float amount = scan.nextFloat();
		if(amount>50000) {
			System.out.println("Please enter your pan number : ");
			String pan = scan.next();
		}
		for(CustomerDetails c:cust) {
			if(c.getAccNo().equals(accNo)) {
				c.setBalance(c.getBalance()+amount);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean withdraw(ArrayList<CustomerDetails> cust) {
		System.out.print("Enter the account number : ");
		String accNo = checkAccountNumber(scan.next());
		System.out.println("Enter the amount to withdraw : ");
		float amount = scan.nextFloat();
		for(CustomerDetails c:cust) {
			if(c.getAccNo().equals(accNo)) {
				float availableBalance = c.getBalance()-c.getMinBalance();
				if(availableBalance<amount) {
					System.out.println("Insufficient balance");
					return false;
				}
				if(amount>50000) {
					System.out.println("Please enter your pan number : ");
					String pan = scan.next();
				}
				c.setBalance(c.getBalance()-amount);
				return true;
			}
		}
		return false;	
	}

	@Override
	public boolean showBalance(ArrayList<CustomerDetails> cust) {
		System.out.print("Enter the account number : ");
		String accNo = checkAccountNumber(scan.next());
		for(CustomerDetails c:cust) {
			if(c.getAccNo().equals(accNo)) {
				System.out.println("Account balance = "+c.getBalance());
				return true;
			}
		}
		return false;
	}
	

	@Override
	public boolean transfer(ArrayList<CustomerDetails> cust) {
		//creating temporary objects of CustomerDetails class
		CustomerDetails beneficiary = new CustomerDetails();
		CustomerDetails sender = new CustomerDetails();
		
		System.out.print("Enter your account number : ");
		String fromAcc = checkAccountNumber(scan.next());
		System.out.print("Enter the beneficiary account number : ");
		String toAcc = checkAccountNumber(scan.next());
		if(checkAcc(toAcc,cust)) {
			System.out.println("Enter the amount : ");
			float amount = scan.nextFloat();
			for(CustomerDetails c:cust) {
				if(c.getAccNo().equals(toAcc)) {
					beneficiary = c;
				}
				else if (c.getAccNo().equals(fromAcc)) {
					sender = c;
				}
			}
			float availableBalance = sender.getBalance()-sender.getMinBalance();
			if(availableBalance<amount) {
				System.out.println("Insufficient balance");
				return false;
			}
			sender.setBalance(sender.getBalance()-amount);
			beneficiary.setBalance(beneficiary.getBalance()+amount);
			System.out.println("Amount transfered to beneficiary....");
			return true;
		}
		return false;
	}

	//to check if the account is valid
	private boolean checkAcc(String toAcc, ArrayList<CustomerDetails> cust) {
		// TODO Auto-generated method stub
		for(CustomerDetails c:cust) {
			if(c.getAccNo().equals(toAcc)) {
				return true;
			}
		}
		System.out.println("Beneficiary Account does not exist...");
		return false;
	}
	
	//to validate the account number
	private String checkAccountNumber(String accNo) {
		try {
			//create object for buffered reader
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//create pattern using regular expression
			Pattern pattern = Pattern.compile("[^0-9]");
			do {
				//match
				Matcher matcher = pattern.matcher(accNo);
				boolean finder = matcher.find();
				//find method returns false if string matches the pattern
				if(finder) {
					System.out.println("Account Numbe must contain only digits please re-enter!");
					accNo = br.readLine();
				}else if(accNo.length()>9){
					System.out.println("Account number must not be longer than 9 digits please re-enter!");
					accNo = br.readLine();
				}else {
					break;
				}
			}while(true);
		}catch(Exception e ) {
			System.out.println(e);
		}
		return accNo;
	}
}
