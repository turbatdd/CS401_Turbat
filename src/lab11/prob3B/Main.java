package lab11.prob3B;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    private final Supplier<Stream<Integer>> primesSupplier = () ->
            Stream.iterate(2, n -> {
                int next = n + 1;
                while (!isPrime(next)) {
                    next++;
                }
                return next;
            });

    public static void main(String[] args) {
        Main ps = new Main();

        ps.printFirstNPrimes(10);

        System.out.println("====");

        ps.printFirstNPrimes(2);
    }

    public void printFirstNPrimes(long n) {
        primesSupplier.get()
                .limit(n)
                .forEach(System.out::println);
    }


    private static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
