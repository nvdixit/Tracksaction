package nvdixit.demo.datastore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import nvdixit.demo.CreditCard.CreditCard;
import nvdixit.demo.database.DBManager;

@Repository
public class FakeCCDataStore {
	private static final List<CreditCard> CREDIT_CARDS = new ArrayList<CreditCard>();
	
	static {
		CREDIT_CARDS.addAll(0, DBManager.getAllCreditCards());
	}
	
	public List<CreditCard> getCreditCards() {
		return CREDIT_CARDS;
	}
}
