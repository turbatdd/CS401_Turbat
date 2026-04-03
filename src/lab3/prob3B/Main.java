package lab3.prob3B;

public class Main {

    public static void main(String[] args) {

        Circle c = new Circle(2);

        System.out.println("Circle: " + c.computeArea());

        Cylinder cy = new Cylinder(2, 5);

        System.out.println("Cylinder: " + cy.computeVolume());
    }
}
