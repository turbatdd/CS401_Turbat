package nfinal.streamtest;

public class Address {
    String street;
    String city;
    String state;
    int zipcode;

    public Address(String street, String city, String state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getZipcode() { return zipcode; }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipcode;
    }
}
