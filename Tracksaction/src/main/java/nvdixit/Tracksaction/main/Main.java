package nvdixit.Tracksaction.main;

import nvdixit.Tracksaction.CreditCard.CreditCard;
import nvdixit.Tracksaction.DBManager.DBManager;
import nvdixit.Tracksaction.Manager.CreditCardManager;
import nvdixit.Tracksaction.Transaction.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
//		CreditCardManager manager = new CreditCardManager();
//		
//		CreditCard cardOne = new CreditCard(1, "American Express");
//		CreditCard cardTwo = new CreditCard(2, "Visa");
//		
//		Transaction t1 = new Transaction("Rent", 2000.00);
//		Transaction t2 = new Transaction("Gas", 50.00);
//		Transaction t3 = new Transaction("Groceries", 100.00);
//		Transaction t4 = new Transaction("Insurance", 250.00);
//		Transaction t5 = new Transaction("Vacation", 5000.00);
//		Transaction t6 = new Transaction("House", 400000.00);
//		
//		cardOne.addTransaction(t1, true);
//		cardOne.addTransaction(t2, true);
//		cardOne.addTransaction(t3, true);
//		
//		cardTwo.addTransaction(t4, true);
//		cardTwo.addTransaction(t5, true);
//		cardTwo.addTransaction(t6, true);
//	
//		manager.addCreditCard(cardOne, true);
//		manager.addCreditCard(cardTwo, true);
		
		CreditCardManager manager = DBManager.readDatabase();		
		System.out.println(manager.toString());			
	}
}





















