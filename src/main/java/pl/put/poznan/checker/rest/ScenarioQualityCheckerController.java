package pl.put.poznan.checker.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.checker.logic.Scenario;

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

}


