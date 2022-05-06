package com.ANZ.AnzCalculator.run;

import com.ANZ.AnzCalculator.config.SeleniumConfig;
import static com.ANZ.AnzCalculator.config.SeleniumConfig.setupDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Calculator.feature",glue = {""},
        plugin = {"pretty", "html:target/site/cucumber-pretty"},
        dryRun = false,
        monochrome = true)
public class RunnerTest {
    public static SeleniumConfig seleniumConfig;

    /**
     * Setup and load the Calculator page for each test
     */
    @BeforeClass
    public static void setupSuite() {
        setupDriver();
        seleniumConfig = new SeleniumConfig();
    }

    /**
     * Tear down after the test suite and close the browser.
     */
    @AfterClass
    public static void tearDownSuite() {
        seleniumConfig.getDriver().close();
    }
}

