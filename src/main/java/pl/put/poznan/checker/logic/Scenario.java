package pl.put.poznan.checker.logic;

/**
 * Class for storing scenario
 */
public class Scenario {
    /**
     * Scenario title
     */
    private String title;

    /**
     * Scenario actors
     */
    private String[] actors;

    /**
     * Scenario system actors
     */
    private String[] systemActors;

    /**
     * Scenario steps
     */
    private ScenarioStep[] steps;

    /**
     * Initialize a new <code>Scenario</code> object
     * @param title scenario title
     * @param actors scenario actors
     * @param systemActors scenario system actors
     * @param steps scenario steps
     */
    public Scenario(String title, String[] actors, String[] systemActors, ScenarioStep[] steps) {
        this.title = title;
        this.actors = actors;
        this.systemActors = systemActors;
        this.steps = steps;
    }

    public DTO accept(Visitor visitor) {
        return visitor.visit(this);
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String[] getSystemActors() {
        return systemActors;
    }

    public void setSystemActors(String[] systemActors) {
        this.systemActors = systemActors;
    }

    public ScenarioStep[] getSteps() {
        return steps;
    }

    public void setSteps(ScenarioStep[] steps) {
        this.steps = steps;
    }

}
