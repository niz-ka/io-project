package pl.put.poznan.checker.logic;
/**
 * Step counter data transfer object.
 */
public class StepCountDTO implements DTO{
    /**
     * Number of steps.
     */
    public Integer steps = 0;

    /**
     * Default constructor to set steps value.
     * @param s number of steps.
     */
    public StepCountDTO(Integer s) { this.steps = s; }
}
