package pl.put.poznan.checker.logic.visitable;

/**
 * Class for storing scenario step and it's children steps
 */
public class ScenarioStep {
    /**
     * Step name
     */
    private String name;

    /**
     * Children steps of this step
     */
    private ScenarioStep[] childrenSteps;

    /**
     * Initialize a new <code>ScenarioStep</code>
     * @param name step name
     * @param childrenSteps children steps
     */
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
