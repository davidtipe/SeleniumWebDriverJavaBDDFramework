package cucumberOptions;



import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {"html:report/cucumber-pretty","json:target/cucumber.json"},
       // tags={},
      //  monochrome = true,
        features = "src/test/java/features",
        glue = "stepDefinitions"
)
public class TestRunner {

}
