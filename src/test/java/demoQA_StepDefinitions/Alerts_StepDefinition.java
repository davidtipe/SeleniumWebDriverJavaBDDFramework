package demoQA_StepDefinitions;

import common_utilities.BasePage;
import demoQA.com.Alerts_PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Alerts_StepDefinition extends BasePage {
    Alerts_PageObjects alerts = new Alerts_PageObjects();

    @Given("^a user navigates to alerts page$")
    public void a_user_navigates_to_alerts_page() throws Throwable {
        alerts.navigateToAlertPage();
    }

    @And("^clicks button to see alert$")
    public void clicks_button_to_see_alert() throws Throwable {
        alerts.clickToSeeAlert();
    }

    @Then("^user can click ok button on alert$")
    public void user_can_click_ok_button_on_alert() throws Throwable {
        alerts.acceptAlert();
    }

    @And("^user clicks on button and waits five seconds for alert$")
    public void user_clicks_on_button_and_waits_five_seconds_for_alert() throws Throwable {
        alerts.timedAlert();
    }

    @And("^user clicks button and can dismiss alert box$")
    public void user_clicks_button_and_can_dismiss_alert_box() throws Throwable {
        alerts.confirmBoxAlert();
        alerts.dismissAlert();
    }

    @And("^user clicks button and can select ok button$")
    public void user_clicks_button_and_can_select_ok_button() throws Throwable {
        alerts.confirmBoxAlert();
        alerts.acceptAlert();
    }

    @And("^user clicks on button and can type into prompt and select ok$")
    public void user_clicks_on_button_and_can_type_into_prompt_and_select_ok() throws Throwable {
        alerts.promptAlert();
        alerts.acceptAlert();

    }

    @And("^user clicks on button and can press cancel on prompt$")
    public void user_clicks_on_button_and_can_press_cancel_on_prompt() throws Throwable {
        alerts.promptAlert();
        alerts.dismissAlert();
    }

}
