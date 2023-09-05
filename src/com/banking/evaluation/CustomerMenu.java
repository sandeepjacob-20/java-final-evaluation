package com.banking.evaluation;

import java.util.ArrayList;

public interface CustomerMenu {
	//function to deposit money into account
	public boolean deposit(ArrayList<CustomerDetails> cust);
	//function to withdraw money from account
	public boolean withdraw(ArrayList<CustomerDetails> cust);
	//function to check balance
	public boolean showBalance(ArrayList<CustomerDetails> cust);
	//function to transfer funds
	public boolean transfer(ArrayList<CustomerDetails> cust);
}
