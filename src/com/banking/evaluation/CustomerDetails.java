/*
 * Class to store the instance variables for the user details
 */
package com.banking.evaluation;

public class CustomerDetails {
	
	//declaring variables
	private String accNo, custName, accType;
	private float balance, minBalance;
	private String phone,email, pin;
	
	//unparameterized constructor
	public CustomerDetails() {
		this.accNo = "NULL";
		this.custName = "NULL";
		this.accType = "NULL";
		this.balance = 0f;
		this.minBalance = 0f;
		this.phone = "NULL";
		this.email = "NULL";
		this.pin = "NULL";
	}
	
	//parameterized constructor
	public CustomerDetails(String accNo, String custName, String accType, float balance, float minBalance, String phone,
			String email, String pin) {
		this.accNo = accNo;
		this.custName = custName;
		this.accType = accType;
		this.balance = balance;
		this.minBalance = minBalance;
		this.phone = phone;
		this.email = email;
		this.pin = pin;
	}
	
	//getters and setters
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(float minBalance) {
		this.minBalance = minBalance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "\nAccount Number = " + accNo + ", Customer Name=" + custName + "\nAccount Type=" + accType + ", Balance=" + balance
				+ "\nminBalance=" + minBalance + ", phone=" + phone + "\nemail=" + email + ", pin=" + pin;
	}
}
