package lab10.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {

        List<Double> result = myBi.apply(2.0, 3.0);
        System.out.println(result);
    }

    static BiFunction<Double, Double, List<Double>> myBi = (x, y) -> {
        List<Double> list = new ArrayList<>();
        list.add(Math.pow(x, y));
        list.add(x * y);
        return list;
    };
}
