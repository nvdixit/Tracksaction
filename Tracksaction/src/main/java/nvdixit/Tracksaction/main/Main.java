package nvdixit.Tracksaction.main;

import java.time.LocalDate;

import nvdixit.Tracksaction.CreditCard.CreditCard;
import nvdixit.Tracksaction.Manager.CreditCardManager;
import nvdixit.Tracksaction.Transaction.Transaction;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;


import com.mongodb.ConnectionString;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientSettings;

public class Main {

	public static void main(String[] args) {
		
		CreditCardManager manager = new CreditCardManager();
		
		CreditCard cardOne = new CreditCard("American Express");
		CreditCard cardTwo = new CreditCard("Visa");
		
		Transaction t1 = new Transaction("Rent", 2000.00);
		Transaction t2 = new Transaction("Gas", 50.00);
		Transaction t3 = new Transaction("Groceries", 100.00);
		Transaction t4 = new Transaction("Insurance", 250.00);
		Transaction t5 = new Transaction("Vacation", 5000.00);
		Transaction t6 = new Transaction("House", 400000.00);
		
		cardOne.addTransaction(t1);
		cardOne.addTransaction(t2);
		cardOne.addTransaction(t3);
		
		cardTwo.addTransaction(t4);
		cardTwo.addTransaction(t5);
		cardTwo.addTransaction(t6);
	
		manager.addCreditCard(cardOne);
		manager.addCreditCard(cardTwo);
		
		
	}

}
