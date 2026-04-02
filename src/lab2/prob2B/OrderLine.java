package lab2.prob2B;

public class OrderLine {
    private Order order;
    private String name;
    private int quantity;

    OrderLine(Order order, String name, int quantity) {
        this.order = order;
        this.name = name;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }
}