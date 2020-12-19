package cucumber_class.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber_class/stepdefs",
        tags = "@test",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false)
public class SmokeTestRunner {





}
