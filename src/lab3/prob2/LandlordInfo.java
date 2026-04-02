package lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
    private List<Building> buildingList = new ArrayList<>();


    public void addBuilding(Building building) {
        buildingList.add(building);
    }

    public double calcProfits() {
        double profit = 0.0;
        for (Building build : buildingList) {
            profit += build.calcProfit();
        }
        return profit;
    }

}
