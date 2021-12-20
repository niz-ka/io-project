package pl.put.poznan.checker.logic.visitor;

import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for counting steps in scenario.
 */
public class StepCounterVisitor implements Visitor {
    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(StepCounterVisitor.class);

    /**
     * Number of steps in scenario
     */
    private int numberOfSteps;

    /**
     * Main method to count steps in passed scenario.
     * @param scenario scenario to count steps
     */
    @Override
    public void visit(Scenario scenario) {
        logger.info("Counting steps in scenario");
        if (scenario.getSteps() != null) {
            this.numberOfSteps = this.countStepsWithSubsteps(scenario.getSteps());
        }
        logger.debug("\tNumber of steps: {}", this.numberOfSteps);
    }


    /**
     * Recursive method for checking number of steps .
     * @see ScenarioStep
     * @param steps array of steps.
     * @return number of steps (including substeps) within steps array.
     */
    public int countStepsWithSubsteps(ScenarioStep[] steps) {
        int counter = 0;
        if (steps != null) {
            counter += steps.length;
            for (ScenarioStep step : steps) {
                counter += this.countStepsWithSubsteps(step.getChildrenSteps());
            }
        }
        return counter;
    }

    public int getNumberOfSteps() {
        return this.numberOfSteps;
    }
}
