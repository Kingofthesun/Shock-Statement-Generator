package models;

public class Transaction {

	private boolean buy;
	private String stockSymbol;
	private double pricePerShare;
	private long countShares;
	private double totalTransactionAmount;
	
	public Transaction(boolean buy, String stockSymbol, double pricePerShare, long countShares) {
		this.buy = buy;
		this.stockSymbol = stockSymbol;
		this.pricePerShare = pricePerShare;
		this.countShares = countShares;
		totalTransactionAmount = TransactionCalculator();
	}
	
	public Transaction() {
		
	}
	
	private double TransactionCalculator() {	
		double sum = 0;
		sum = pricePerShare * countShares;
		if(buy) {
			sum *= -1;
		}
		return sum;
	}

	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
		totalTransactionAmount = TransactionCalculator();
	}

	public long getCountShares() {
		return countShares;
	}

	public void setCountShares(long countShares) {
		this.countShares = countShares;
		totalTransactionAmount = TransactionCalculator();
	}

	public double getTotalTransactionAmount() {
		return totalTransactionAmount;
	}

	public void setTotalTransactionAmount(double totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}
	
	
	
	
}
