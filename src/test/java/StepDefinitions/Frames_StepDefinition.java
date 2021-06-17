package StepDefinitions;

import common_utilities.BasePage;
import demoQA.com.Droppable_PageObjects;
import demoQA.com.Frames_PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Frames_StepDefinition extends BasePage {
    Frames_PageObjects frames = new Frames_PageObjects();
    Droppable_PageObjects dp = new Droppable_PageObjects();

    @Given("^I navigate to the frame page$")
    public void i_navigate_to_the_frame_page() throws Throwable {
        frames.navigateToFramesPage();
    }

    @When("^I switch to frame then I can get text$")
    public void i_switch_to_frame_then_i_can_get_text() throws Throwable {
        frames.getTextInFrame();
    }

    @Then("^I navigate to the droppable page$")
    public void i_navigate_to_the_droppable_page() throws Throwable {
        dp.navigateToDroppable();
    }

    @And("^I can drag and drop an element$")
    public void i_can_drag_and_drop_an_element() throws Throwable {
        dp.dragAndDropElement();
    }

}
