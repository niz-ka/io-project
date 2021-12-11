package pl.put.poznan.checker.logic;
/**
 * Step counter data transfer object.
 */
public class StepCountDTO {
    /**
     * Number of steps.
     */
    public Integer steps = 0;

    /**
     * Default constructor to set steps value.
     * @param s Number of steps.
     */
    public StepCountDTO(Integer s) { this.steps = s; }
}
