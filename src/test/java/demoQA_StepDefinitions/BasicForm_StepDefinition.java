package demoQA_StepDefinitions;

import demoQA.com.LandingPage_PageObjects;
import demoQA.com.TextBox_PageObjects;
import common_utilities.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BasicForm_StepDefinition extends BasePage {
//    LandingPage_PageObjects lp;
    LandingPage_PageObjects lp = new LandingPage_PageObjects();
    TextBox_PageObjects tb=new TextBox_PageObjects();

    @Given("^a user navigates to given url$")
    public void a_user_navigates_to_given_url() throws Throwable {
        lp.navigateToHomePage();
    }

    @Given("^a user is on demoQA homepage and clicks on elements$")
    public void a_user_is_on_demoqa_homepage_and_clicks_on_elements() throws Throwable {
        lp.clickElementsCard();
    }

    @When("^user clicks on text box$")
    public void user_clicks_on_text_box() throws Throwable {
        tb.clickTextBox();
    }

    @And("^user provides full name (.+), (.+), (.+) and (.+)$")
    public void user_provides_full_name_and(String fullname, String email, String currentAddress, String permanentAddress) throws Throwable {
        tb.fillOutForm(fullname, email, currentAddress,permanentAddress);
    }

    @Then("^user can click on submit$")
    public void user_can_click_on_submit() throws Throwable {
        tb.submit();
    }
    @Then("^I can check form has correct details as (.+), (.+), (.+) and (.+)$")
    public void i_can_check_form_has_correct_details_as_and(String fullName, String email, String currentAddress, String permanentAddress) throws Throwable {
        tb.checkCompletedForm(fullName, email, currentAddress,permanentAddress);
    }



}
