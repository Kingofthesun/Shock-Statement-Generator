package models;

import java.util.List;

public class User {

	private String fullName;
	private String ssn;
	private String email;
	private String phoneNumber;
	private float balance;
	private int accountNumber;
	private int stockHoldings;
	private List<Transaction> transactions;
	
	public User(String fullName, String ssn, String email, String phoneNumber, float balance, int accountNumber,
			List<Transaction> transactions) {
		this.fullName = fullName;
		this.ssn = ssn;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.transactions = transactions;
		setStockHoldings(stockSum());
	}

	private int stockSum() {
		int sum = 0;
		for(Transaction T : transactions) {
			sum += T.getCountShares();
		}
		return sum;
	}

	public User() {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
		setStockHoldings(stockSum());
	}

	public int getStockHoldings() {
		return stockHoldings;
	}

	public void setStockHoldings(int stockHoldings) {
		this.stockHoldings = stockHoldings;
	}
	
	
	
}
