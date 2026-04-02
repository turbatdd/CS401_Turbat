package lab3.prob4;

public abstract class Property {
    abstract Double computeRent();

    private Address address;

    public Address getAddress() {
        return address;
    }

    Property(Address address) {
        this.address = address;
    }
}
