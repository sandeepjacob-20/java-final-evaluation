package com.banking.evaluation;

import java.util.ArrayList;

public interface AdminMenu {
	//function to add new customers
	public CustomerDetails add();
	//function to update the details of an account
	public boolean update(ArrayList<CustomerDetails> cust);
	//function to delete a customer
	public boolean delete(ArrayList<CustomerDetails> cust);
	//function to display the customer details
	public void display(ArrayList<CustomerDetails> cust);
	//function to search for the details of a customer
	public boolean search(ArrayList<CustomerDetails> cust);
}
