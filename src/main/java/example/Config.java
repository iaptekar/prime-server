package example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public PrimeService primeService() {
		return new SimplePrimeService(new BasicPrimeChecker());
	}
}
