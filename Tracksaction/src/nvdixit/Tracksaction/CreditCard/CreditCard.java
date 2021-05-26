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
	
	/** The name of the Credit Card */
	private String name;
	/** The Transactions on the Credit Card */
	private ArrayList<Transaction> transactions;
	
	/**
	 * Constructs a new CreditCard
	 * @param name the CreditCard's name
	 */
	public CreditCard(String name) {
		this.setName(name);
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
