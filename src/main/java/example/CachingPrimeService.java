package example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.IntStream;

public class CachingPrimeService implements PrimeService {

	private final ConcurrentMap<Integer, Boolean> cache = new ConcurrentHashMap<>();

	private final PrimeChecker checker;

	public CachingPrimeService(PrimeChecker checker) {
		this.checker = checker;
	}

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
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		boolean isPrime = checker.isPrime(n);
		cache.put(n, isPrime);
		return isPrime;
	}
}
