package CucumberAPI;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/CucumberAPI",
        glue = "CucumberAPI/stepDefs",
        tags = "@pet1",
        dryRun = false
)


public class CucumberAPIRunner {


}
