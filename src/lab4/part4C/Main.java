package lab4.part4C;

public class Main {

    public static void main(String[] args) {
        Employee e = new Commissioned("ee1", 200, 300);
        Paycheck p = e.calcCompensation(10, 2025);

        e.print();
        double netPay = p.getNetPay();
        p.print();

    }

}
