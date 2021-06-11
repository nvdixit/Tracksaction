package nvdixit.demo.datastore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import nvdixit.demo.model.Transaction;

@Repository
public class FakeTransactionDataStore {
	private static final List<Transaction> TRANSACTIONS = new ArrayList<Transaction>();
	
	static {
		TRANSACTIONS.add(new Transaction("Gas", 50.00));
		TRANSACTIONS.add(new Transaction("Rent", 2000.00));
		TRANSACTIONS.add(new Transaction("Groceries", 100.00));
	}
	
	public List<Transaction> getTransactions() {
		return TRANSACTIONS;
	}
}
