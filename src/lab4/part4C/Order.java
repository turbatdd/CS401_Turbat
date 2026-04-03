package lab4.part4C;

import java.time.LocalDate;

public class Order {
    private int orderNo;
    private LocalDate orderDate;
    private double orderAmount;
    private Commissioned employee;

    Order(int orderNum, LocalDate orderDate, double orderAmount, Commissioned employee) {
        orderNo = orderNum;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.employee = employee;
    }

    public void setOrderNo(int s) {
        orderNo = s;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public Commissioned getEmployee() {
        return employee;
    }

}
