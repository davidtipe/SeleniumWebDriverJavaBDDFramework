package StepDefinitions;

import common_utilities.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class hooks extends BasePage {
    @Before("@test")
    public void beforeScenario(){
        startDriver();
    }

    @After("@test")
    public void afterScenario(){
        driver.quit();
    }
}
