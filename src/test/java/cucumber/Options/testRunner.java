package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        plugin = "json:target/jsonReports/cucumber-report.json",
        glue = "stepDefinitions",
        monochrome = true, // to display console output in proper readable format
        dryRun = false// to check the mapping is proper between feature file and step definition file if made it true
       // tags = "@UpdatePlace"
)
public class testRunner {

}
