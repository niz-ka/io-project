package pl.put.poznan.checker.logic.visitor;

import pl.put.poznan.checker.logic.visitable.Scenario;

/**
 * Part of visitor pattern
 */
public interface Visitor {
    /**
     * Visit scenario instance
     * @param scenario instance of scenario
     */
    void visit(Scenario scenario);
}
