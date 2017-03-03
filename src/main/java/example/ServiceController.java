package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@Autowired
	private PrimeService service;

	@RequestMapping(path = "/primes/{max}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public PrimeSequence primes(@PathVariable("max") int max) {
		return service.countPrimes(max);
	}

	@ExceptionHandler({ IllegalArgumentException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(IllegalArgumentException e) {
		return e.getMessage();
	}
}