package pl.put.poznan.checker.logic.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InvalidActorStepVisitorTest {
    InvalidActorStepVisitor invalidActorStepVisitor;

    @BeforeEach
    public void setUp() {
        invalidActorStepVisitor = new InvalidActorStepVisitor();
    }

    @Test
    public void should_return_one_invalid_step() {
        Scenario scenario = mock(Scenario.class);
        when(scenario.getSteps()).thenReturn(new ScenarioStep[]{
                new ScenarioStep("Where is an actor?", new ScenarioStep[]{
                        new ScenarioStep("System actor is here!", null)
                })
        });
        when(scenario.getSystemActors()).thenReturn(new String[]{"System"});
        when(scenario.getActors()).thenReturn(new String[]{"Actor"});

        invalidActorStepVisitor.visit(scenario);
        assertEquals(1, invalidActorStepVisitor.getInvalidSteps().size());
        assertEquals("Where is an actor?", invalidActorStepVisitor.getInvalidSteps().get(0).getName());
        verify(scenario, atLeast(1)).getSteps();
    }

    @Test
    public void should_throw_null_pointer_exception_when_actors_is_null() {
        assertThrows(NullPointerException.class, () -> invalidActorStepVisitor.isStepValid("content"));
    }

    @Test
    public void should_return_false_when_step_content_is_empty() {
        Scenario scenario = mock(Scenario.class);
        when(scenario.getSteps()).thenReturn(new ScenarioStep[]{});
        when(scenario.getActors()).thenReturn(new String[]{});
        when(scenario.getSystemActors()).thenReturn(new String[]{});
        invalidActorStepVisitor.visit(scenario);
        assertFalse(invalidActorStepVisitor.isStepValid(""));
        verify(scenario, times(2)).getSteps();
        verify(scenario, times(2)).getActors();
        verify(scenario, times(2)).getSystemActors();
    }

}