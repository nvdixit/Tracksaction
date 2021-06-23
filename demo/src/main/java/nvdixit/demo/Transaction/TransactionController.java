package nvdixit.demo.Transaction;

import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nvdixit.demo.database.DBManager;

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
	public List<Transaction> getTransactions(@RequestParam("ccid") int ccid) {
		return DBManager.getAllTransactions(ccid);
	}
	
	@PostMapping(path = "{transactionName}/transaction/upload")
	public void uploadTransaction(@RequestParam("name") String name, @RequestParam("amount") double amount, @RequestParam("ccid") int ccid) {
		transactionService.uploadTransaction(name, amount, ccid);
	}
	
	@PostMapping(path = "transaction/delete")
	public void deleteTransaction(@RequestParam("name") String name, @RequestParam("amount") double amount) {
		try {
			DBManager.deleteTransaction(name, amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
