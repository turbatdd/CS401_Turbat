package lab11.prob3A;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        final Stream<Integer> primes = Stream.iterate(2, n -> {
            int next = n + 1;
            while (!isPrime(next)) {
                next++;
            }
            return next;
        });
        primes.limit(10).forEach(System.out::println);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
