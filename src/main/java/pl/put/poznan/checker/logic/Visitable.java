package pl.put.poznan.checker.logic;

public interface Visitable {
    DTO accept(Visitor visitor);
}
