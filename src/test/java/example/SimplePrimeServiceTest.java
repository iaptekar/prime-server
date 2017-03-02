package example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class SimplePrimeServiceTest {

	@Test(expected = IllegalArgumentException.class)
	public void negativeMaxValueShouldThrowException() {
		new SimplePrimeService().countPrimes(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void zeroMaxValueShouldThrowException() {
		new SimplePrimeService().countPrimes(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneMaxValueShouldThrowException() {
		new SimplePrimeService().countPrimes(1);
	}

	@Test
	public void twoMaxValueShouldReturnTwo() {
		Collection<Integer> primes = new SimplePrimeService().countPrimes(2).getPrimes();
		assertThat(primes.size(), is(1));
		int prime = primes.iterator().next();
		assertThat(prime, is(2));
	}

	@Test
	public void returnAllPrimesLessThanTwenty() {
		Collection<Integer> primes = new SimplePrimeService().countPrimes(20).getPrimes();
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
