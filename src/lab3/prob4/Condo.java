package lab3.prob4;

public class Condo extends Property {
    private int numberOfFloors;

    public Condo(Address address, int numberOfFloors) {
        super(address);
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    Double computeRent() {
        return 400.0 * numberOfFloors;
    }
}
