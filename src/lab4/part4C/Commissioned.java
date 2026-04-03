package lab4.part4C;

import java.time.LocalDate;
import java.util.*;

public class Commissioned extends Employee {
    private double commission;
    private double baseSalary;
    private List<Order> orders = new ArrayList<>();

    public Commissioned(String empId, double commission, double baseSalary) {
        super(empId);
        this.commission = commission;
        this.baseSalary = baseSalary;
    }

    public void addNewOrder(int orderNum, LocalDate orderDate, int orderAmount) {
        orders.add(new Order(orderNum, orderDate, orderAmount, this));
    }

    @Override
    public double calcGrossPay(int month, int year) {
        LocalDate firstDayOfCurrentMonth = LocalDate.of(year, month, 1);
        double orderAmountsPrevMonth = 0.0;
        for (Order o : orders) {
            if (isPreviousMonth(firstDayOfCurrentMonth, o.getOrderDate())) {
                orderAmountsPrevMonth += o.getOrderAmount();
            }
        }
        return baseSalary + commission * orderAmountsPrevMonth;
    }

    private boolean isPreviousMonth(LocalDate current, LocalDate orderDate) {
        int currMonth = current.getMonthValue();
        int prevMonth = orderDate.getMonthValue();
        int currYear = current.getYear();
        int prevYear = orderDate.getYear();
        if ((currMonth - prevMonth == 1 && currYear == prevYear) ||
                (currMonth == 1 && prevMonth == 12 && currYear - prevYear == 1)) {
            return true;
        }
        return false;
    }
}
