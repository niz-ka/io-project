package pl.put.poznan.checker.logic.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.visitable.ScenarioStep;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KeywordCounterVisitorTest {

    private KeywordCounterVisitor keywordCounterVisitor;

    @BeforeEach
    public void setUp() {
        keywordCounterVisitor = new KeywordCounterVisitor();
    }

    @Test
    public void should_throw_null_pointer_exception_when_step_name_is_null() {
        assertThrows(NullPointerException.class, () -> {
            ScenarioStep scenarioStep = mock(ScenarioStep.class);
            keywordCounterVisitor.keywordInStep(scenarioStep);
            verify(scenarioStep, times(1)).getName();
        });
    }

    @Test
    public void should_return_false_when_step_name_is_empty() {
        ScenarioStep scenarioStep = mock(ScenarioStep.class);
        when(scenarioStep.getName()).thenReturn("");
        assertFalse(keywordCounterVisitor.keywordInStep(scenarioStep));
        verify(scenarioStep, atLeast(1)).getName();
    }

    @Test
    public void should_return_true_when_step_name_contains_keyword_with_space() {
        ScenarioStep scenarioStep = mock(ScenarioStep.class);
        when(scenarioStep.getName()).thenReturn("IF: something");
        assertTrue(keywordCounterVisitor.keywordInStep(scenarioStep));
        verify(scenarioStep, atLeast(1)).getName();
    }

    @Test
    public void should_return_true_when_step_name_contains_keyword_without_space() {
        ScenarioStep scenarioStep = new ScenarioStep("IF:something", null);
        assertTrue(keywordCounterVisitor.keywordInStep(scenarioStep));
    }

    @Test
    public void should_return_zero_when_steps_is_null() {
        assertEquals(0, keywordCounterVisitor.countKeywordsInStepsArray(null));
    }

    @Test
    public void should_return_zero_when_steps_is_empty() {
        assertEquals(0, keywordCounterVisitor.countKeywordsInStepsArray(new ScenarioStep[]{}));
    }

    @Test
    public void should_return_three_when_nested_steps() {
        ScenarioStep[] scenarioSteps = new ScenarioStep[]{
                new ScenarioStep("IF:something", new ScenarioStep[]{
                        new ScenarioStep("FOR EACH: something something", new ScenarioStep[]{
                                new ScenarioStep("ELSE: something something something", null)
                        })
                }),
        };

        assertEquals(3, keywordCounterVisitor.countKeywordsInStepsArray(scenarioSteps));
    }

    @Test
    public void should_return_one_when_keyword_many_times() {
        ScenarioStep[] scenarioSteps = new ScenarioStep[]{
                new ScenarioStep("IF: IF: FOR EACH: ELSE:", null)
        };

        assertEquals(1, keywordCounterVisitor.countKeywordsInStepsArray(scenarioSteps));
    }

    @Test
    public void should_call_gets_steps_exactly_once() {
        Scenario scenario = mock(Scenario.class);
        keywordCounterVisitor.visit(scenario);
        verify(scenario, times(1)).getSteps();
    }

    @Test
    public void should_set_one() {
        Scenario scenario = new Scenario(null, null, null, new ScenarioStep[]{
                new ScenarioStep("IF: something", null)
        });
        keywordCounterVisitor.visit(scenario);
        assertEquals(1, keywordCounterVisitor.getNumberOfKeywords());
    }
}