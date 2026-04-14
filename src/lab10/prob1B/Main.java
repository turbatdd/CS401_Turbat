package lab10.prob1B;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //1
        Supplier<Double> supplier = () -> Math.random();
        System.out.println("Random number: " + supplier.get());

        //2
        Supplier<Double> supplier2 = new RandomSupplier();
        System.out.println("Random number: " + supplier.get());

    }

    // Inner class
    static class RandomSupplier implements Supplier<Double> {
        @Override
        public Double get() {
            return Math.random();
        }
    }
}
