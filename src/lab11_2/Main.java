package lab11_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Address add1 = new Address("500 E Broadway Ave", "Fairfield", "IA", 52556);
        Address add2 = new Address("103 W Adams Ave", "Fairfield", "IA", 52556);

        Section cs545_1 = new Section(900, "CS545");
        Section cs545_2 = new Section(901, "CS545");
        Section cs401 = new Section(902, "CS401");
        Section cs221 = new Section(903, "CS221");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(111, "Yasmeen", new ArrayList<>(Arrays.asList(3.9, 4.0, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs545_1, cs401))),
                new Student(112, "Mira", new ArrayList<>(Arrays.asList(4.0, 4.0, 3.9)), add1,
                        new ArrayList<>(Arrays.asList(cs545_2, cs401, cs221))),
                new Student(113, "Zaina", new ArrayList<>(Arrays.asList(3.6, 3.3, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs221, cs401))),
                new Student(114, "Khaled", new ArrayList<>(Arrays.asList(3.0, 2.8, 3.1)), add2)
        ));

        // Find all the students that are taking a given course
        String takenCourseCode = "CS401";
        List<Student> takenCourseList = students.stream()
                .filter(r -> r.getSections() != null)
                .filter(r -> r.getSections().stream().anyMatch(s -> s.getCourseCode().equals(takenCourseCode)))
                .collect(Collectors.toList());

        System.out.println("\nFind all the students that are taking a given course: CS401");
        System.out.println(takenCourseList);

        // Get the address of any student that is taking a given course (e.g., "CS401")
        String takenCourseCode2 = "CS401";
        List<Address> takenCourseList2 = students.stream()
                .filter(r -> r.getSections() != null)
                .filter(r -> r.getSections().stream().anyMatch(s -> s.getCourseCode().equals(takenCourseCode2)))
                .map(Student::getAddress)
                .collect(Collectors.toList());

        System.out.println("\nGet the address of any student that is taking a given course (e.g., \"CS401\")");
        System.out.println(takenCourseList2);

        // Calculate the GPA for a given student
        double gpaRes = students.stream()
                .filter(r -> r.getName().equals("Khaled"))
                .findFirst()
                .map(r -> r.getGrades().stream().mapToDouble(Double::doubleValue).average()
                        .orElse(0.0))
                .orElse(0.0);

        System.out.println(String.format("\nYour gpa is :%.2f", gpaRes));

        // Find the student with the highest GPA
        Student st1 = students.stream()
                .max(Comparator.comparingDouble(s -> s.getGrades().stream()
                        .mapToDouble(Double::doubleValue).average().orElse(0.0)))
                .orElse(null);
        Double st1Gpa = st1.getGrades().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        System.out.println("\nFind the student with the highest GPA");
        System.out.println(st1);
        System.out.println(String.format("GPA: %.2f", st1Gpa));

        // Get a list of all unique courses taken by students
        List<String> uniqueCourses = students.stream()
                .filter(s -> s.getSections() != null)
                .flatMap(s -> s.getSections().stream())
                .map(Section::getCourseCode)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nGet a list of all unique courses taken by students");
        System.out.println(uniqueCourses);

        // Find all students who live in a given city (e.g., "Fairfield") sorted in alphabetical order
        String cityName = "Fairfield";
        List<Student> stFilterByCity = students.stream()
                .filter(s -> s.getAddress().getCity().equals(cityName))
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println("\nFind all students who live in a given city (e.g., \"Fairfield\") sorted in alphabetical order");
        System.out.println(stFilterByCity);

        // Count the number of students enrolled in a specific course (e.g., "CS401")
        String enrolledCourseId = "CS401";
        long countEnroll = students.stream()
                .filter(s -> s.getSections() != null && s.getSections().stream()
                        .anyMatch(r -> r.getCourseCode().equals(enrolledCourseId))).count();

        System.out.println("\nCount the number of students enrolled in a specific course (e.g., \"CS401\")");
        System.out.println("Enrolled " + enrolledCourseId + ": " + countEnroll);

        // Get a list of students in a specific section
        String specSecCourseId = "CS545";
        List<Student> stSpecList = students.stream()
                .filter(r -> r.getSections() != null && r.getSections().stream()
                        .anyMatch(se -> se.getCourseCode().equals(specSecCourseId)))
                .collect(Collectors.toList());

        System.out.println("\nGet a list of students in a specific section:" + specSecCourseId);
        System.out.println(stSpecList);

        //  Get the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)
        List<String> studentMoreList = students.stream()
                .filter(r -> r.getSections() != null && r.getSections().stream().count() > 2)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("\nGet the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)");
        System.out.println(studentMoreList);

        // Get a list of unique course names taken by students who live in a given city (e.g., "Fairfield")
        String cityName2 = "Fairfield";
        List<String> courseListByCity = students.stream()
                .filter(r -> r.getAddress().getCity().equals(cityName2) && r.getSections() != null)
                .flatMap(s -> s.getSections().stream())
                .map(Section::getCourseCode)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nGet a list of unique course names taken by students who live in a given city (e.g., \"Fairfield\")");
        System.out.println(courseListByCity);

        // Get a list of distinct addresses of students who are taking a specific course (e.g., "CS401")
        String selCourseID = "CS401";
        List<Address> listAddress = students.stream()
                .filter(r -> r.getSections() != null)
                .filter(r -> r.getSections().stream().anyMatch(s -> s.getCourseCode().equals(selCourseID)))
                .map(Student::getAddress)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nGet a list of distinct addresses of students who are taking a specific course (e.g., \"CS401\")");
        System.out.println(listAddress);

        // Get a mapping of students' names to the list of courses they are taking
        Map<String, List<String>> result = students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        s -> s.getSections() == null ? new ArrayList<>() :
                                s.getSections().stream().map(Section::getCourseCode).collect(Collectors.toList())
                ));

        System.out.println("\nGet a mapping of students' names to the list of courses they are taking");
        System.out.println(result);
    }
}
