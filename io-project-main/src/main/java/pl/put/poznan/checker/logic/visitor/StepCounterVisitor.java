package pl.put.poznan.checker.logic.visitor;

import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;
import pl.put.poznan.checker.logic.dto.DTO;
import pl.put.poznan.checker.logic.dto.StepCountDTO;

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
     * Main method to count steps in passed scenario.
     * @param scenario scenario to count steps
     * @return number of steps in scenario.
     */
    @Override
    public DTO visit(Scenario scenario) {
        logger.info("Counting steps in scenario");
        Integer numberOfSteps = 0;
        if (scenario.getSteps() != null) {
            numberOfSteps = this.countStepsWithSubsteps(scenario.getSteps());
        }
        logger.info("\tNumber of steps: {}", numberOfSteps);
        return new StepCountDTO(numberOfSteps);
    }


    /**
     * Recursive method for checking number of steps .
     * @see ScenarioStep
     * @param steps array of steps.
     * @return number of steps (including substeps) within steps array.
     */
    public Integer countStepsWithSubsteps(ScenarioStep[] steps) {
        Integer numberOfSteps = 0;
        if (steps != null) {
            numberOfSteps += steps.length;
            for (ScenarioStep step : steps) {
                numberOfSteps += this.countStepsWithSubsteps(step.getChildrenSteps());
            }
        }
        return numberOfSteps;
    }
}
