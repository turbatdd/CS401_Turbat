package nfinal.bestpract;

import java.util.*;
import java.util.stream.*;

/**
 * Section A: How to Create Streams
 * Demonstrates all the different ways to create streams in Java.
 */
public class A_CreatingStreams {

    public static void main(String[] args) {

        // =====================================================
        // 1. Stream from a Collection (List, Set)
        // =====================================================
        List<String> names = Arrays.asList("Adam", "Ibrahim", "Mike", "Moe");
        Stream<String> streamFromList = names.stream();
        System.out.println("1. Stream from List:");
        streamFromList.forEach(System.out::println);


        System.out.println("-----------------------------");

        // =====================================================
        // 2. Stream from an Array using Arrays.stream()
        // =====================================================
        String[] nameArray = {"Al", "Brent", "Sarika", "Hans"};
        Stream<String> streamFromArray = Arrays.stream(nameArray);
        System.out.println("2. Stream from Array (Arrays.stream):");
        streamFromArray.forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 3. Stream from an Array using Stream.of()
        // =====================================================
        Stream<String> streamOf = Stream.of("Ava", "Aneri", "Alberto");
        System.out.println("3. Stream using Stream.of():");
        streamOf.forEach(System.out::println);

        streamOf
                .filter(x -> x.startsWith("A"))
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 4. IntStream using range (exclusive end)
        // =====================================================
        System.out.println("4. IntStream.range(1, 10) - end exclusive:");
        IntStream.range(1, 10)
                .forEach(System.out::print);

        System.out.println();
        System.out.println("-----------------------------");

        // =====================================================
        // 5. IntStream using rangeClosed (inclusive end)
        // =====================================================
        System.out.println("5. IntStream.rangeClosed(1, 10) - end inclusive:");
        IntStream.rangeClosed(1, 10).forEach(System.out::print);
        System.out.println();

        System.out.println("-----------------------------");

        // =====================================================
        // 6. Stream from int array (produces IntStream)
        // =====================================================
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("6. IntStream from int[]:");
        Arrays.stream(numbers).forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("-----------------------------");

        // =====================================================
        // 7. Stream.iterate() - infinite stream with limit
        // =====================================================
        System.out.println("7. Stream.iterate(1, n -> n + 1) with limit(5):");
        Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(System.out::print);
        System.out.println();

        System.out.println("-----------------------------");

        // =====================================================
        // 8. Stream.generate() - infinite stream with limit
        // =====================================================
        System.out.println("8. Stream.generate(Math::random) with limit(3):");
        Stream.generate(Math::random)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 9. Stream.concat() - combining two streams
        // =====================================================
        Stream<String> s1 = Stream.of("Zaineh", "Yasmeen");
        Stream<String> s2 = Stream.of("Ngo", "Pham");
        Stream<String> combined = Stream.concat(s1, s2);
        System.out.println("9. Stream.concat():");
        combined.forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 10. Parallel Stream from a Collection
        // =====================================================
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("10. Parallel Stream:");
        nums.parallelStream().forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("-----------------------------");

        // =====================================================
        // 11. Stream.empty() - creating an empty stream
        // =====================================================
        Stream<String> emptyStream = Stream.empty();
        System.out.println("11. Empty stream count: " + emptyStream.count());
    }
}
