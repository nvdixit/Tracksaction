package nvdixit.Tracksaction.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import nvdixit.Tracksaction.CreditCard.CreditCard;
import nvdixit.Tracksaction.Manager.CreditCardManager;
import nvdixit.Tracksaction.Transaction.Transaction;

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
	public static void insertIntoTransactions(Connection connection, Transaction transaction) throws SQLException {
		Statement statement = connection.createStatement();
		String action = "INSERT INTO Transactions (name, amount) " + "VALUES ('" + transaction.getName() + "'," + transaction.getAmount() + ")";
		statement.execute(action);
	}
	
	/**
	 * Inserts multiple Transactions into the DB
	 * @param connection the connection to the DB
	 * @param transactions the transactions to insert
	 * @throws SQLException error
	 */
	public static void insertIntoTransactions(Connection connection, ArrayList<Transaction> transactions) throws SQLException {
		Statement statement = connection.createStatement();
		
		Iterator<Transaction> it = transactions.iterator();
		
		while(it.hasNext()) {
			Transaction t = it.next();
			String action = "INSERT INTO Transactions (name, amount) " + "VALUES ('" + t.getName() + "'," + t.getAmount() + ")";
			statement.execute(action);
		}
	}
	
	/**
	 * Deletes a transaction from the database
	 * @param connection the connection to the DB
	 * @param transaction the transaction to delete
	 * @throws SQLException error
	 */
	public static void deleteTransaction(Connection connection, Transaction transaction) throws SQLException {
		Statement statement = connection.createStatement();
		
		String action = "DELETE FROM Transactions WHERE name='" + transaction.getName() + "' AND amount=" + transaction.getAmount() + ";";
		statement.execute(action);
	}
	
	/**
	 * Inserts a CreditCard into the Database
	 * @param connection the connection to the DB
	 * @param card the card to insert
	 * @throws SQLException error
	 */
	public static void insertCreditCard(Connection connection, CreditCard card) throws SQLException {
		Statement statement = connection.createStatement();
		String action = "INSERT INTO Credit_Cards (name) " + "VALUES ('" + card.getName() + "')";
		statement.execute(action);
	}
	
	/**
	 * Reads in all data from the database and populates interim objects
	 * @param connection the connection to the db
	 * @return the new CreditCardManager
	 * @throws SQLException 
	 */
	public static CreditCardManager readDatabase(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		CreditCardManager manager = new CreditCardManager();

		ResultSet results = statement.executeQuery("SELECT * FROM Credit_Cards");		
		while(results.next()) {
			String name = results.getString("name");
			int id = results.getInt("id");
			
			CreditCard card = new CreditCard(name, id);
			manager.addCreditCard(card);
		}
		
		results = statement.executeQuery("SELECT * FROM Transactions");		
		while(results.next()) {
			String name = results.getString("name");
			double amount = results.getDouble("amount");
			int ccid = results.getInt("cc_id");
			
			Transaction transaction = new Transaction(name, amount);
			manager.addTransactionToCard(ccid, transaction);
		}
		
		return manager;
	}
	
	
}
