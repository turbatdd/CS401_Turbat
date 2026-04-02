package lab2.prob1;

import java.util.Objects;

public class Feature {
    private String featureId;

    public Feature(String featureId) {
        this.featureId = featureId;
    }

    public String getFeatureId() {
        return featureId;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "featureId='" + featureId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Feature feature)) return false;
        return Objects.equals(featureId, feature.featureId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(featureId);
    }
}
