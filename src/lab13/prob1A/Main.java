package lab13.prob1A;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> ints = new ArrayList<>();
//        ints.add(1);
//        ints.add(2);
//        List<Number> nums = ints; // Error in here
//        nums.add(3.14); //Compile time error

//        Java generics are invariant.
//        Even though Integer is a subtype of Number, List<Integer> is NOT a subtype of List<Number>.
//        So this assignment is illegal.

        List ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<Number> nums = ints; // Warning here
        nums.add(3.14);
    }
}
