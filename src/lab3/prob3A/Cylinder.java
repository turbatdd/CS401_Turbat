package lab3.prob3A;

public class Cylinder {

    private double height;
    private double radius;

    public Cylinder(double radius, double height) {
        this.height = height;
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public double computeVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
