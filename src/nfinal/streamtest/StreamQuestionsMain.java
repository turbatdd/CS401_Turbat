package nfinal.streamtest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 10 Stream Practice Questions (Style: comment-based, like Stream Questions/Main.java)
 * Write the stream implementation for each commented question below.
 */
public class StreamQuestionsMain {

    public static void main(String[] args) {

        Address add1 = new Address("500 E Broadway Ave", "Fairfield", "IA", 52556);
        Address add2 = new Address("103 W Adams Ave", "Fairfield", "IA", 52556);
        Address add3 = new Address("200 N Main St", "Chicago", "IL", 60601);
        Address add4 = new Address("75 Tech Blvd", "San Jose", "CA", 95101);

        Project p1 = new Project(1, "Alpha", 50000);
        Project p2 = new Project(2, "Beta", 120000);
        Project p3 = new Project(3, "Gamma", 80000);
        Project p4 = new Project(4, "Delta", 200000);

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(101, "Yasmeen", 75000, "Engineering", add1,
                        new ArrayList<>(Arrays.asList("Java", "SQL"))),
                new Employee(102, "Mira", 82000, "Engineering", add2,
                        new ArrayList<>(Arrays.asList("Java", "C++", "AWS"))),
                new Employee(103, "Khaled", 60000, "Marketing", add3,
                        new ArrayList<>(Arrays.asList("SEO", "Analytics", "Python"))),
                new Employee(104, "Zaina", 95000, "Engineering", add4,
                        new ArrayList<>(Arrays.asList("Java", "Kubernetes", "Docker"))),
                new Employee(105, "Omar", 55000, "Marketing", add3,
                        new ArrayList<>(Arrays.asList("SEO", "Content", "Analytics"))),
                new Employee(106, "Sara", 70000, "HR", add1,
                        new ArrayList<>(Arrays.asList("Recruitment", "Excel"))),
                new Employee(107, "Ahmad", 88000, "Engineering", add4,
                        new ArrayList<>(Arrays.asList("Java", "React", "AWS")))
        ));

        // Q1: Find all employees in the "Engineering" department, sorted by name alphabetically
        List<Employee> e1 = employees.stream()
                .filter(r -> r.getDepartment().equals("Engineering"))
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());

        System.out.println(e1);

        // Q2: Get the average salary of all employees in a given department (e.g., "Engineering")
        Double e2 = employees.stream()
                .filter(r -> r.getDepartment().equals("Engineering"))
                .mapToDouble(Employee::getSalary).average().orElse(0.0);

        System.out.println(e2);

        // Q3: Get a list of all unique skills across all employees

        List<String> e3 = employees.stream()
                .filter(r -> r.getSkills() != null)
                .flatMap(e -> e.getSkills().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(e3);

        // Q4: Find the employee with the highest salary

        Double e4 = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max().orElse(0.0);

        System.out.println(e4);

        // Q5: Get the names of employees who have a specific skill (e.g., "Java")

        List<String> e5 = employees.stream()
                .filter(r -> r.getSkills() != null)
                .filter(r -> r.getSkills().stream().anyMatch(s -> s.equals("Java")))
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(e5);

        // Q6: Count the number of employees who live in a given city (e.g., "Fairfield")
        long e6 = employees.stream()
                .filter(r -> r.getAddress().city.equals("Fairfield"))
                .count();

        System.out.println(e6);

        // Q7: Get a mapping of department name to list of employee names (Map<String, List<String>>)

//        Map<String, List<String>> e7 = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,                     // Key: Department Name
//                        Collectors.mapping(Employee::getName,        // Value: Transform Employee to Name
//                                Collectors.toList())                     // Value: Collect names into a List
//                ));

        Map<String, List<String>> e7 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(e7);

        // Q8: Calculate the total salary of all employees who have more than 2 skills

        Double e8 = employees.stream()
                .filter(r -> r.getSkills() != null)
                .filter(r -> r.getSkills().stream().count() > 2)
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println(e8);
        // Q9: Get a list of distinct cities where employees live

        List<String> e9 = employees.stream()
                .map(r -> r.getAddress().city)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(e9);

        // Q10: Find all employees whose salary is above the overall average salary, sorted by salary descending

        Double avgSal = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);


        List<Employee> e10 = employees.stream()
                .filter(r -> r.getSalary() > avgSal)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println(e10);
    }
}
