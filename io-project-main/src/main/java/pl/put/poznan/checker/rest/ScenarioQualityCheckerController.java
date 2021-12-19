package pl.put.poznan.checker.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.checker.logic.dto.DTO;
import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitor.InvalidActorStepVisitor;
import pl.put.poznan.checker.logic.visitor.KeywordCounterVisitor;
import pl.put.poznan.checker.logic.visitor.StepCounterVisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rest Controller of application
 */
@RestController
@RequestMapping("api/scenario")
public class ScenarioQualityCheckerController {

    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(InvalidActorStepVisitor.class);

    /**
     * Read scenario and return it as response
     * @param scenario scenario passed in request body
     * @return scenario passed in request body
     */
    @PostMapping
    public Scenario returnScenario(@RequestBody Scenario scenario) {
        logger.info("#Requesting scenario");
        return scenario;
    }

    /**
     * Count keywords in scenario
     * @param scenario scenario passed in request body
     * @return number of keywords
     */
    @PostMapping("/keywords")
    public DTO countKeywords(@RequestBody Scenario scenario) {
        logger.info("#Requesting counting keywords in scenario");
        KeywordCounterVisitor counter = new KeywordCounterVisitor();
        return scenario.accept(counter);
    }

    /**
     * Count number of steps in scenario
     * @param scenario scenario passed in request body
     * @return total number of steps
     */
    @PostMapping("/steps")
    public DTO countSteps(@RequestBody Scenario scenario) {
        logger.info("#Requesting counting steps in scenario");
        StepCounterVisitor counter = new StepCounterVisitor();
        return scenario.accept(counter);
    }


    /**
     * Get invalid steps without actor at the beginning
     * @param scenario scenario passed in request body
     * @return array of steps
     */
    @PostMapping("/actors")
    public DTO invalidSteps(@RequestBody Scenario scenario) {
        logger.info("#Requesting checking steps in scenario");
        InvalidActorStepVisitor checker = new InvalidActorStepVisitor();
        return scenario.accept(checker);
    }
}


