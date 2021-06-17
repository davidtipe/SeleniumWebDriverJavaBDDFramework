package StepDefinitions;

import common_utilities.BasePage;
import demoQA.com.DatePicker_PageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DatePicker_StepDefinition extends BasePage {
    DatePicker_PageObjects dp=new DatePicker_PageObjects();

    @Given("^I navigate to the date picker page$")
    public void i_navigate_to_the_date_picker_page() throws Throwable {
       dp.navigateToDatePickerPage();
    }

    @When("^I click on select date field I can get the text$")
    public void i_click_on_select_date_field_i_can_get_the_text() throws Throwable {
      dp.selectPlusOneMonth();
    }
}
