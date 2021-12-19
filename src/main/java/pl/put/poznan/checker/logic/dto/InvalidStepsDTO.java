package pl.put.poznan.checker.logic.dto;

import pl.put.poznan.checker.logic.visitable.ScenarioStep;

import java.util.ArrayList;

/**
 * Invalid steps data transfer object.
 */
public class InvalidStepsDTO implements DTO {
    /**
     * Array of invalid steps.
     */
    public ArrayList<ScenarioStep> steps = new ArrayList<>();

    /**
     * Default constructor to set invalid steps in DTO.
     * @param s Array of steps.
     */
    public InvalidStepsDTO(ArrayList<ScenarioStep> s) {this.steps = s;}
}
