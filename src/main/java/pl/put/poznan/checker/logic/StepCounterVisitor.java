package pl.put.poznan.checker.logic;

/**
 * Class for counting steps in scenario.
 */
public class StepCounterVisitor implements Visitor{
    /**
     * Main method to count steps in passed scenario.
     * @param scenario scenario to count steps
     * @return number of steps in scenario.
     */
    public DTO visit(Scenario scenario) {
        Integer numberOfSteps = 0;
        if (scenario.getSteps() != null) {
            numberOfSteps = this.countStepsWithSubsteps(scenario.getSteps());
        }
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
