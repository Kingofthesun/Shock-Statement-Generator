package models;

public class Transaction {

	private boolean buy;
	private String stockSymbol;
	private float pricePerShare;
	private int countShares;
	private float totalTransactionAmount;
	
	public Transaction(boolean buy, String stockSymbol, float pricePerShare, int countShares) {
		this.buy = buy;
		this.stockSymbol = stockSymbol;
		this.pricePerShare = pricePerShare;
		this.countShares = countShares;
		totalTransactionAmount = TransactionCalculator();
	}
	
	private float TransactionCalculator() {	
		float sum = pricePerShare * countShares;
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

	public float getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public int getCountShares() {
		return countShares;
	}

	public void setCountShares(int countShares) {
		this.countShares = countShares;
	}

	public float getTotalTransactionAmount() {
		return totalTransactionAmount;
	}

	public void setTotalTransactionAmount(float totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}
	
	
	
	
}
