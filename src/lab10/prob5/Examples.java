package lab10.prob5;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Examples {

    Employee emp = new Employee("Turuu", 5000);
    Apple apple = new Apple(0.5);

    //type: Class::instanceMethod
    Function<String, String> upper1 = (String x) -> x.toUpperCase();
    Function<String, String> upper2 = String::toUpperCase;

    //	A. (Employee e) -> e.getName()
    Function<Employee, String> getNameRef = Employee::getName;

    //	B. (Employee e,String s) -> e.setName(s)
    BiConsumer<Employee, String> setNameRef = Employee::setName;

    //	C. (String s1,String s2) -> s1.compareTo(s2)
    BiFunction<String, String, Integer> compareRef = String::compareTo;

    //	D. (Integer x,Integer y) -> Math.pow(x,y)
    BiFunction<Integer, Integer, Double> powRef = Math::pow;

    //	E. (Apple a) -> a.getWeight()
    Function<Apple, Double> getWeightRef = Apple::getWeight;

    //	F. (String x) -> Integer.parseInt(x);
    Function<String, Integer> parseIntRef = Integer::parseInt;

//	G. EmployeeNameComparator comp = new EmployeeNameComparator();
//	(Employee e1, Employee e2) -> comp.compare(e1,e2)

    EmployeeNameComparator comp = new EmployeeNameComparator();
    Comparator<Employee> compRef = comp::compare;

    public void evaluator() {
        // A.
        System.out.println("A. Employee Name: " + getNameRef.apply(emp));

        // B.
        setNameRef.accept(emp, "Bob");
        System.out.println("B. Updated Name: " + emp.getName());

        // C.
        System.out.println("C. String Comparison: " + compareRef.apply("apple", "banana"));

        // D.
        System.out.println("D. Power Calculation (2^3): " + powRef.apply(2, 3));

        // E.
        System.out.println("E. Apple Weight: " + getWeightRef.apply(apple));

        // F.
        System.out.println("F. Parsed Integer: " + parseIntRef.apply("123"));

        // G.
        Employee emp2 = new Employee("Charlie", 2000);
        System.out.println("G. Comparator Result: " + compRef.compare(emp, emp2));

    }

    public static void main(String[] args) {
        Examples e = new Examples();
        e.evaluator();
    }


}
