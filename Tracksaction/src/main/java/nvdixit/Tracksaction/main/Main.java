package nvdixit.Tracksaction.main;

import nvdixit.Tracksaction.Manager.CreditCardManager;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ConnectionString;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientSettings;

public class Main {

	public static void main(String[] args) {
		
		MongoClient mongoClient = MongoClients.create();
		 
		CreditCardManager manager = new CreditCardManager();
		
	}

}
