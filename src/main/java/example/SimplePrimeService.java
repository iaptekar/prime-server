package example;

import java.util.stream.IntStream;

public class SimplePrimeService implements PrimeService {

	@Override
	public PrimeSequence countPrimes(int max) {
		if (max < 2) {
			throw new IllegalArgumentException("Maximum prime must be greater than one");
		}
		PrimeSequence primes = new PrimeSequence(max);
		IntStream.rangeClosed(2, max).filter(n -> isPrime(n)).forEach(prime -> primes.addPrime(prime));
		return primes;
	}

	private boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
