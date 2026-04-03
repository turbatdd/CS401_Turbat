package lab3.prob3A;

public class Circle extends Cylinder {
    private double radius;

    public Circle(double radius) {
        super(radius, 0);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double computeArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
