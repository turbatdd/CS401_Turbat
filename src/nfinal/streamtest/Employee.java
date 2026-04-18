package nfinal.streamtest;

import java.util.List;

public class Employee {
    public int id;
    public String name;
    public double salary;
    public String department;
    public Address address;
    public List<String> skills;

    public Employee(int id, String name, double salary, String department, Address address, List<String> skills) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.address = address;
        this.skills = skills;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public Address getAddress() { return address; }
    public List<String> getSkills() { return skills; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
