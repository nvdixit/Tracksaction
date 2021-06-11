package nvdixit.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import nvdixit.demo.datastore.FakeTransactionDataStore;

@Repository
public class TransactionDataAccessService {

	private final FakeTransactionDataStore fakeTransactionDataStore;
	
	@Autowired
	public TransactionDataAccessService(FakeTransactionDataStore fakeTransactionDataStore) {
		this.fakeTransactionDataStore = fakeTransactionDataStore;
	}
	
	List<Transaction> getTransactions() {
		return this.fakeTransactionDataStore.getTransactions();
	}
}