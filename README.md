#Example prime number service

A REST service providing a JSON response containing a list of prime numbers less than or equal to a given maximum integer


To start: gradle bootRun

usage: hit the URL http://localhost:8080/primes/{max}

run tests: gradle test


The config class can be modified if different implementations of the prime number service or prime number checker are required