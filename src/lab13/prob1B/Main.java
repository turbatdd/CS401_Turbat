package lab13.prob1B;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
//        nums.add(3.14); //Error here

//        The compiler doesn’t know whether it’s:
//        List<Integer>
//        List<Double>
//        List<Float>
//        So adding anything (except null) is unsafe.
    }
}
