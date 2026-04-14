package lab10.prob2A;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int res = e1.name.compareTo(e2.name);

        if (res != 0) return res;

        return Double.compare(e1.salary, e2.salary);
    }
}
