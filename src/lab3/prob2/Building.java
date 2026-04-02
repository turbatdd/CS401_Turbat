package lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Apartment> apartments = new ArrayList<>();

    private double mainCost;

    Building(double mainCost, double rent) {
        this.mainCost = mainCost;
        addApartment(new Apartment(rent));
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public double calcProfit() {
        double grossProfit = 0.0;
        for (Apartment a : apartments) {
            grossProfit += a.getRent();
        }
        return grossProfit - mainCost;
    }

}
