package nvdixit.demo.Transaction;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController	
@RequestMapping("api/v1/transactions")
@CrossOrigin("*")
public class TransactionController {
	
	private final TransactionService transactionService;
	
	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping
	public List<Transaction> getTransactions() {
		return transactionService.getTransactions();
	}
	
	@PostMapping(path = "{transactionName}/transaction/upload")
	public void uploadTransaction(@RequestParam("name") String name, @RequestParam("amount") double amount) {
		transactionService.uploadTransaction(name, amount);
	}
}
