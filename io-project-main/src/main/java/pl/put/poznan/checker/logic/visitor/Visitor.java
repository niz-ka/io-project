package pl.put.poznan.checker.logic.visitor;

import pl.put.poznan.checker.logic.visitable.Scenario;
import pl.put.poznan.checker.logic.dto.DTO;

public interface Visitor {
    DTO visit(Scenario scenario);
}
