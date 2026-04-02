package lab2.prob1;

import java.util.ArrayList;
import java.util.List;

public class Developer {
    private String developerId;
    private List<Feature> assignedFeatures = new ArrayList<>();

    public Developer(String developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public List<Feature> getAssignedFeatures() {
        return assignedFeatures;
    }

    public void addFeature(Feature feature) {
        assignedFeatures.add(feature);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "developerId='" + developerId + '\'' +
                ", assignedFeatures=" + assignedFeatures +
                '}';
    }
}
