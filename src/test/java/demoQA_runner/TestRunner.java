package demoQA_runner;



import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {"html:report/cucumber-pretty","json:target/cucumber.json"},
       // tags={},
      //  monochrome = true,
        features = "src/test/java/demoQA_features",
        glue = "demoQA_StepDefinitions"
)
public class TestRunner {

}
