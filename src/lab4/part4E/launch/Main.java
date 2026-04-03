package lab4.part4E.launch;

import lab4.part4E.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Turuu");
        Employee e2 = new Employee("Rahu");

        e1.addAccount(new CheckingAccount("5007832367", 10.0, 1000));
        e2.addAccount(new SavingsAccount("5007832368", 0.03, 500));

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        System.out.println(Admin.computeUpdatedBalanceSum(employees));

    }
}
