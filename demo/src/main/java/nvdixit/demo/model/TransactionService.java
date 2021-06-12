package nvdixit.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		System.out.println("Name: " + name);
	}
}
