package lab10.prob4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> data = Arrays.asList("apple", "apply", "banan", "candy", "catch");

        char targetChar = 'a';
        char forbiddenChar = 'd';
        int targetLength = 5;

        int result = countWords(data, targetChar, forbiddenChar, targetLength);
        System.out.println("Number of matching words: " + result);
    }

    public static int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream()
                .filter(word -> word.length() == len)
                .filter(word -> word.contains(String.valueOf(c)))
                .filter(word -> !word.contains(String.valueOf(d)))
                .count();
    }
}
