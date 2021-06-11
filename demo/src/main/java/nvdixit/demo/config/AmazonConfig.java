package nvdixit.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {

	@Bean
	public AmazonS3 s3() {
		AWSCredentials creds = new BasicAWSCredentials("AKIA4N747AXT56YX4DPM", "byiFQd9NMW4C+cadMj59XAft9X7LpTPNhY2p3LE/");		
		return AmazonS3ClientBuilder.standard().withRegion("us-east-1").withCredentials(new AWSStaticCredentialsProvider(creds)).build();
	}
}
