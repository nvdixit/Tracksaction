package nvdixit.demo.Transaction;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvdixit.demo.database.DBManager;
import nvdixit.demo.filestore.FileStore;

@Service
public class TransactionService {
	
	private final TransactionDataAccessService transactionDataAccessService;
	
	@Autowired
	public TransactionService(TransactionDataAccessService transactionDataAccessService) {
		this.transactionDataAccessService = transactionDataAccessService;
	}
	
	List<Transaction> getTransactions(int ccid) {
		return this.transactionDataAccessService.getTransactions(ccid);
	}

	public void uploadTransaction(String name, double amount, int ccid) {
		System.out.println(ccid);
		try {
			DBManager.insertTransaction(new Transaction(name, amount, ccid));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
