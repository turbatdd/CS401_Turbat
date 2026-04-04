package lab4.partC;

public class Main {

    public static void main(String[] args) {
        startCompositionCalculate(10, 2025);
    }

    public static void startCompositionCalculate(int month, int year) {
        Employee e = new Commissioned("ee1", 200, 300);
        Paycheck p = e.calcCompensation(month, year);

        e.print();
        p.print();
    }
}
