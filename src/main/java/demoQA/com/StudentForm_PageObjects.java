package demoQA.com;

import common_utilities.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class StudentForm_PageObjects extends BasePage {

    public StudentForm_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='card-body'])[2]")
    protected WebElement formCard;

    @FindBy(xpath = "//span[contains(text(),'Practice Form')]")
    protected WebElement practiceForm;

    @FindBy(css = "#firstName")
    protected WebElement firstName;

    @FindBy(css = "#lastName")
    protected WebElement lastName;

    @FindBy(css = "#userEmail")
    protected WebElement email;

    @FindBy(css = "#userNumber")
    protected WebElement mobile;

    @FindBy(css = "#dateOfBirthInput")
    protected WebElement dobField;

    @FindBy(xpath = "//div[@role='option']")
    protected List<WebElement> dayPicker;

    @FindBy(className = "react-datepicker__month-select")
    protected WebElement monthPicker;

    @FindBy(className = "react-datepicker__year-select")
    protected WebElement yearPicker;

    @FindBy(className = "custom-control-label")
    protected List<WebElement> buttonLabels;

    @FindBy(id = "subjectsInput")
    protected WebElement subjectsField;

    @FindBy(css = "#uploadPicture")
    protected WebElement chooseFileBtn;

    @FindBy(id = "currentAddress")
    protected WebElement currentAddress;

    @FindBy(xpath = "(//div[@id='stateCity-wrapper']/div[2]/div/div/div)[2]")
    protected WebElement stateFld;

    @FindBy(css = "#city")
    protected WebElement city;

    @FindBy(css = "#submit")
    protected WebElement submitButton;

    @FindBy(css = "#example-modal-sizes-title-lg")
    protected WebElement modalHeader;

    @FindBy(css = "#closeLargeModal")
    protected WebElement closeModalBtn;

    @FindBy(className = "was-validated")
    protected WebElement formValidated;

    public void navigateToStudentForm() throws InterruptedException {
        Thread.sleep(500);
        javascriptClick(formCard);
        //waitUntilVisibleAndClick(formCard);
        practiceForm.click();


    }

    public void sendEmailMobileFirstAndLastName() throws IOException {
        clickAndSendKeys(firstName, getProperty("firstName"));
        clickAndSendKeys(lastName, getProperty("lastName"));
        clickAndSendKeys(email, getProperty("email"));
        clickAndSendKeys(mobile, getProperty("mobileNumber"));
    }

    public void selectGender() throws IOException {
        cycleThroughList(buttonLabels, getProperty("gender"));
    }

    public void selectDOB(String day, String month, String year) {
        dobField.click();
        Select selectMonth = new Select(monthPicker);
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(yearPicker);
        selectYear.selectByVisibleText(year);

        try {
            cycleThroughList(dayPicker, day);
        } catch (StaleElementReferenceException e) {
            cycleThroughList(dayPicker, day);
        }
        // retryingFindClickInList(dayPicker, day);
    }

    public void chooseSubjects(String maths, String english) {
        clickAndSendKeys(subjectsField, maths);
        subjectsField.sendKeys(Keys.TAB);

        clickAndSendKeys(subjectsField, english);
        subjectsField.sendKeys(Keys.TAB);
    }

    public void selectHobbies() throws IOException {
        cycleThroughList(buttonLabels, getProperty("hobbies"));
    }

    public void uploadFile() {
        chooseFileBtn.sendKeys("/Users/david/Downloads/testFile.jpeg");
    }

    public void sendCurrentAddress() throws IOException {
        scrollDown();
        clickAndSendKeys(currentAddress, getProperty("currentAddress"));
    }

    public void selectState() throws IOException {
        stateFld.click();
        sendKeysStringWithActionsClass(getProperty("state"));
        sendKeyKeysWithActionsClass(Keys.TAB);
    }

    public void selectCity() throws IOException {
        waitUntilVisibleAndClick(city);
        sendKeysStringWithActionsClass(getProperty("city"));
        sendKeyKeysWithActionsClass(Keys.TAB);
    }

    public void submitForm() {
        submitButton.click();
    }

    public void verifyModalIsDisplayed() {
        Assert.assertTrue(modalHeader.isDisplayed());
        System.out.println("Modal header text is: " + modalHeader.getText());
    }

    public void closeModal() throws InterruptedException {
        Thread.sleep(500);
        javascriptClick(closeModalBtn);
    }

    public void formValidation() {
        Assert.assertTrue(formValidated.isDisplayed());
    }


}
