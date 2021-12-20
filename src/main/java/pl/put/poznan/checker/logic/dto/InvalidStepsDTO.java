package pl.put.poznan.checker.logic.dto;

import pl.put.poznan.checker.logic.visitable.ScenarioStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

/**
 * Invalid steps data transfer object.
 */
public class InvalidStepsDTO implements DTO {
    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(InvalidStepsDTO.class);

    /**
     * Array of invalid steps.
     */
    public ArrayList<ScenarioStep> steps;

    /**
     * Default constructor to set invalid steps in DTO.
     * @param s Array of steps.
     */
    public InvalidStepsDTO(ArrayList<ScenarioStep> s) {
        this.steps = s;
        logger.info("\tConverted invalid steps to DTO");
    }
}
