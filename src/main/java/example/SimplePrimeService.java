package example;

import java.util.stream.IntStream;

public class SimplePrimeService implements PrimeService {

	private final PrimeChecker checker;

	public SimplePrimeService(PrimeChecker checker) {
		this.checker = checker;
	}

	@Override
	public PrimeSequence countPrimes(int max) {
		if (max < 2) {
			throw new IllegalArgumentException("Maximum prime must be greater than one");
		}
		PrimeSequence primes = new PrimeSequence(max);
		IntStream.rangeClosed(2, max).filter(n -> checker.isPrime(n)).forEach(prime -> primes.addPrime(prime));
		return primes;
	}

}
