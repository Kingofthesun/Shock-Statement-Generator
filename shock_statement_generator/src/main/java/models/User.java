package models;

public class User {

	private String fullName;
	private String ssn;
	private String email;
	private String phoneNumber;
	private int balance;
	private int accountNumber;
	private Transaction[] transactions;
	
	public User(String fullName, String ssn, String email, String phoneNumber, int balance, int accountNumber,
			Transaction[] transactions) {
		this.fullName = fullName;
		this.ssn = ssn;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.transactions = transactions;
	}
	
	
	
}
