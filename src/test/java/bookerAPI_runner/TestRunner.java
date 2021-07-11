package bookerAPI_runner;


import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {"html:report/cucumber-pretty","json:target/cucumber.json"},
       // tags={},
      //  monochrome = true,
        features = "src/test/java/bookerAPI_features",
        glue = "bookerAPI_stepDefinitions"
)
public class TestRunner {

}
