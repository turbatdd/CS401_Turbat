package nfinal.streamtest;

public class Project {
    private int id;
    private String projectName;
    private double budget;

    public Project(int id, String projectName, double budget) {
        this.id = id;
        this.projectName = projectName;
        this.budget = budget;
    }

    public int getId() { return id; }
    public String getProjectName() { return projectName; }
    public double getBudget() { return budget; }

    @Override
    public String toString() {
        return "Project{" + projectName + ", budget=" + budget + "}";
    }
}
