package nvdixit.Tracksaction.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

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
	 * @throws SQLException 
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
}
