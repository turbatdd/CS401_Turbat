package lab13.prob5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static <T extends Comparable<? super T>> T secondSmallest(List<T> list) {
        if (list == null || list.size() < 2) {
            throw new IllegalArgumentException("List must contain at least two elements");
        }

        T smallest = null;
        T secondSmallest = null;

        for (T item : list) {
            if (smallest == null || item.compareTo(smallest) < 0) {
                secondSmallest = smallest;
                smallest = item;
            } else if ((secondSmallest == null || item.compareTo(secondSmallest) < 0)
                    && item.compareTo(smallest) != 0) {
                secondSmallest = item;
            }
        }

        if (secondSmallest == null) {
            throw new IllegalArgumentException("No second smallest element (all elements may be equal)");
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
        // Works with Integers
        List<Integer> ints = Arrays.asList(5, 1, 9, 2, 8);
        System.out.println("Second smallest Integer: " + secondSmallest(ints)); // 2

        // Works with Strings
        List<String> strings = Arrays.asList("Banana", "Apple", "Cherry", "Date");
        System.out.println("Second smallest String: " + secondSmallest(strings)); // Banana
    }
}
