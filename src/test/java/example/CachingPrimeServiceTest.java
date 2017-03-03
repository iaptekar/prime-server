package example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class CachingPrimeServiceTest {

	private PrimeService service;

	@Before
	public void setup() {
		service = new CachingPrimeService(new BasicPrimeChecker());
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeMaxValueShouldThrowException() {
		service.countPrimes(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void zeroMaxValueShouldThrowException() {
		service.countPrimes(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneMaxValueShouldThrowException() {
		service.countPrimes(1);
	}

	@Test
	public void twoMaxValueShouldReturnTwo() {
		Collection<Integer> primes = service.countPrimes(2).getPrimes();
		assertThat(primes.size(), is(1));
		int prime = primes.iterator().next();
		assertThat(prime, is(2));
	}

	@Test
	public void returnAllPrimesLessThanTwenty() {
		Collection<Integer> primes = service.countPrimes(20).getPrimes();
		assertThat(primes.size(), is(8));
		Iterator<Integer> iterator = primes.iterator();
		assertThat(iterator.next(), is(2));
		assertThat(iterator.next(), is(3));
		assertThat(iterator.next(), is(5));
		assertThat(iterator.next(), is(7));
		assertThat(iterator.next(), is(11));
		assertThat(iterator.next(), is(13));
		assertThat(iterator.next(), is(17));
		assertThat(iterator.next(), is(19));
	}

}
