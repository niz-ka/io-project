package pl.put.poznan.checker.logic;

public interface Visitor {
    // Created to automatically use the righ code based on the Object sent
    // Method Overloading

    public DTO visit(Scenario scenario);
}
