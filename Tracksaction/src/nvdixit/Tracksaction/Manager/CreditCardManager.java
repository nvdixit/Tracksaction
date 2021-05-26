package nvdixit.Tracksaction.Manager;

import java.util.ArrayList;
import java.util.Iterator;

import nvdixit.Tracksaction.CreditCard.CreditCard;
import nvdixit.Tracksaction.Transaction.Transaction;

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
	 */
	public void addCreditCard(CreditCard card) {
		creditCards.add(card);
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
	 */
	public void addTransactionToCard(CreditCard card, Transaction transaction) {
		card.addTransaction(transaction);
	}
	
	/**
	 * Removes a Transaction from the given CC
	 * @param card the CC to remove from
	 * @param transaction the transaction to remove
	 */
	public Transaction removeTransactionFromCard(CreditCard card, Transaction transaction) {
		Iterator<CreditCard> it = creditCards.iterator();
		
		while(it.hasNext()) {
			CreditCard c = it.next();
			
			if(card.equals(c)) {
				return c.removeTransaction(transaction);
			}
		}
		
		return null;
	}
}