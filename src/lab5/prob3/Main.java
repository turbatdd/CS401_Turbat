package lab5.prob3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(3.0));
        shapes.add(new Rectangle(2.0, 4.0));
        shapes.add(new Triangle(3.0, 0.74));

        double totalArea = 0;
        for (Shape s : shapes) {
            totalArea += s.computeArea();
        }

        System.out.printf("Sum of Areas = %.2f%n", totalArea);
    }
}
