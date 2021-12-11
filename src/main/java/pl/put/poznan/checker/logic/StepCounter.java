package pl.put.poznan.checker.logic;

/**
 * Class for counting steps in scenario.
 */
public class StepCounter {
    /**
     * Main method to count steps in passed scenario.
     * @param scenario Scenario to count steps
     * @return Number of steps in scenario.
     */
    public StepCountDTO countSteps(Scenario scenario) {
        Integer numberOfSteps = 0;
        if (scenario.getSteps() != null) {
            numberOfSteps = this.countStepsWithSubsteps(scenario.getSteps());
        }
        return new StepCountDTO(numberOfSteps);
    }

    /**
     * Recursive method for checking number of steps .
     * @see ScenarioStep
     * @param steps Array of steps.
     * @return Number of steps (including substeps) within steps array.
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
