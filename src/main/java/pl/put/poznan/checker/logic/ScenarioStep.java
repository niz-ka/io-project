package pl.put.poznan.checker.logic;

public class ScenarioStep {
    private String name;
    private ScenarioStep[] childrenSteps;

    public ScenarioStep(String name, ScenarioStep[] childrenSteps) {
        this.name = name;
        this.childrenSteps = childrenSteps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ScenarioStep[] getChildrenSteps() {
        return childrenSteps;
    }

    public void setChildrenSteps(ScenarioStep[] childrenSteps) {
        this.childrenSteps = childrenSteps;
    }
}
