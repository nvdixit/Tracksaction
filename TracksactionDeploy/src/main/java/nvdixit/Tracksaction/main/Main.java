package nvdixit.Tracksaction.main;

import nvdixit.Tracksaction.main.model.CreditCard;
import nvdixit.Tracksaction.main.model.CreditCardManager;
import nvdixit.Tracksaction.main.model.DBManager;
import nvdixit.Tracksaction.main.model.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		SpringApplication.run(Main.class, args);
		
		System.out.println(DBManager.readDatabase().toString());	
	}
}
