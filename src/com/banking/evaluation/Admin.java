/*
 * Class that implements the admin menu interface and provides the admin functionality
 */
package com.banking.evaluation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin implements AdminMenu{
	Scanner scan = new Scanner(System.in);
	@Override
	public CustomerDetails add() {
		
		System.out.println("Enter the customer name : ");
		String name =  checkName(scan.next());
		System.out.println("Enter the account type : ");
		String accType = scan.next();
		System.out.println("Enter the balance : ");
		float bal = Float.parseFloat(scan.next());
		System.out.println("Enter the minimum balance : ");
		float minBal = Float.parseFloat(scan.next());
		System.out.println("Enter the mobile number : ");
		String mobile = checkMobile(scan.next());
		System.out.println("Enter the Email id : ");
		String email = scan.next();
		String accNo = getAccNo();
		String pin = getPIN();
		CustomerDetails customer = new CustomerDetails(accNo,name,accType,bal,minBal,mobile,email,pin );
		
		return customer;
	}

	@Override
	public boolean update(ArrayList<CustomerDetails> cust) {
		System.out.print("Enter the account number : ");
		String accNo = checkAccountNumber(scan.next());
		for(CustomerDetails c:cust) {
			if(c.getAccNo().equals(accNo)) {
				System.out.println("Enter the new mobile Number : ");
				c.setPhone(checkMobile(scan.next()));
				System.out.println("Enter the new email id : ");
				c.setEmail(scan.next());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(ArrayList<CustomerDetails> cust) {
		System.out.print("Enter the account number : ");
		String accNo = checkAccountNumber(scan.next());
		for(CustomerDetails c:cust) {
			if(c.getAccNo().equals(accNo)) {
				cust.remove(c);
				return true;
			}
		}
		return false;
	}

	@Override
	public void display(ArrayList<CustomerDetails> cust) {
		for(CustomerDetails c:cust) {
			System.out.println(c.toString());	
		}
	}

	@Override
	public boolean search(ArrayList<CustomerDetails> cust) {
		System.out.print("Enter the account number : ");
		String accNo = checkAccountNumber(scan.next());
		for(CustomerDetails c:cust) {
			if(c.getAccNo().equals(accNo)) {
				System.out.println(c.toString());
				return true;
			}
		}
		return false;
	}
	
	//to generate PIN number
	private String getPIN() {

		Random rand = new Random();
		String pinNumber = "";
		for(int i=0;i<4;i++) {
			int digit = rand.nextInt(9);
			pinNumber+=digit;
		}
		return pinNumber;
	}

	//to generate the Account number
	private String getAccNo() {

		Random rand = new Random();
		String accountNumber = "";
		for(int i=0;i<9;i++) {
			int digit = rand.nextInt(9);
			accountNumber+=digit;
		}
		return accountNumber;
	}

	//to verify the name
	private static String checkName(String name) {
		// TODO Auto-generated method stub
		try {
			//create object for buffered reader
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//create pattern using regular expression
			Pattern pattern = Pattern.compile("[^A-Za-z ]");
			do {
				//match
				Matcher matcher = pattern.matcher(name);
				boolean finder = matcher.find();
				//find method returns false if string matches the pattern
				if(finder) {
					System.out.println("Name must contain only alphabets please re-enter!");
					name = br.readLine();
				}else if(name.length()>30){
					System.out.println("Name must not be longer than 30 letters please re-enter!");
					name = br.readLine();
				}else {
					break;
				}
			}while(true);
		}catch(Exception e ) {
			System.out.println(e);
		}
		return name;
	}
	
	//to verify the mobile number
	private String checkMobile(String number) {
		try {
			//create object for buffered reader
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//create pattern using regular expression
			Pattern pattern = Pattern.compile("[^0-9]");
			do {
				//match
				Matcher matcher = pattern.matcher(number);
				boolean finder = matcher.find();
				//find method returns false if string matches the pattern
				if(finder) {
					System.out.println("Mobile Number must contain only digits please re-enter!");
					number = br.readLine();
				}else if(number.length()>10){
					System.out.println("Mobile Number must not be longer than 10 digits please re-enter!");
					number = br.readLine();
				}else {
					break;
				}
			}while(true);
		}catch(Exception e ) {
			System.out.println(e);
		}
		return number;
	}
	
	//to verify the account number
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
