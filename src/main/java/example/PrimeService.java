package example;

/**
 * Service to produce a list of primes up to max, inclusive if max is a prime.
 *
 */
public interface PrimeService {

	PrimeSequence countPrimes(int max);
}
