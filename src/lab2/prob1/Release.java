package lab2.prob1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Release {
    private LocalDate releaseDate;
    private List<Feature> featureList = new ArrayList<>();

    public Release(LocalDate releaseDate, Feature feature) {
        this.releaseDate = releaseDate;
        addFeature(feature);
    }

    private void addFeature(Feature feature) {
        featureList.add(feature);
    }

    @Override
    public String toString() {
        return "Release{" +
                "releaseDate=" + releaseDate +
                ", featureList=" + featureList +
                '}';
    }
}
