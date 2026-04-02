package lab2.prob1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectId;
    private List<Feature> featureSet = new ArrayList<>();
    private List<Release> releaseList = new ArrayList<>();

    public Project(String projectId) {
        this.projectId = projectId;
    }

    public void addFeature(Feature feature) {
        featureSet.add(feature);
    }

    public void addRelease(LocalDate relDate, String featureId) {
        Feature f = getFeature(featureId);
        releaseList.add(new Release(relDate, f));
    }

    public Feature getFeature(String featureId) {
        for (Feature f : featureSet) {
            if (f.getFeatureId().equals(featureId))
                return f;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", featureSet=" + featureSet +
                ", releaseList=" + releaseList +
                '}';
    }
}
