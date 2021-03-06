package nvdixit.Tracksaction.main.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manages all CreditCards
 * @author nikhildixit
 *
 */
public class CreditCardManager {

	/** All credit cards the user has */
	private ArrayList<CreditCard> creditCards;
	
	/**
	 * Constructs a new CreditCardManager
	 */
	public CreditCardManager() {
		creditCards = new ArrayList<CreditCard>();
	}
	
	/**
	 * Adds a CreditCard to the manager
	 * @param card the card to add
	 * @throws SQLException 
	 */
	public void addCreditCard(CreditCard card, boolean writeToDB) throws SQLException {
		creditCards.add(card);
		
		if(writeToDB)
			DBManager.insertCreditCard(card);
	}
	
	/**
	 * Removes a CreditCard from the Manager
	 * @param card the card to remove
	 * @return the removed card
	 */
	public CreditCard removeCreditCard(CreditCard card) {
		Iterator<CreditCard> it = creditCards.iterator();
		
		int index = 0;
		while(it.hasNext()) {
			CreditCard c = it.next();
			
			if(card.equals(c)) {
				return creditCards.remove(index);
			}
			
			index++;
		}
		
		return null;
	}
	
	/**
	 * Adds a Transaction to the given CreditCard
	 * @param card the card to add to 
	 * @param transaction the transaction to add
	 * @throws SQLException 
	 */
	public void addTransactionToCard(int id, Transaction transaction, boolean addToDB) throws SQLException {
		Iterator<CreditCard> it = creditCards.iterator();
		
		while(it.hasNext()) {
			CreditCard c = it.next();
			
			if(id == c.getID()) {
				c.addTransaction(transaction, addToDB);
			}
		}
	}
	
	/**
	 * Removes a Transaction from the given CC
	 * @param card the CC to remove from
	 * @param transaction the transaction to remove
	 * @throws SQLException 
	 */
	public Transaction removeTransactionFromCard(int id, Transaction transaction) throws SQLException {
		Iterator<CreditCard> it = creditCards.iterator();
		
		while(it.hasNext()) {
			CreditCard c = it.next();
			
			if(id == c.getID()) {
				return c.removeTransaction(transaction);
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the CreditCards in the manager
	 * @return the CreditCards in the manager
	 */
	public ArrayList<CreditCard> getCreditCards() {
		return this.creditCards;
	}
	
	/**
	 * Returns a String of the CCM
	 * @return a String of the CCM
	 */
	public String toString() {
		Iterator<CreditCard> it = creditCards.iterator();
		
		StringBuilder sb = new StringBuilder("Manager\n");
		
		while(it.hasNext()) {
			sb.append("\t" + it.next().toString() + "\n");
		}
		
		return sb.toString();
	}
}
