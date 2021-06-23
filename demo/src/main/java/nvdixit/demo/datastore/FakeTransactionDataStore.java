package nvdixit.demo.datastore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import nvdixit.demo.Transaction.Transaction;
import nvdixit.demo.database.DBManager;

@Repository
public class FakeTransactionDataStore {
	private static List<Transaction> TRANSACTIONS = new ArrayList<Transaction>();
	
	public List<Transaction> getTransactions(int ccid) {
		TRANSACTIONS = DBManager.getAllTransactions(ccid);
		return TRANSACTIONS;
	}
}
