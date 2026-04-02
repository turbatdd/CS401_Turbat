package lab3.prob4;

public class Trailer extends Property {

    public Trailer(Address address) {
        super(address);
    }

    @Override
    Double computeRent() {
        return 500.0;
    }
}
