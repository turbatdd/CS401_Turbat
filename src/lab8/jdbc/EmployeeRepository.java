package lab8.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String USER = "postgres"; // Replace with your MySQL username
    private static final String PASSWORD = "Pass1234!"; // Replace with your MySQL password

    private static Connection conn;

    static {
        try {
            Class.forName("org.postgresql.Driver"); // optional, ensures driver loaded
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<Employee> empList = findAll();
        Employee e = findById(111);

        System.out.println("Emp list: " + empList);

        System.out.println("Emp: " + e);

        Employee testE = new Employee(20, "Turuu", 100000.0F, 1, 1);
        create(testE);

        testE.setName("Turbat Dav");

        update(testE);
        delete(testE.getEmp_id());
    }


    private static List<Employee> findAll() {
        List<Employee> empList = new ArrayList<>();
        String query = "SELECT * FROM Employee";

        try (Statement statement = conn.createStatement();) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int emp_id = rs.getInt("emp_id");
                String name = rs.getString("name");
                float salary = rs.getFloat("salary");
                int address_id = rs.getInt("address_id");
                int dept_id = rs.getInt("dept_id");

                empList.add(new Employee(emp_id, name, salary, address_id, dept_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empList;
    }

    private static Employee findById(int empId) {

        if (empId <= 0) {
            System.out.println("EmpID is null");
            return null;
        }

        Employee emp = null;
        String query = "SELECT * FROM Employee where emp_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, empId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int emp_id = rs.getInt("emp_id");
                String name = rs.getString("name");
                float salary = rs.getFloat("salary");
                int address_id = rs.getInt("address_id");
                int dept_id = rs.getInt("dept_id");
                emp = new Employee(emp_id, name, salary, address_id, dept_id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emp;
    }

    private static void create(Employee employee) {
//        Inserts a new employee.

        if (employee == null) {
            System.out.println("Employee is null");
            return;
        }

        String query = "INSERT INTO employee (emp_id, name, salary, dept_id)\n" +
                "VALUES (?, ?, ?, ?);";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, employee.getEmp_id());
            pstmt.setString(2, employee.getName());
            pstmt.setFloat(3, employee.getSalary());
            pstmt.setInt(4, employee.getDept_id());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Inserted successfully");
            } else {
                System.out.println("Insert not successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void update(Employee employee) {
//        Updates an employee

        if (employee == null) {
            System.out.println("Employee is null");
            return;
        }

        String query = "UPDATE employee set emp_id = ?, name = ?, salary = ?, dept_id = ? \n" +
                "WHERE emp_id = ?;";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, employee.getEmp_id());
            pstmt.setString(2, employee.getName());
            pstmt.setFloat(3, employee.getSalary());
            pstmt.setInt(4, employee.getDept_id());
            pstmt.setInt(5, employee.getEmp_id());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Updated successfully");
            } else {
                System.out.println("Employee not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void delete(int empId) {
//        Deletes an employee

        if (empId <= 0) {
            System.out.println("Employee id must be greater than 0");
            return;
        }

        String query = "DELETE FROM employee WHERE emp_id = ?;";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, empId);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Deleted successfully");
            } else {
                System.out.println("Employee not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
