package pl.put.poznan.checker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the application
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.checker.rest"})
public class ScenarioQualityCheckerApplication {

    /**
     * Run Spring application
     * @param args application arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ScenarioQualityCheckerApplication.class, args);
    }
}
