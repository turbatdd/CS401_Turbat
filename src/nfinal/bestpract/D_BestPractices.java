package nfinal.bestpract;

import java.util.*;
import java.util.stream.*;

/**
 * Section D: Best Practices and Tips When Using Streams
 */
public class D_BestPractices {

    public static void main(String[] args) {

        // =====================================================
        // TIP 1: A stream can only be consumed ONCE!
        // =====================================================
        System.out.println("TIP 1: Stream can only be consumed once");
        Stream<String> stream = Stream.of("a", "b", "c");
        stream.forEach(System.out::print);
        System.out.println();
        // Uncommenting the next line would throw IllegalStateException:
        // stream.forEach(System.out::print); // ERROR: stream has already been operated upon

        System.out.println("-----------------------------");

        // =====================================================
        // TIP 2: Streams are LAZY - intermediate operations are not
        //        executed until a terminal operation is invoked
        // =====================================================
        System.out.println("TIP 2: Streams are lazy");
        List<String> names = Arrays.asList("Adam", "Mike", "Moe", "Mark");
        // Nothing happens here until forEach (terminal) is called
        Stream<String> lazyStream = names.stream()
                .filter(x -> {
                    System.out.println("  Filtering: " + x);
                    return x.startsWith("M");
                })
                .map(x -> {
                    System.out.println("  Mapping: " + x);
                    return x.toUpperCase();
                });
        System.out.println("No output yet... calling terminal operation now:");
        lazyStream.forEach(x -> System.out.println("  Result: " + x));

        System.out.println("-----------------------------");

        // =====================================================
        // TIP 3: Use method references when possible for cleaner code
        // =====================================================
        System.out.println("TIP 3: Method references vs lambdas");
        // Lambda:       names.stream().map(s -> s.toUpperCase())
        // Method ref:   names.stream().map(String::toUpperCase)    <-- preferred
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // TIP 4: Use Optional properly with streams
        // =====================================================
        System.out.println("TIP 4: Using Optional with findFirst/findAny");
        // orElse provides a default if no match found
        String result = names.stream()
                .filter(s -> s.startsWith("Z"))
                .findFirst()
                .orElse("No name found");
        System.out.println("Search for Z: " + result);

        // ifPresent only executes if value exists
        names.stream()
                .filter(s -> s.startsWith("A"))
                .findFirst()
                .ifPresent(s -> System.out.println("Found: " + s));

        System.out.println("-----------------------------");

        // =====================================================
        // TIP 5: Prefer specific stream types for primitives
        // =====================================================
        System.out.println("TIP 5: Use IntStream/DoubleStream for primitives");
        // BAD: Stream<Integer> causes autoboxing overhead
        // GOOD: IntStream avoids boxing
        int sum = IntStream.rangeClosed(1, 100).sum();
        System.out.println("Sum 1..100 = " + sum);

        System.out.println("-----------------------------");

        // =====================================================
        // TIP 6: Don't modify the source collection during streaming
        // =====================================================
        System.out.println("TIP 6: Never modify source during streaming");
        // BAD (would cause ConcurrentModificationException):
        // names.stream().forEach(n -> names.remove(n));
        // GOOD: collect first, then modify
        List<String> mutableNames = new ArrayList<>(names);
        List<String> toRemove = mutableNames.stream()
                .filter(s -> s.startsWith("M"))
                .collect(Collectors.toList());
        mutableNames.removeAll(toRemove);
        System.out.println("After removing M names: " + mutableNames);

        System.out.println("-----------------------------");

        // =====================================================
        // TIP 7: Parallel streams are NOT always faster
        // =====================================================
        System.out.println("TIP 7: Parallel streams");
        // Use parallel ONLY when:
        //   - Large dataset
        //   - Operations are independent (no shared state)
        //   - Operations are CPU-intensive
        // DO NOT use parallel for small datasets or I/O operations
        List<Integer> bigList = IntStream.rangeClosed(1, 1000000)
                .boxed()
                .collect(Collectors.toList());
        long seqSum = bigList.stream()
                .mapToLong(Integer::longValue)
                .sum();
        long parSum = bigList.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        System.out.println("Sequential sum: " + seqSum);
        System.out.println("Parallel sum: " + parSum);

        System.out.println("-----------------------------");

        // =====================================================
        // TIP 8: Use collect(Collectors.toList()) not forEach + add
        // =====================================================
        System.out.println("TIP 8: Use collect, not forEach + manual add");
        // BAD:
        // List<String> bad = new ArrayList<>();
        // names.stream().filter(s -> s.startsWith("M")).forEach(bad::add);
        // GOOD:
        List<String> good = names.stream()
                .filter(s -> s.startsWith("M"))
                .collect(Collectors.toList());
        System.out.println("Collected: " + good);

        System.out.println("-----------------------------");

        // =====================================================
        // TIP 9: Order matters for performance
        // =====================================================
        System.out.println("TIP 9: Put filter BEFORE map for performance");
        // GOOD: filter first reduces elements before expensive map
        names.stream()
                .filter(s -> s.startsWith("M"))     // reduces to 3 elements
                .map(String::toUpperCase)            // maps only 3
                .forEach(System.out::println);
        // BAD: mapping ALL elements first, then filtering
        // names.stream().map(String::toUpperCase).filter(s -> s.startsWith("M"))...

        System.out.println("-----------------------------");

        // =====================================================
        // TIP 10: Use mapToInt for sum/average instead of reduce on Integer
        // =====================================================
        System.out.println("TIP 10: mapToInt for numeric operations");
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");
        int totalLength = words.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total character count: " + totalLength);
    }
}
