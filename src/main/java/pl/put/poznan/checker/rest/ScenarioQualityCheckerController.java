package pl.put.poznan.checker.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.checker.logic.dto.InvalidStepsDTO;
import pl.put.poznan.checker.logic.dto.KeywordsCountDTO;
import pl.put.poznan.checker.logic.dto.QueryStepsDTO;
import pl.put.poznan.checker.logic.dto.StepCountDTO;
import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitor.InvalidActorStepVisitor;
import pl.put.poznan.checker.logic.visitor.KeywordCounterVisitor;
import pl.put.poznan.checker.logic.visitor.QueryStepsByActorVisitor;
import pl.put.poznan.checker.logic.visitor.StepCounterVisitor;

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
        KeywordCounterVisitor counter = new KeywordCounterVisitor();
        scenario.accept(counter);
        return new KeywordsCountDTO(counter.getNumberOfKeywords());
    }

    /**
     * Count number of steps in scenario
     * @param scenario scenario passed in request body
     * @return total number of steps
     */
    @PostMapping("/steps")
    public StepCountDTO countSteps(@RequestBody Scenario scenario) {
        StepCounterVisitor counter = new StepCounterVisitor();
        scenario.accept(counter);
        return new StepCountDTO(counter.getNumberOfSteps());
    }


    /**
     * Get invalid steps without actor at the beginning
     * @param scenario scenario passed in request body
     * @return array of steps
     */
    @PostMapping("/actors")
    public InvalidStepsDTO invalidSteps(@RequestBody Scenario scenario) {
        InvalidActorStepVisitor checker = new InvalidActorStepVisitor();
        scenario.accept(checker);
        return new InvalidStepsDTO(checker.getInvalidSteps());
    }

    /**
     * Get steps containing specific actor
     * @param scenario scenario passed in request body
     * @param actor Actor to search for
     * @return array of steps
     */
    @PostMapping("/query")
    public QueryStepsDTO getStepsByActor(@RequestBody Scenario scenario,  @RequestParam(required=false) String actor) {
        QueryStepsByActorVisitor searcher = new QueryStepsByActorVisitor(actor);
        scenario.accept(searcher);
        return new QueryStepsDTO(searcher.getSteps());
    }
}


