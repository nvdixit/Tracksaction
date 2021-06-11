package nvdixit.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	
	private final TransactionDataAccessService transactionDataAccessService;
	
	@Autowired
	public TransactionService(TransactionDataAccessService transactionDataAccessService) {
		this.transactionDataAccessService = transactionDataAccessService;
	}
	
	List<Transaction> getTransactions() {
		return this.transactionDataAccessService.getTransactions();
	}
}
