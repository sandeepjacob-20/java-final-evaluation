package com.banking.evaluation;

import java.util.ArrayList;
import java.util.Scanner;

public class Banking {
	static Scanner scan =  new Scanner(System.in);
	static ArrayList<CustomerDetails> customers = new ArrayList<CustomerDetails>();
	public static void main(String[] args) {
		//creating objects of admin and customer class
		Admin admin = new Admin(); 
		Customer cust = new Customer();
		
		int opt;
		//menu driven program
		do {
			System.out.println("Welcome to banking system");
			System.out.println("1-Administrative");
			System.out.println("2-Customer");
			System.out.println("3-Exit");
			System.out.print("Enter the option : ");
			opt = scan.nextInt();
			if(opt==1) {
					do {
						System.out.println("\nChoose an option : ");
						System.out.println("1-Add new customer");
						System.out.println("2-Update customer details");
						System.out.println("3-Delete a customer");
						System.out.println("4-Display list of customers");
						System.out.println("5-Details of a specific customer");
						System.out.println("6-Exit");
						System.out.print("Enter the option : ");
						opt = scan.nextInt();
						switch(opt) {
							case 1:
								customers.add(admin.add());
								break;
							case 2:
								if(admin.update(customers))
									System.out.println("Customer details updated successfully....");
								else
									System.out.println("Account doesnt exist..");
								break;
							case 3:
								if(admin.delete(customers))
									System.out.println("Customer Deleted....");
								else
									System.out.println("Customer doesnt exist...");
								break;
							case 4:
								admin.display(customers);
								break;
							case 5:
								if(!admin.search(customers))
									System.out.println("Account number not found......");
								break;								
						}
					}while(opt!=6);
				}
			else if(opt==2) {
				do {
					System.out.println("\nChoose an option : ");
					System.out.println("1-Deposit");
					System.out.println("2-Withdraw");
					System.out.println("3-Check balance");
					System.out.println("4-Fund transfer");
					System.out.println("5-Exit");
					System.out.print("Enter the option : ");
					opt = scan.nextInt();
					switch(opt) {
					case 1:
						if(cust.deposit(customers))
							System.out.println("Amount successfully Deposited...");
						else
							System.out.println("Error depositing,check Account number....");
						break;
					case 2:
						if(cust.withdraw(customers))
							System.out.println("Amount Withdrawn...");
						break;
					case 3:
						if(!cust.showBalance(customers))
							System.out.println("Check the account number.....");
						break;
					case 4:
						cust.transfer(customers);
						break;
					}
				}while(opt!=5);
			}
		}while(opt!=3);
	}

}
