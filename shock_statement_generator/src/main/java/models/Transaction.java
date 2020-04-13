package models;

public class Transaction {

	private boolean buy;
	private String stockSymbol;
	private int pricePerShare;
	private int sharesInTransaction;
	private int totalTransactionAmount;
	
	public Transaction(boolean buy, String stockSymbol, int pricePerShare, int sharesInTransaction) {
		this.buy = buy;
		this.stockSymbol = stockSymbol;
		this.pricePerShare = pricePerShare;
		this.sharesInTransaction = sharesInTransaction;
		totalTransactionAmount = TransactionCalculator();
	}
	
	private int TransactionCalculator() {
		
		
		return 0;
	}
	
	
	
}
