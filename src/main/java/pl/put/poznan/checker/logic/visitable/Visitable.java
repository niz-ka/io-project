package pl.put.poznan.checker.logic.visitable;

import pl.put.poznan.checker.logic.visitor.Visitor;

/**
 * Part of visitor pattern
 */
public interface Visitable {
    /**
     * Accept a visitor instance
     * @param visitor instance of visitor
     */
    void accept(Visitor visitor);
}
