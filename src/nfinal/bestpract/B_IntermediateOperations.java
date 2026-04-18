package nfinal.bestpract;

import java.util.*;
import java.util.stream.*;

/**
 * Section B: Intermediate Operations
 * These operations return a new stream and are LAZY (not executed until a terminal operation is called).
 * Intermediate ops: filter, map, flatMap, sorted, distinct, peek, limit, skip, mapToInt/Double/Long
 */
public class B_IntermediateOperations {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Moe", "Adam", "Ibrahim", "Juliane", "Mike", "Moe", "John", "Mark");

        // =====================================================
        // 1. filter() - keeps elements matching the predicate
        // =====================================================
        System.out.println("1. filter - names starting with 'M':");
        names.stream()
                .filter(x -> x.startsWith("M"))
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 2. map() - transforms each element
        // =====================================================
        System.out.println("2. map - convert all names to uppercase:");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 3. map() with arithmetic on Integer stream
        // =====================================================
        System.out.println("3. map - multiply each number by 2 and add 1:");
        Integer[] arr = {1, 2, 3, 4};
        Stream.of(arr)
                .map(n -> 2 * n + 1)
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 4. flatMap() - flattens nested structures
        // =====================================================
        System.out.println("4. flatMap - flatten list of lists:");
        List<List<String>> nested = Arrays.asList(
                Arrays.asList("CS401", "CS545"),
                Arrays.asList("CS221", "CS390"),
                Arrays.asList("CS472")
        );
        nested.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 5. flatMap() - splitting words from sentences
        // =====================================================
        System.out.println("5. flatMap - split sentences into words:");
        List<String> sentences = Arrays.asList("Java Streams are powerful", "Lambdas are great");
        sentences.stream()
                .map(s -> s.split("\\s+"))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 6. sorted() - natural order
        // =====================================================
        System.out.println("6. sorted - natural order:");
        names.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 7. sorted() with Comparator
        // =====================================================
        System.out.println("7. sorted - by length:");
        names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 8. distinct() - removes duplicates
        // =====================================================
        System.out.println("8. distinct - remove duplicate names:");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 9. peek() - perform an action without consuming (useful for debugging)
        // =====================================================
        System.out.println("9. peek - debug intermediate values:");
        List<String> result = names.stream()
                .filter(x -> x.startsWith("M"))
                .peek(x -> System.out.println("  After filter: " + x))
                .map(String::toUpperCase)
                .peek(x -> System.out.println("  After map: " + x))
                .collect(Collectors.toList());
        System.out.println("Result: " + result);

        System.out.println("-----------------------------");

        // =====================================================
        // 10. limit() - take first N elements
        // =====================================================
        System.out.println("10. limit(3) - take first 3:");
        names.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 11. skip() - skip first N elements
        // =====================================================
        System.out.println("11. skip(5) - skip first 5:");
        IntStream.range(1, 10)
                .skip(5)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("-----------------------------");

        // =====================================================
        // 12. mapToInt() - convert stream to IntStream
        // =====================================================
        System.out.println("12. mapToInt - average of squares:");
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 13. Chaining filter + map + sorted
        // =====================================================
        System.out.println("13. Chaining: filter names starting with 'M', lowercase, sorted:");
        names.stream()
                .filter(x -> x.startsWith("M"))
                .map(String::toLowerCase)
                .sorted()
                .forEach(System.out::println);
    }
}
