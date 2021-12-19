package pl.put.poznan.checker.logic.dto;

import pl.put.poznan.checker.logic.dto.DTO;

/**
 * Step counter data transfer object.
 */
public class StepCountDTO implements DTO {
    /**
     * Number of steps.
     */
    public Integer steps;

    /**
     * Default constructor to set steps value.
     * @param s number of steps.
     */
    public StepCountDTO(Integer s) { this.steps = s; }
}
