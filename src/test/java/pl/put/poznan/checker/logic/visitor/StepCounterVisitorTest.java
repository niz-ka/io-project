package pl.put.poznan.checker.logic.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StepCounterVisitorTest {

    private StepCounterVisitor stepCounterVisitor;

    @BeforeEach
    public void setUp() {
        stepCounterVisitor = new StepCounterVisitor();
    }

    @Test
    public void should_return_zero_when_steps_is_null() {
        assertEquals(0, stepCounterVisitor.countStepsWithSubsteps(null));
    }

    @Test
    public void should_return_zero_when_steps_is_empty_array() {
        assertEquals(0, stepCounterVisitor.countStepsWithSubsteps(new ScenarioStep[]{}));
    }

    @Test
    public void should_return_one_when_steps_contains_one_step_without_substep() {
        ScenarioStep scenarioStepMock = mock(ScenarioStep.class);
        ScenarioStep[] steps = new ScenarioStep[]{scenarioStepMock};

        assertEquals(1, stepCounterVisitor.countStepsWithSubsteps(steps));
        verify(scenarioStepMock, times(1)).getChildrenSteps();
    }

    @Test
    public void should_throw_null_pointer_exception_when_scenario_is_null() {
        assertThrows(NullPointerException.class, () -> stepCounterVisitor.visit(null));
    }

    @Test void should_call_get_steps_method_only_once() {
        Scenario scenario = mock(Scenario.class);

        stepCounterVisitor.visit(scenario);
        verify(scenario).getSteps();
    }

    @Test
    public void should_set_zero_when_scenario_is_empty() {
        Scenario scenario = mock(Scenario.class);
        when(scenario.getSteps()).thenReturn(null);
        stepCounterVisitor.visit(scenario);
        verify(scenario).getSteps();

        assertEquals(0, stepCounterVisitor.getNumberOfSteps());
    }

    @Test
    public void should_set_three() {
        Scenario scenario = mock(Scenario.class);
        when(scenario.getSteps()).thenReturn(new ScenarioStep[]{
                new ScenarioStep(null, new ScenarioStep[]{
                        new ScenarioStep(null, new ScenarioStep[]{
                                new ScenarioStep(null, null)
                        })
                })
        });

        stepCounterVisitor.visit(scenario);
        verify(scenario, times(2)).getSteps();
        assertEquals(3, stepCounterVisitor.getNumberOfSteps());
    }
}