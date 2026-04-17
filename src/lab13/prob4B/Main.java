package lab13.prob4B;

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
        List<Object> objs = new ArrayList<>();
        objs.add(1);
        objs.add("two");
        List<? super Integer> ints = objs;
        System.out.println(ints);
        ints.add(3);

//        double dbl = sum(ints); //compile-time error

//        sum requires Collection<? extends Number>
    }
}
