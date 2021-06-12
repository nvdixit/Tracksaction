package nvdixit.demo.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvdixit.demo.database.DBManager;
import nvdixit.demo.filestore.FileStore;

@Service
public class TransactionService {
	
	private final TransactionDataAccessService transactionDataAccessService;
	private final FileStore fileStore;
	
	@Autowired
	public TransactionService(TransactionDataAccessService transactionDataAccessService, FileStore fileStore) {
		this.transactionDataAccessService = transactionDataAccessService;
		this.fileStore = fileStore;
	}
	
	List<Transaction> getTransactions() {
		return this.transactionDataAccessService.getTransactions();
	}

	public void uploadTransaction(String name, double amount) {
		try {
			DBManager.insertTransaction(new Transaction(name, 0.0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
