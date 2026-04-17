package lab13.prob4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) s += num.doubleValue();
        return s;
    }


    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
        double dbl = sum(nums);
//        nums.add(3.14); //compile-time error

//        The compiler doesn’t know whether it’s:
//        List<Integer>
//        List<Double>
//        So adding 3.14 (Double) might break a List<Integer>.
    }
}
