package lab5.prob4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private LocalDate orderDate;
    private List<Item> items;

    Order(LocalDate orderDate) {
        this.orderDate = orderDate;
        items = new ArrayList<Item>();
    }

    public static Order newOrder(Customer cust, LocalDate date) {
        if (cust == null) throw new NullPointerException("Null customer");
        Order ord = new Order(date);
        cust.addOrder(ord);
        return ord;
    }

    public void addItem(Item item) {
        if (item == null) throw new NullPointerException("Cannot add a null item");
        items.add(item);
    }

    @Override
    public String toString() {
        return orderDate + ": " +
                items.toString();
    }
}
