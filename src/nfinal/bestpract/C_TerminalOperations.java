package nfinal.bestpract;

import java.util.*;
import java.util.stream.*;

/**
 * Section C: Terminal Operations
 * These operations produce a result or side effect and CONSUME the stream.
 * After a terminal operation, the stream cannot be reused.
 * Terminal ops: forEach, collect, count, reduce, min, max, findFirst, findAny,
 *               anyMatch, allMatch, noneMatch, toArray, sum, average, summaryStatistics
 */
public class C_TerminalOperations {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Moe", "Adam", "Ibrahim", "Julliane", "Mike", "John", "Mark");
        List<Integer> numbers = Arrays.asList(20, 45, 50, 30, 4, 67, 10, 34, 78);

        // =====================================================
        // 1. forEach() - performs an action on each element
        // =====================================================
        System.out.println("1. forEach:");
        names.stream().forEach(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 2. collect() - collects elements into a collection
        // =====================================================
        System.out.println("2. collect to List:");
        List<String> filtered = names.stream()
                .filter(x -> x.startsWith("M"))
                .collect(Collectors.toList());
        System.out.println(filtered);

        System.out.println("-----------------------------");

        // =====================================================
        // 3. collect() to Set (removes duplicates)
        // =====================================================
        List<String> withDupes = Arrays.asList("Moe", "Adam", "Moe", "Adam");
        System.out.println("3. collect to Set:");
        Set<String> uniqueNames = withDupes.stream().collect(Collectors.toSet());
        System.out.println(uniqueNames);

        System.out.println("-----------------------------");

        // =====================================================
        // 4. collect() to Map
        // =====================================================
        System.out.println("4. collect to Map (name -> name length):");
        Map<String, Integer> nameMap = names.stream()
                .collect(Collectors.toMap(n -> n, String::length));
        nameMap.forEach((k, v) -> System.out.println(k + " = " + v));

        System.out.println("-----------------------------");

        // =====================================================
        // 5. collect() with joining
        // =====================================================
        System.out.println("5. collect with Collectors.joining:");
        String joined = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joined);

        System.out.println("-----------------------------");

        // =====================================================
        // 6. count() - counts elements
        // =====================================================
        System.out.println("6. count:");
        long count = names.stream()
                .filter(x -> x.length() > 3)
                .count();
        System.out.println("Names longer than 3 chars: " + count);

        System.out.println("-----------------------------");

        // =====================================================
        // 7. reduce() - combines elements into a single result
        // =====================================================
        System.out.println("7. reduce - sum of doubles:");
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (a, b) -> a + b);
        System.out.println("Total = " + total);

        System.out.println("-----------------------------");

        // =====================================================
        // 8. reduce() - concatenate strings
        // =====================================================
        System.out.println("8. reduce - concatenate names:");
        Optional<String> concatenated = names.stream()
                .reduce((a, b) -> a + ", " + b);
        concatenated.ifPresent(System.out::println);

        System.out.println("-----------------------------");

        // =====================================================
        // 9. min() and max()
        // =====================================================
        System.out.println("9. min and max:");
        Optional<String> smallest = names.stream().min(String::compareToIgnoreCase);
        Optional<String> largest = names.stream().max(String::compareToIgnoreCase);
        smallest.ifPresent(s -> System.out.println("Min: " + s));
        largest.ifPresent(s -> System.out.println("Max: " + s));

        System.out.println("-----------------------------");

        // =====================================================
        // 10. findFirst() - returns the first element
        // =====================================================
        System.out.println("10. findFirst:");
        Optional<String> first = names.stream()
                .filter(s -> s.startsWith("J"))
                .findFirst();
        System.out.println("First with J: " + first.orElse("No name found"));

        System.out.println("-----------------------------");

        // =====================================================
        // 11. findAny() - returns any matching element
        // =====================================================
        System.out.println("11. findAny:");
        Optional<String> any = names.stream()
                .filter(s -> s.startsWith("M"))
                .findAny();
        any.ifPresent(s -> System.out.println("Any with M: " + s));

        System.out.println("-----------------------------");

        // =====================================================
        // 12. anyMatch, allMatch, noneMatch
        // =====================================================
        System.out.println("12. Matching operations:");
        boolean anyM = names.stream().anyMatch(s -> s.startsWith("M"));
        boolean allLong = names.stream().allMatch(s -> s.length() > 2);
        boolean noneZ = names.stream().noneMatch(s -> s.startsWith("Z"));
        System.out.println("anyMatch starts with M: " + anyM);
        System.out.println("allMatch length > 2: " + allLong);
        System.out.println("noneMatch starts with Z: " + noneZ);

        System.out.println("-----------------------------");

        // =====================================================
        // 13. sum() and average() on IntStream
        // =====================================================
        System.out.println("13. sum and average:");
        int sum = IntStream.range(1, 5).sum();
        OptionalDouble avg = IntStream.range(1, 5).average();
        System.out.println("Sum of 1..4: " + sum);
        avg.ifPresent(a -> System.out.println("Average of 1..4: " + a));

        System.out.println("-----------------------------");

        // =====================================================
        // 14. summaryStatistics() - get min, max, sum, avg, count
        // =====================================================
        System.out.println("14. summaryStatistics:");
        IntSummaryStatistics stats = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();
        System.out.println(stats);

        System.out.println("-----------------------------");

        // =====================================================
        // 15. toArray() - collect to an array
        // =====================================================
        System.out.println("15. toArray:");
        String[] nameArr = names.stream()
                .filter(s -> s.startsWith("M"))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(nameArr));

        System.out.println("-----------------------------");

        // =====================================================
        // 16. Collectors.groupingBy()
        // =====================================================
        System.out.println("16. groupingBy name length:");
        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));
        grouped.forEach((k, v) -> System.out.println("Length " + k + ": " + v));

        System.out.println("-----------------------------");

        // =====================================================
        // 17. Collectors.partitioningBy()
        // =====================================================
        System.out.println("17. partitioningBy starts with M:");
        Map<Boolean, List<String>> partitioned = names.stream()
                .collect(Collectors.partitioningBy(s -> s.startsWith("M")));
        System.out.println("Starts with M: " + partitioned.get(true));
        System.out.println("Others: " + partitioned.get(false));
    }
}
