package pl.put.poznan.checker.logic.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;

import java.util.ArrayList;

/**
 * Class for getting steps with specific actor.
 */
public class QueryStepsByActorVisitor implements Visitor {

    /**
     * Initialize step searcher
     * @param a Actor
     */
    public QueryStepsByActorVisitor(String a) {
        this.actor = a;
    }

    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(QueryStepsByActorVisitor.class);

    /**
     * Queried steps
     */
    ArrayList<ScenarioStep> actorSteps = new ArrayList<>();

    /**
     * Actor to search steps
     */
    String actor;

    @Override
    public void visit(Scenario scenario) {
        this.actorSteps = this.queryByActor(scenario.getSteps(), this.actor);
        logger.info("Searching steps for actor " + this.actor);
    }

    /**
     * Get steps including actor
     * @param steps List of steps.
     * @param actor Actor to find.
     * @return List of steps including specific actor.
     */
    protected ArrayList<ScenarioStep> queryByActor(ScenarioStep[] steps, String actor) {
        ArrayList<ScenarioStep> queriedSteps = new ArrayList<>();
        for (ScenarioStep step : steps) {
            if (step.getName().contains(actor)) {
                queriedSteps.add(step);
            }
            if (step.getChildrenSteps() != null && step.getChildrenSteps().length > 0) {
                queriedSteps.addAll(this.queryByActor(step.getChildrenSteps(), actor));
            }
        }
        return queriedSteps;
    }

    public ArrayList<ScenarioStep> getSteps() {
        return this.actorSteps;
    }
}
