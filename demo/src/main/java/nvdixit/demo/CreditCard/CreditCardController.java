package nvdixit.demo.CreditCard;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nvdixit.demo.Transaction.Transaction;
import nvdixit.demo.Transaction.TransactionService;
import nvdixit.demo.database.DBManager;

@RestController	
@RequestMapping("api/v1/creditCards")
@CrossOrigin("*")
public class CreditCardController {
	
	private final CreditCardService creditCardService;
	
	@Autowired
	public CreditCardController(CreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}
	
	@GetMapping
	public List<CreditCard> getCreditCards() {
		return creditCardService.getCreditCards();
	}
	
	@PostMapping(path = "{creditCardName}/creditCard/upload")
	public void uploadTransaction(@RequestParam("name") String name) {
		try {
			creditCardService.uploadCreditCard(DBManager.getHigestCCIndex() + 1, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
