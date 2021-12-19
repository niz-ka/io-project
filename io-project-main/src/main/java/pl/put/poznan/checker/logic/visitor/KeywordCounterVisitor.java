package pl.put.poznan.checker.logic.visitor;

import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;
import pl.put.poznan.checker.logic.dto.DTO;
import pl.put.poznan.checker.logic.dto.KeywordsCountDTO;

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
     * @return number of keywords in passed scenario
     */
    @Override
    public DTO visit(Scenario scenario) {
        logger.info("Counting keywords in scenario");
        return new KeywordsCountDTO(this.countKeywordsInStepsArray(scenario.getSteps()));
    }

    /**
     * Utility method, checks whether step contains keyword. This method does not check children steps.
     * @param s scenario step
     * @return true if step contains step, false otherwise.
     */
    protected Boolean keywordInStep(ScenarioStep s) {
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
    public Integer countKeywordsInStepsArray(ScenarioStep[] steps) {
        Integer keywords = 0;
        if (steps != null) {
            for (ScenarioStep step : steps) {
                if (this.keywordInStep(step)) {
                    keywords += 1;
                }
                keywords += this.countKeywordsInStepsArray(step.getChildrenSteps());
            }
        }
        logger.info("\tNumber of keywords: {}");
        return keywords;
    }
}
