package bookerAPI_stepDefinitions;

import common_utilities.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class bookerAPI_Hooks extends BasePage {
    @Before("@test")
    public void beforeScenario(){
    //    startDriver();
    }

    @After("@test")
    public void afterScenario(){
      //  driver.quit();
    }
}
