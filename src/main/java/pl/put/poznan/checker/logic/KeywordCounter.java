package pl.put.poznan.checker.logic;

/**
 * Class for counting keywords in scenario steps.
 */
public class KeywordCounter {
    /**
     * Scenario keywords, always uppercase and at the beginning of step.
     */
    protected String[] keywords = {
            "IF",
            "FOR EACH",
            "ELSE",
            "ELSEIF",
            "ELIF",
    };

    /**
     * Main method to count keywords in steps of passed scenario.
     * @param scenario Scenario to count keywords
     * @return
     */
    public KeywordsCountDTO countKeywords(Scenario scenario) {
        return new KeywordsCountDTO(this.countKeywordsInStepsArray(scenario.getSteps()));
    }

    /**
     * Utility method, checks whether step contains keyword. This method does not check children steps.
     * @param s Scenario step
     * @return True if step contains step, false otherwise.
     */
    protected Boolean keywordInStep(ScenarioStep s) {
        for (String keyword : keywords) {
            if (s.getName().startsWith(keyword)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Recursive method checking for keyword in array of steps, and their respective children steps.
     * @see ScenarioStep
     * @param steps Array of ScenarioStep
     * @return Number of keywords in array of steps.
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
        return keywords;
    }
}
