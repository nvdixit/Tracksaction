package nvdixit.demo.CreditCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nvdixit.demo.Transaction.Transaction;
import nvdixit.demo.datastore.FakeCCDataStore;
import nvdixit.demo.datastore.FakeTransactionDataStore;

@Repository
public class CreditCardDataAccessService {
	
	private final FakeCCDataStore fakeCCDataStore;
	
	@Autowired
	public CreditCardDataAccessService(FakeCCDataStore fakeCCDataStore) {
		this.fakeCCDataStore = fakeCCDataStore;
	}
	
	List<CreditCard> getCreditCards() {
		return this.fakeCCDataStore.getCreditCards();
	}
}
