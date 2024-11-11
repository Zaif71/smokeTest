package TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * TestRunner is the entry point for executing Cucumber tests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Feature",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = true,
        tags = "@zaif1"
)
public class TestRunner{
    // This class remains empty
    // It serves as a holder for the above annotations
}

