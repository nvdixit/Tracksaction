package nvdixit.demo.datastore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import nvdixit.demo.Transaction.Transaction;
import nvdixit.demo.database.DBManager;

@Repository
public class FakeTransactionDataStore {
	private static final List<Transaction> TRANSACTIONS = new ArrayList<Transaction>();
	
	static {
		TRANSACTIONS.addAll(0, DBManager.getAllTransactions(1));
	}
	
	public List<Transaction> getTransactions() {
		return TRANSACTIONS;
	}
}
