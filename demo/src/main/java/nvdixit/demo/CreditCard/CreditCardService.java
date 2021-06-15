package nvdixit.demo.CreditCard;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvdixit.demo.database.DBManager;

@Service
public class CreditCardService {
	
	private final CreditCardDataAccessService creditCardDataAccessService;
	
	@Autowired
	public CreditCardService(CreditCardDataAccessService creditCardDataAccessService) {
		this.creditCardDataAccessService = creditCardDataAccessService;
	}
	
	List<CreditCard> getCreditCards() {
		return this.creditCardDataAccessService.getCreditCards();
	}

	public void uploadCreditCard(int id, String name) {
		try {
			DBManager.insertCreditCard(new CreditCard(id, name));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
