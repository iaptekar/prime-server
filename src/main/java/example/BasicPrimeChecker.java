package example;

public class BasicPrimeChecker implements PrimeChecker {

	@Override
	public boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
