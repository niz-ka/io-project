package pl.put.poznan.checker.logic.visitor;

import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for counting keywords in scenario steps.
 */
public class KeywordCounterVisitor implements Visitor {
    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(InvalidActorStepVisitor.class);

    /**
     * Number of keywords in scenario
     */
    private int numberOfKeywords;

    /**
     * Scenario keywords, always uppercase and at the beginning of step.
     */
    public static String[] keywords = {
            "IF",
            "FOR EACH",
            "ELSE",
            "ELSEIF",
            "ELIF",
    };

    /**
     * Main method to count keywords in steps of passed scenario.
     * @param scenario scenario to count keywords
     */
    @Override
    public void visit(Scenario scenario) {
        logger.info("Counting keywords in scenario");
        this.numberOfKeywords = this.countKeywordsInStepsArray(scenario.getSteps());
    }

    /**
     * Utility method, checks whether step contains keyword. This method does not check children steps.
     * @param s scenario step
     * @return true if step contains step, false otherwise.
     */
    protected boolean keywordInStep(ScenarioStep s) {
        for (String keyword : keywords) {
            if (s.getName().startsWith(keyword)) {
                logger.debug("\t\tStep {} starts with {}", s.getName(), keyword);
                return true;
            }
        }
        return false;
    }

    /**
     * Recursive method checking for keyword in array of steps, and their respective children steps.
     * @see ScenarioStep
     * @param steps array of ScenarioStep
     * @return number of keywords in array of steps.
     */
    public int countKeywordsInStepsArray(ScenarioStep[] steps) {
        int counter = 0;
        if (steps != null) {
            for (ScenarioStep step : steps) {
                if (this.keywordInStep(step)) {
                    counter += 1;
                }
               counter += this.countKeywordsInStepsArray(step.getChildrenSteps());
            }
        }
        logger.debug("\tNumber of keywords: {}", counter);
        return counter;
    }

    public int getNumberOfKeywords() {
        return this.numberOfKeywords;
    }
}
