package StepDefinitions;

import common_utilities.BasePage;
import demoQA.com.Tooltip_PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ToolTip_StepDefinition extends BasePage {
    Tooltip_PageObjects tt=new Tooltip_PageObjects();

    @Given("^I navigate to toolTip page$")
    public void i_navigate_to_tooltip_page() throws Throwable {
        tt.navigateToToolTipPage();
    }

    @Then("^I can hover over button$")
    public void i_can_hover_over_button() throws Throwable {
       tt.hoverOverButton();
    }

    @And("^I can hover over input field and get text$")
    public void i_can_hover_over_input_field_and_get_text() throws Throwable {
        tt.hoverOverInputFieldAndGetText();

    }
}
