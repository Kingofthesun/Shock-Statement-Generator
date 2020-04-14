package models;

import java.util.List;

public class User {

	private String fullName;
	private String ssn;
	private String email;
	private String phoneNumber;
	private double balance;
	private long accountNumber;
	private long stockHoldings;
	private List<Transaction> transactions;
	
	public User(String fullName, String ssn, String email, String phoneNumber, double balance, long accountNumber,
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

	private long stockSum() {
		long sum = 0;
		for(Transaction T : transactions) {
			if(T.isBuy()) {
				sum += T.getCountShares();				
			}
		}
		return sum;
	}

	public User() {
		stockHoldings = 0;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
		setStockHoldings(stockSum());
	}

	public long getStockHoldings() {
		return stockHoldings;
	}

	public void setStockHoldings(long stockHoldings) {
		this.stockHoldings = stockHoldings;
	}
	
	
	
}
