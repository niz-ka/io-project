package pl.put.poznan.checker.logic.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;

import java.util.ArrayList;

/**
 * Steps query data transfer object.
 */
public class QueryStepsDTO {
    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(QueryStepsDTO.class);

    /**
     * Number of steps
     */
    public int count = 0;

    /**
     * List of queried steps.
     */
    public ArrayList<ScenarioStep> steps;


    public QueryStepsDTO(ArrayList<ScenarioStep> s) {
        this.steps = s;
        this.count = s.size();
        logger.info("\tConverted queried steps to DTO");
    }
}
