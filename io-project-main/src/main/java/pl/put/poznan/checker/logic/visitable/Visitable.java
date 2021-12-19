package pl.put.poznan.checker.logic.visitable;

import pl.put.poznan.checker.logic.dto.DTO;
import pl.put.poznan.checker.logic.visitor.Visitor;

public interface Visitable {
    DTO accept(Visitor visitor);
}
