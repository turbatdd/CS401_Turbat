package lab10.prob2A;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int res = Integer.compare(e1.salary, e2.salary);
        if (res != 0) return res;

        return e1.name.compareTo(e2.name);
    }
}
