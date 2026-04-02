package lab2.prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNum;
    private List<OrderLine> orderLines;

    public Order(int orderNum) {
        this.orderNum = orderNum;
        this.orderLines = new ArrayList<>();
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void addOrderLine(OrderLine item) {
        orderLines.add(item);
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public boolean hasAtLeastOneRelease() {
        return orderLines.size() >= 1;
    }
}