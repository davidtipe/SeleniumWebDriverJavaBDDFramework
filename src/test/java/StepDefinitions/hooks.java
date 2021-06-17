package StepDefinitions;

import common_utilities.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class hooks extends BasePage {
    @Before("@frames")
    public void beforeScenario(){
        startDriver();
    }

    @After("@frames")
    public void afterScenario(){
        driver.quit();
    }
}
