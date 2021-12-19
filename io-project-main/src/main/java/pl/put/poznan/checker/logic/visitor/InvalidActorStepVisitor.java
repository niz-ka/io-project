package pl.put.poznan.checker.logic.visitor;

import pl.put.poznan.checker.logic.dto.DTO;
import pl.put.poznan.checker.logic.dto.InvalidStepsDTO;
import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for checking if scenario includes invalid steps
 */
public class InvalidActorStepVisitor implements Visitor {

    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(InvalidActorStepVisitor.class);

    /**
     * Array of actors from scenario, for caching purposes
     */
    protected String[] actors;

    /**
     * Main method get array of invalid steps from scenario.
     * @param scenario scenario to check
     * @return Array of invalid steps
     */
    @Override
    public DTO visit(Scenario scenario) {
        logger.info("Checking scenario steps");
        this.actors = scenario.getActors();
        ArrayList<ScenarioStep> steps = this.detectInvalidSteps(scenario.getSteps());
    
        return new InvalidStepsDTO(steps);
    }

    /**
     * Utility method to remove keywords from step name
     * @param stepContent Name of step
     * @return Name of step without keywords
     * @see ScenarioStep
     */
    protected String removeKeywords(String stepContent) {
        for (String keyword : KeywordCounterVisitor.keywords) {
            stepContent = stepContent.replaceAll(keyword + ":", "");
        }
        return stepContent.trim();
    }

    /**
     * Utility method, checks whether step includes actor at the beginning
     * @param stepContent Name of step
     * @return true if step includes actor at the beginning, false otherwise
     */
    protected Boolean isStepValid(String stepContent) {
        for (String actor : this.actors) {
           if (stepContent.startsWith(actor)) {
                logger.debug("\tStep: {}, is valid", stepContent);
               return true;
           }
        }
        logger.debug("\tStep: {}, is not valid", stepContent);
        return false;
    }

    /**
     * Recursive method for detecting invalid steps.
     * @param steps Array of steps.
     * @return Array of invalid steps.
     */
    protected ArrayList<ScenarioStep> detectInvalidSteps(ScenarioStep[] steps) {
        String[] keywords = KeywordCounterVisitor.keywords;
        ArrayList<ScenarioStep> invalidSteps = new ArrayList<>();
        for (ScenarioStep step : steps) {
            if (!this.isStepValid(this.removeKeywords(step.getName()))) {
                invalidSteps.add(step);
            }
            if (step.getChildrenSteps() != null && step.getChildrenSteps().length > 0) {
                invalidSteps.addAll(this.detectInvalidSteps(step.getChildrenSteps()));
            }
        }
        logger.info("\tList of invalid steps found");
        return invalidSteps;
    }
}
