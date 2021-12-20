package pl.put.poznan.checker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class of the application
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.checker.rest"})
public class ScenarioQualityCheckerApplication {

    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(ScenarioQualityCheckerApplication.class);

    /**
     * Run Spring application
     * @param args application arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ScenarioQualityCheckerApplication.class, args);
        logger.info("Running application");
    }
}
