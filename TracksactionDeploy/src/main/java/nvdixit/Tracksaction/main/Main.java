package nvdixit.Tracksaction.main;

import nvdixit.Tracksaction.CreditCard.CreditCard;
import nvdixit.Tracksaction.DBManager.DBManager;
import nvdixit.Tracksaction.Manager.CreditCardManager;
import nvdixit.Tracksaction.Transaction.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		SpringApplication.run(Main.class, args);
		
		System.out.println(DBManager.readDatabase().toString());			
	}
}
