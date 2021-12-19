package pl.put.poznan.checker.logic.visitable;

import pl.put.poznan.checker.logic.dto.DTO;
import pl.put.poznan.checker.logic.visitor.Visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for storing scenario
 */
public class Scenario implements Visitable {

    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(Scenario.class);

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
        logger.info("New scenario initialized");
    }

    @Override
    public DTO accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        logger.info("New scenario title set");
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
        logger.info("New scenario actors set");
    }

    public String[] getSystemActors() {
        return systemActors;
    }

    public void setSystemActors(String[] systemActors) {
        this.systemActors = systemActors;
        logger.info("New scenario system actors set");
    }

    public ScenarioStep[] getSteps() {
        return steps;
    }

    public void setSteps(ScenarioStep[] steps) {
        this.steps = steps;
        logger.info("New scenario steps set");
    }

}
