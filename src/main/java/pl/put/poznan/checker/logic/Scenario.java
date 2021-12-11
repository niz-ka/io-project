package pl.put.poznan.checker.logic;

public class Scenario {
    private String title;
    private String[] actors;
    private String[] systemActors;
    private ScenarioStep[] steps;

    public Scenario(String title, String[] actors, String[] systemActors, ScenarioStep[] steps) {
        this.title = title;
        this.actors = actors;
        this.systemActors = systemActors;
        this.steps = steps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String[] getSystemActors() {
        return systemActors;
    }

    public void setSystemActors(String[] systemActors) {
        this.systemActors = systemActors;
    }

    public ScenarioStep[] getSteps() {
        return steps;
    }

    public void setSteps(ScenarioStep[] steps) {
        this.steps = steps;
    }

    public static Scenario generateExample() {
        return new Scenario(
                "Dodanie książki",
                new String[]{"Bibliotekarz"},
                new String[]{"System"},
                new ScenarioStep[]{
                        new ScenarioStep("Wyświetla się fomularz", null),
                        new ScenarioStep("IF: Bibliotekarz pragnie dodać egzemplarz książki", new ScenarioStep[]{
                                new ScenarioStep("Bibliotekarz wybiera opcję definiowania egzemplarzy", null),
                                new ScenarioStep("System prezentuje zdefiniowane egzemplarze", null)
                        })
                }
        );
    }
}
