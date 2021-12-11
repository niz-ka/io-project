package pl.put.poznan.checker.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.checker.logic.*;

@RestController
@RequestMapping("api/scenario")
public class ScenarioQualityCheckerController {

    // GET /api/scenario - show example
    @GetMapping
    public Scenario get() {
        return Scenario.generateExample();
    }

    // POST /api/scenario - read from request body and return
    @PostMapping
    public Scenario post(@RequestBody Scenario scenario) {
        return scenario;
    }

    // POST /api/scenario/keywords - count keywords
    @PostMapping("/keywords")
    public KeywordsCountDTO countKeywords(@RequestBody Scenario scenario) {
        KeywordCounter counter = new KeywordCounter();
        return counter.countKeywords(scenario);
    }

    // POST /api/scenario/steps - count steps
    @PostMapping("/steps")
    public StepCountDTO countSteps(@RequestBody Scenario scenario) {
        StepCounter counter = new StepCounter();
        return counter.countSteps(scenario);
    }

}


