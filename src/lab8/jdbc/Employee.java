package lab8.jdbc;

public class Employee {
    private int emp_id;
    private String name;


    private float salary;
    private int address_id;
    private int dept_id;

    public Employee(int emp_id, String name, float salary, int address_id, int dept_id) {
        this.emp_id = emp_id;
        this.name = name;
        this.salary = salary;
        this.address_id = address_id;
        this.dept_id = dept_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {

        if (emp_id <= 0)
            return "Employee null";

        return "Employee{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", address_id=" + address_id +
                ", dept_id=" + dept_id +
                '}';
    }


}
