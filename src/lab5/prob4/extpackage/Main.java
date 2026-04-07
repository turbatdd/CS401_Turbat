package lab5.prob4.extpackage;

import java.time.LocalDate;

import lab5.prob4.CustOrderFactory;
import lab5.prob4.Customer;
import lab5.prob4.Item;
import lab5.prob4.Order;

public class Main {
    public static void main(String[] args) {
        Customer cust = CustOrderFactory.createCustomer("Bob");
        Order order = CustOrderFactory.newOrder(cust, LocalDate.now());

        order.addItem(CustOrderFactory.newItem("Shirt"));
        order.addItem(CustOrderFactory.newItem("Laptop"));

        order = CustOrderFactory.newOrder(cust, LocalDate.now());
        order.addItem(CustOrderFactory.newItem("Pants"));
        order.addItem(CustOrderFactory.newItem("Knife set"));

        System.out.println(cust.getOrders());
    }
}

		
