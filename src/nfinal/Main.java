package nfinal;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*

STREAM ==============================================================================================================================

What Are Streams?
A Stream in Java is a sequence of elements supporting sequential and parallel aggregate operations.
Streams do NOT store data — they convey elements from a source (collection, array, I/O channel) through a pipeline of operations.


Different way of creating Stream
    - List.stream()
    - Integer[] arrOfInt = {1, 3, 5, 7};    Stream<Integer> strOfInt = Stream.of(arrOfInt);
    - int[] arrOfInt = {1, 3, 5, 7};        Stream<int[]> strOfInt = Stream.of(arrOfInt);
    - Stream<String> song = Stream.of("gently", "down", "the", "stream");
    - Stream<String> echoes = Stream.generate(() -> "Echo");
    - Stream<Double> randoms = Stream.generate(Math::random);
    - Stream<Integer> stream2 = Stream.iterate(1, n -> n + 1));

Optional
    - isPresent - Only use on Optional that means if data is available
    - orElse - if data is null
    - Optinal.empty()
    - Optional<String> bad = Optional.of(username);
    - Optional.ofNullable(data) - Data could be a null value
    - orElseGet - Optional.ofNullable(data).orElseGet(new Data())
    - Collectors.joining(", ")
    - Collectors.toList()
    - Collectors.toSet()
    - TreeSet<String> result = stream.collect(Collectors.toCollection(TreeSet::new));
    - Map<Integer, Person> idToPerson = personStrm.collect(Collectors.toMap(Person::getId,Function.identity()));
    - IntSummaryStatistics stats = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();

Primitive Type Streams
    - IntStream lengths = words.mapToInt(String::length);
    - DoubleStream
    - LongStream


JAVA GENERIC==========================================================================================================================

BENEFITS
- Stronger type checks at compile time.
    List words = new ArrayList(List.of("Hello","world"));
    String s = ((String)words.get(0)) + ((String)words.get(1));
    System.out.print(s); //output: Hello world!

    List<String> words = new ArrayList<String>(List.of("Hello","world"));
    String s = words.get(0) + words.get(1);
    System.out.print(s); //output: Hello world!
- Reduced Downcasting.
    //Populate with Triangles and Rectangles
    ClosedCurve[] closedCurves = . . .
    if(closedCurves[0] instanceOf Triangle) {
        print((Triangle)closedCurve[0].area());
    }
    else {
        print((Rectangle)closedCurve[0].area());
    }
- Supports the most general possible API for methods that can be generalized.

Commonly used type variables
    - E - Element
    - K - Key
    - N - Number
    - T - Type
    - V - Value
    - S, U, V etc. 2nd, 3rd, 4th types

    public class MyList<T> extends ArrayList<T>{
        …
    }



1. Generic Subtyping Is Not Covariant.
    Manager                 is a subclass of            Employee
                                  BUT
    ArrayList<Manager>      is NOT a subclass of        ArrayList<Employee>

2. Array Subtyping Is Covariant
    Manager                 is a subclass of            Employee
                                    AND
    Manager[]               is a subclass of            Employee[]



Cannot create array like this
    T[] arr = null; //this is ok so far
    arr = new T[5]; //this produces a compiler error

    List<String>[] stringLists = new List<String>[5]; // Hypothetical
    Object[] objArray = stringLists; // Allowed by covariance
    objArray[0] = new ArrayList<Integer>(); // Inserts List<Integer>
    String s = stringLists[0].get(0); // Runtime ClassCastException!

GENERIC METHOD

    1. The wildcard ?, without the super or extends qualifier, is called the unbounded wildcard.
    2. Collection<?> is an abbreviation for Collection<? extends Object>
    3. Collection<?> is the supertype of all parametrized type Collections.

    public class OrderedPair<K, V> implements Pair<K, V> {

    public interface Pair<K, V> {
        public K getKey();
        public V getValue();


    public static <K, V> boolean compare(SimplePair<K, V> p1, SimplePair<K, V> p2) {
        return (Boolean)(p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue()));
    }

    public static void main(String[] args) {
    	//with type value
    	SimplePair<Integer, String> p1 = new SimplePair<>(1, "apple");
    	SimplePair<Integer, String> p2 = new SimplePair<>(2, "pear");
    	boolean areTheySame = Util.<Integer, String>compare(p1, p2); //type value shown

    	//without type value

    	SimplePair<Integer, String> q1 = new SimplePair<>(1, "apple");
    	SimplePair<Integer, String> q2 = new SimplePair<>(2, "pear");
    	boolean areTheySame2 = Util.compare(q1, q2);
    }

    boolean areTheySame = Util.<Integer, String>compare(p1, p2); //type value shown



    public static <T extends Comparable<T>> T max(List<T> list) {
		T max = list.get(0);
		for(T i : list) {
			if(i.compareTo(max) > 0) {
				max = i;
			}
		}
		return max;
	}



      public static <T> Group<T> copy(Group<T> group) {
        List<T> elements = group.getElements();
        Group<T> grp = new Group<>(group.getSpecialElement(), elements);
        return grp;
    }

    //Test using this main method
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);
        Group<Integer> group = new Group<>(0, list);
        System.out.println(group);
        System.out.println(GroupUtil.copy(group));
    }


LAMBDA============================================================================================================================

    S,T - arguments R - result

    public interface BiFunction<S,T,R> {
        R apply(S s, T t);
    }

    @FunctionalInterface
    public interface TriFunction<S,T,U,R> {
        R apply(S s, T t, U u);
    }

    Interface	            Input(s)	            Output	        Common Use Case
    Predicate<T>	        1 (T)	                boolean	        Filtering (e.g., isAdult)
    Function<T, R>	        1 (T)	                1 (R)	        Mapping (e.g., Employee -> String)
    Consumer<T>	            1 (T)	                void	        Printing/Side-effects (e.g., System.out::println)
    Supplier<T>	            None	                1 (T)	        Creating/Providing (e.g., () -> new ArrayList<>())
    UnaryOperator<T>	    1 (T)	                1 (T)	        Transforming same type (e.g., String -> toUpperCase)
    BiFunction<T, U, R>	    2 (T, U)	            1 (R)	        Combining two different objects into a result
 */

public class Main {

    public static void main(String[] args) {

        double total = Stream.of(1.0, 1.5, 4.8).reduce(0.0, (a, b) -> a + b);
        System.out.println(total);

        IntSummaryStatistics stats = IntStream.of(7, 2, 19, 88).summaryStatistics();
        System.out.println(stats);
        // Without identity (returns Optional): Optional<String> concat = names.stream().reduce((a, b) -> a + ", " + b);

        List r = new ArrayList(List.of("Hello", "Turuu"));

        List<? super Integer> list = new ArrayList<>();
        list.add(5);

        System.out.println(list);


        String name = "Hafez";
        Optional<String> nameO = Optional.ofNullable(name);
        System.out.println(nameO.orElse(getName()));


        List<Integer> grades =
                new ArrayList<>(Arrays.asList(3, 4, 3));
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(111, "Yasmeen", grades),
                new Student(112, "Mira", grades),
                new Student(113, "Zaina", grades)
        ));
        var result = students.stream()
                .flatMap(s -> s.grades.stream())
                .mapToInt(x -> x)
                .sum();
        System.out.println(result);


        Stream<Integer> stream1 = Stream.iterate(1, n -> n + 1);
        stream1
                .limit(5)
                .forEach(System.out::print);


        System.out.println("\n");
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.print(x));

        int res = IntStream.rangeClosed(1, 3)
                .map(x -> x * x)
                .sum();
        System.out.println("\nRes:" + res);

        List<String> trackList = new ArrayList<>();
    }

    public static String getName() {
        System.out.println(" Remember this example ;) ");
        return "No Name";
    }

    public static class Student {
        private int id;
        private String name;
        private List<Integer> grades;

        Student(int id, String name, List<Integer> grades) {
            this.id = id;
            this.name = name;
            this.grades = grades;

        }
    }

}
