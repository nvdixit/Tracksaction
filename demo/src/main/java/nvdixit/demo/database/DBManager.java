package nvdixit.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nvdixit.demo.CreditCard.CreditCard;
import nvdixit.demo.Transaction.Transaction;

/**
 * Handles writing all user data into the Database
 * @author nikhildixit
 *
 */
public class DBManager {
	
	/**
	 * Inserts a Transaction into the DB
	 * @param connection the Connection to the DB
	 * @param t the Transaction to insert
	 * @throws SQLException error
	 */
	public static void insertTransaction(Transaction transaction) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tracksaction_data", "root", "password");
		Statement statement = connection.createStatement();
		String action = "INSERT INTO Transactions (name, amount, cc_id) " + "VALUES ('" + transaction.getName() + "'," + transaction.getAmount() + ", " + transaction.CCID() + ")";
		statement.execute(action);
		
		statement.close();
		connection.close();
	}
	
	/**
	 * Deletes a transaction from the database
	 * @param connection the connection to the DB
	 * @param transaction the transaction to delete
	 * @throws SQLException error
	 */
	public static void deleteTransaction(String name, double amount) throws SQLException {		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tracksaction_data", "root", "password");
		Statement statement = connection.createStatement();
		String action = "DELETE FROM Transactions WHERE name='" + name + "' AND amount=" + amount + ";";
		statement.execute(action);
	}
	
	public static ArrayList<Transaction> getAllTransactions(int ccid) {
		Connection connection;
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tracksaction_data", "root", "password");
			Statement statement = connection.createStatement();
			String action = "SELECT * FROM Transactions";
			ResultSet results = statement.executeQuery(action);
			
			while(results.next()) {
				String name = results.getString("name");
				double amount = results.getDouble("amount");
				int ccNum = results.getInt("cc_id");
				
				if(ccid == ccNum) {
					Transaction transaction = new Transaction(name, amount, ccNum);
					transactions.add(transaction);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return transactions;
	}
	
	public static ArrayList<CreditCard> getAllCreditCards() {
		Connection connection;
		ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tracksaction_data", "root", "password");
			Statement statement = connection.createStatement();
			String action = "SELECT * FROM Credit_cards;";
			ResultSet results = statement.executeQuery(action);
			
			while(results.next()) {
				String name = results.getString("name");
				int id = results.getInt("id");
				
				CreditCard creditCard = new CreditCard(id, name);
				creditCards.add(creditCard);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return creditCards;
	}
	
	/**
	 * Inserts a CreditCard into the Database
	 * @param connection the connection to the DB
	 * @param card the card to insert
	 * @throws SQLException error
	 */
	public static void insertCreditCard(CreditCard card) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tracksaction_data", "root", "password");
		Statement statement = connection.createStatement();
		String action = "INSERT INTO Credit_Cards (id, name) " + "VALUES(" + card.getID() + ", '" + card.getName() + "')";
		statement.execute(action);
		
		statement.close();
		connection.close();
	}
	
	/**
	 * Returns the highest index value of any entry in the Credit_Cards table
	 * @return the highest index value of any entry in the Credit_Cards table
	 * @throws SQLException 
	 */
	public static int getHigestCCIndex() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tracksaction_data", "root", "password");
		Statement statement = connection.createStatement();
		String action = "SELECT MAX(id) from Credit_Cards;";
		
		ResultSet results = statement.executeQuery(action);
		results.next();
		
		return results.getInt("MAX(id)");
	}

	/**
	 * Deletes a CC from the DB
	 * @param card the card to delete
	 * @throws SQLException 
	 */
	public static void deleteCreditCard(CreditCard card) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tracksaction_data", "root", "password");
		Statement statement = connection.createStatement();
		String action = "DELETE FROM Transactions WHERE name='" + card.getName() + "' AND id=" + card.getID() + ";";
		statement.execute(action);
		
		statement.close();
		connection.close();
	}

//	/**
//	 * Reads in all data from the database and populates interim objects
//	 * @param connection the connection to the db
//	 * @return the new CreditCardManager
//	 * @throws SQLException 
//	 */
//	@GetMapping
//	public static CreditCardManager readDatabase() throws SQLException {
//		CreditCardManager manager = new CreditCardManager();
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tracksaction_data", "root", "password");
//		Statement statement = connection.createStatement();
//		
//		ResultSet results = statement.executeQuery("SELECT * FROM Credit_Cards");		
//		while(results.next()) {
//			String name = results.getString("name");
//			int id = results.getInt("id");
//			
//			CreditCard card = new CreditCard(id, name);
//			manager.addCreditCard(card, false);
//		}
//		
//		results = statement.executeQuery("SELECT * FROM Transactions");		
//		while(results.next()) {
//			String name = results.getString("name");
//			double amount = results.getDouble("amount");
//			int ccid = results.getInt("cc_id");
//			
//			Transaction transaction = new Transaction(name, amount);
//			manager.addTransactionToCard(ccid, transaction, false);
//		}
//		
//		statement.close();
//		connection.close();
//				
//		return manager;
//	}
//	
	
}
