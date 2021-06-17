package StepDefinitions;

import common_utilities.BasePage;
import demoQA.com.StudentForm_PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StudentForm_StepDefinition extends BasePage {

    StudentForm_PageObjects st = new StudentForm_PageObjects();

    @Given("^student navigates to student registration form page$")
    public void student_navigates_to_student_registration_form_page() throws Throwable {
        st.navigateToStudentForm();
    }

    @And("^student provides first name, last name, email and Mobile$")
    public void student_provides_first_name_last_name_email_and_mobile() throws Throwable {
        st.sendEmailMobileFirstAndLastName();
    }

    @And("^student selects gender$")
    public void student_selects_gender() throws Throwable {
        st.selectGender();
    }

    @And("^selects date of birth as day \"([^\"]*)\", month \"([^\"]*)\" and year \"([^\"]*)\"$")
    public void selects_date_of_birth_as_day_something_month_something_and_year_something(String day, String month, String year) throws Throwable {
        st.selectDOB(day, month, year);
    }

    @And("^chooses subjects \"([^\"]*)\" and \"([^\"]*)\"$")
    public void chooses_subjects_something_and_something(String maths, String english) throws Throwable {
        st.chooseSubjects(maths, english);
    }

    @And("^selects hobbies$")
    public void selects_hobbies() throws Throwable {
        st.selectHobbies();
    }

    @And("^uploads a file$")
    public void uploads_a_file() throws Throwable {
        st.uploadFile();
    }

    @And("^provides current address$")
    public void provides_current_address() throws Throwable {
        st.sendCurrentAddress();
    }

    @And("^selects states and city$")
    public void selects_states_and_city() throws Throwable {
        st.selectState();
        st.selectCity();
    }

    @Then("^submits form$")
    public void submits_form() throws Throwable {
        st.submitForm();
    }

    @And("^I can verify that a modal detailing form information is displayed$")
    public void i_can_verify_that_a_modal_detailing_form_information_is_displayed() throws Throwable {
        st.verifyModalIsDisplayed();
    }

    @Then("^I can close Modal$")
    public void i_can_close_modal() throws Throwable {
        st.closeModal();
    }

    @Then("^user can verify validation is performed on required fields$")
    public void user_can_verify_validation_is_performed_on_required_fields() throws Throwable {
       st.formValidation();
    }
}
