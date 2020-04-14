package controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import models.Transaction;
import models.User;

public class ReadJson {
	
	private static List<User> parsedUsers = new ArrayList<User>();
	private static List<Transaction> parsedTransactions = new ArrayList<Transaction>();
	
	@SuppressWarnings("unchecked")
	public static List<User> read() {
		 JSONParser jsonParser = new JSONParser();
		 try (FileReader reader = new FileReader("C:\\Users\\Matthew\\Desktop\\Java1_2\\Shock-Statement-Generator\\shock_statement_generator\\stock_transations.by.account.holder.json"))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray userList = (JSONArray) obj;
	            System.out.println(userList);
	             
	            //Iterate over user array
	            userList.forEach( usr -> parseUser( (JSONObject) usr ) );
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 
		 return parsedUsers;
	}
	
	@SuppressWarnings("unchecked")
	public static void parseUser(JSONObject usr) {
		User parsingUser = new User();
		
		long accountNum = (long) usr.get("account_number");
		
		parsingUser.setAccountNumber(accountNum);
		
		String fullName = (String) usr.get("first_name");
		fullName += " " + (String) usr.get("last_name");
		parsingUser.setFullName(fullName);
		
		parsingUser.setSsn((String) usr.get("ssn"));
		
		parsingUser.setEmail((String) usr.get("email"));
		
		parsingUser.setPhoneNumber((String) usr.get("phone"));

		String dollarToLong = (String) usr.get("beginning_balance");
		dollarToLong = dollarToLong.substring(1);
		
		parsingUser.setBalance(Double.parseDouble(dollarToLong)); //might not work
		
		JSONArray transactionArray = (JSONArray) usr.get("stock_trades");
		transactionArray.forEach( tra -> parseTransactions( (JSONObject) tra ) ); 
		 
		parsingUser.setTransactions(parsedTransactions);
		
		parsedTransactions = new ArrayList<Transaction>();
		
		parsedUsers.add(parsingUser);	
	}
	
	public static void parseTransactions(JSONObject tra) {
		Transaction parsingTransaction = new Transaction();
		
		String boolCheck = (String) tra.get("type");
		parsingTransaction.setBuy(boolCheck.equals("Buy"));
		
		parsingTransaction.setStockSymbol((String) tra.get("stock_symbol"));
		
		String dollarToLong = (String) tra.get("price_per_share");
		dollarToLong = dollarToLong.substring(1);
		
		parsingTransaction.setPricePerShare(Double.parseDouble(dollarToLong));
		
		parsingTransaction.setCountShares((long) tra.get("count_shares"));
		
		parsedTransactions.add(parsingTransaction);
	
	}

}
