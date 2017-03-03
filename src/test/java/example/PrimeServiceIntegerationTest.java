package example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PrimeServiceIntegerationTest {

	@Autowired
	private TestRestTemplate rest;

	@Test
	public void findPrimesLessThanTenAsJson() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String body = rest.exchange("/primes/10", HttpMethod.GET, entity, String.class).getBody();
		assertThat(body, is("{\"initial\":10,\"primes\":[2,3,5,7]}"));
	}

	@Test
	public void findPrimesLessThanTenAsXml() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String body = rest.exchange("/primes/10", HttpMethod.GET, entity, String.class).getBody();
		assertThat(body, is(
				"<PrimeSequence><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeSequence>"));
	}

	@Test
	public void throw400ErrorForBadRequest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String body = rest.exchange("/primes/0", HttpMethod.GET, entity, String.class).getBody();
		assertThat(body, is("Maximum prime must be greater than one"));
	}

}
