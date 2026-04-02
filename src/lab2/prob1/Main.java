package lab2.prob1;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();

        Project p1 = new Project("100");
        Project p2 = new Project("100");

        pm.addProject(p1);
        pm.addProject(p2);


        for (int i = 0; i < 6; i++) {
            pm.addDeveloper(new Developer("dev-1" + i));

            if (i % 2 == 0)
                pm.addFeatureToProject(p1);
            else
                pm.addFeatureToProject(p2);
        }

        String[] featureIds = pm.getAllFeatureIds().toArray(new String[0]);

        for (int i = 0; i < featureIds.length; i++) {
            if (i % 2 == 0)
                pm.addRelease(p1, LocalDate.of(2026, 3, 1 + i), featureIds[i]);
            else
                pm.addRelease(p2, LocalDate.of(2026, 4, 1 + i), featureIds[i]);
        }


        for (int i = 0; i < featureIds.length; i++) {
            Developer rawDev = pm.getDevelopers().get(i);

            if (i % 2 == 0)
                pm.assignFeature(p1.getFeature(featureIds[i]), rawDev);
            else
                pm.assignFeature(p2.getFeature(featureIds[i]), rawDev);
        }


        System.out.println(pm.getProjects());
        System.out.println(pm.getDevelopers());
    }
}