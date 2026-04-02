package lab2.prob2B;

public class main {

    public static void main(String[] args) {
        Order o = new Order(1001);

        OrderLine oLine1 = new OrderLine(o, "order1", 1);
        OrderLine oLine2 = new OrderLine(o, "order1", 1);
        OrderLine oLine3 = new OrderLine(o, "order1", 1);

        o.addOrderLine(oLine1);
        o.addOrderLine(oLine2);
        o.addOrderLine(oLine3);

        System.out.println("Order numbuer: " + o.getOrderNum());
        System.out.println("Order numbuer: " + o.getOrderLines());
    }
}