package nvdixit.Tracksaction.CreditCard;

import java.util.ArrayList;
import java.util.Iterator;

import nvdixit.Tracksaction.Transaction.*;

/**
 * Credit Card that holds Transactions
 * @author nikhildixit
 *
 */
public class CreditCard {
	
	/** The backend ID number of the CC*/
	private int id;
	/** The name of the Credit Card */
	private String name;
	/** The Transactions on the Credit Card */
	private ArrayList<Transaction> transactions;
	
	/**
	 * Constructs a new CreditCard
	 * @param name the CreditCard's name
	 */
	public CreditCard(String name, int id) {
		this.setName(name);
		this.setID(id);
		transactions = new ArrayList<Transaction>();
	}
	
	/**
	 * Sets the name of the CC
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the CC
	 * @return the name of the CC
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Adds a transaction to the CC
	 * @param transaction the transaction to add
	 */
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
		transaction.setCCID(this.getID());
	}
	
	/**
	 * Sets the ID num
	 * @param num the ID to set
	 */
	public void setID(int num) {
		this.id = num;
	}
	
	/**
	 * Returns the CCID num
	 * @return the CCID num
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Removes a Transaction from the CC
	 * @param transaction the Transaction to remove
	 * @return the removed Transaction
	 */
	public Transaction removeTransaction(Transaction transaction) {
		Iterator<Transaction> it = transactions.iterator();
		
		int index = 0;
		while(it.hasNext()) {
			Transaction t = it.next();
			
			if(t.equals(transaction)) {
				return transactions.remove(index);
			}
			
			index++;
		}
		
		return null;
	}

	/**
	 * Returns the Transactions on the card
	 * @return the Transactions on the card
	 */
	public ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}
	
	/**
	 * Returns a String instance of the CreditCard
	 * @return a String instance of the CreditCard
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getName() + "\n");
		
		Iterator<Transaction> it = transactions.iterator();
		
		while(it.hasNext()) {
			sb.append("\t" + it.next().toString() + "\n");
		}
		
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		return true;
	}
}
