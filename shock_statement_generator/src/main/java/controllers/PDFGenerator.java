package controllers;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import models.Transaction;
import models.User;

public class PDFGenerator {

	private static User currentUser;
	private static Date statementDate = new Date();
	private static OutputStream outputStream;
	private static OutputStreamWriter outputStreamWriter;
	
	public static void run() throws IOException {
		
		outputStream = new FileOutputStream("testfile.html");
        outputStreamWriter = new OutputStreamWriter(outputStream);
        
        

        outputStreamWriter.write("<!DOCTYPE html>");
        outputStreamWriter.write("<html><body>");
		
		printUser();
        
        
        
		outputStreamWriter.write("</body></html>");

        outputStreamWriter.close();
	}
	
	public static void printUser() throws IOException {
//		 List<Course> courses = new ArrayList<Course>();
//	        courses.add(new Course(12, "Java"));
//	        courses.add(new Course(34, "C#"));
//
//	        Person person = new Person();
//	        person.setId(1);
//	        person.setFirstName("Johnny");
//	        person.setLastName("Student");
//	        person.setCourses(courses);
		
		
			List<Transaction> currentUserTransactions = new ArrayList<Transaction>();
			currentUserTransactions.add(new Transaction(true, "ASDF", (float) 302.14, 3920));
			currentUserTransactions.add(new Transaction(false, "WQRE", (float) 603.3, 4290));
			
			
			currentUser = new User();
			
			currentUser.setFullName("Matthew Carey");
			currentUser.setSsn("123-45-6789"); 
			currentUser.setEmail("Matthewcarey9000@gmail.com");
			currentUser.setPhoneNumber("360-910-9680");
			currentUser.setBalance((float) 6942025.23); 
			currentUser.setAccountNumber(1);
			currentUser.setTransactions(currentUserTransactions);
		
		

	        outputStreamWriter.write(String.format("<h3>Account Number: (%d) User: %s SSN: %s </h3>"
	        		+ "<h3>Email: %s Phone Number: %s</h3><h3>Beginning Balance %.2f "
	        		+ "</h3><h3>Statement Start Time: %s</h3>",
	        		currentUser.getAccountNumber(), currentUser.getFullName(), currentUser.getSsn(),
	        		currentUser.getEmail(), currentUser.getPhoneNumber(), currentUser.getBalance(),
	        		 statementDate));

	        printTransactions(currentUser.getTransactions());
	        outputStreamWriter.write(String.format("<h3>Ending Balance: %.2f Current Stock Holdings: %d</h3>"
	        		+ "<h3>Statement End Time: %s</h3>",
	        currentUser.getBalance(), currentUser.getStockHoldings(), statementDate));
	        
//	        outputStreamWriter.write("<table>");
//	        for (Course course:person.getCourses()) {
//	            // write each row here
	//
//	        }
//	        outputStreamWriter.write("</table>");

	        

	}
	
	private static int calcUserBalance() {
		
		return 0;
	}
	
	public static void printTransactions(List<Transaction> transactions) throws IOException {
		
		
			
		outputStreamWriter.write("<table style=\"width:100%\">\r\n" + 
				"  <tr>\r\n" + 
				"    <th>Type</th>\r\n" + 
				"    <th>Stock Symbol</th> \r\n" + 
				"    <th>Count Shares</th>\r\n" + 
				"    <th>Price Per Share</th>\r\n" + 
				"    <th>Total Transaction Amount</th>\r\n" + 
				"  </tr>");
		for (Transaction T : transactions) {

			String buyOrSell = T.isBuy() ? "Buy" : "Sell";
		
		
			outputStreamWriter.write(String.format("<tr>\r\n" + 
				"    <td>%s</td>\r\n" + 
				"    <td>%s</td>\r\n" + 
				"    <td>%d</td>\r\n" + 
				"    <td>%.2f</td>\r\n" + 
				"    <td>%.2f</td>\r\n" + 
				"  </tr>", buyOrSell, T.getStockSymbol(), T.getCountShares(),
				T.getPricePerShare(), T.getTotalTransactionAmount()));
			
			currentUser.setBalance(currentUser.getBalance()+T.getTotalTransactionAmount());
		}
		
		
		
		
		outputStreamWriter.write("</table>");
	}
	
}
