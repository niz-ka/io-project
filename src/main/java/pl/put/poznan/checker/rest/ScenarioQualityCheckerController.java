package pl.put.poznan.checker.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.checker.logic.*;

/**
 * Rest Controller of application
 */
@RestController
@RequestMapping("api/scenario")
public class ScenarioQualityCheckerController {

    /**
     * Read scenario and return it as response
     * @param scenario scenario passed in request body
     * @return scenario passed in request body
     */
    @PostMapping
    public Scenario returnScenario(@RequestBody Scenario scenario) {
        return scenario;
    }

    /**
     * Count keywords in scenario
     * @param scenario scenario passed in request body
     * @return number of keywords
     */
    @PostMapping("/keywords")
    public KeywordsCountDTO countKeywords(@RequestBody Scenario scenario) {
        KeywordCounter counter = new KeywordCounter();
        return counter.countKeywords(scenario);
    }

    /**
     * Count number of steps in scenario
     * @param scenario scenario passed in request body
     * @return total number of steps
     */
    @PostMapping("/steps")
    public StepCountDTO countSteps(@RequestBody Scenario scenario) {
        StepCounter counter = new StepCounter();
        return counter.countSteps(scenario);
    }

}


