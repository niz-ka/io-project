package pl.put.poznan.checker.logic.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Step counter data transfer object.
 */
public class StepCountDTO {
    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(StepCountDTO.class);

    /**
     * Number of steps.
     */
    public int steps;

    /**
     * Default constructor to set steps value.
     * @param s number of steps.
     */
    public StepCountDTO(int s) {
        this.steps = s;
        logger.info("\tConverted number of steps to DTO");
    }
}
