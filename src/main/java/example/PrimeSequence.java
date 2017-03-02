package example;

import java.util.ArrayList;
import java.util.Collection;

public class PrimeSequence {

	private final int initial;
	private final Collection<Integer> primes = new ArrayList<>();

	public PrimeSequence(int initial) {
		this.initial = initial;
	}

	public void addPrime(int prime) {
		primes.add(prime);
	}

	public int getInitial() {
		return initial;
	}

	public Collection<Integer> getPrimes() {
		return primes;
	}
}
