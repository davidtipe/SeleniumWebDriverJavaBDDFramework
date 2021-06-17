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
    LandingPage_PageObjects lp;

    public StudentForm_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Practice Form')]")
    private WebElement practiceForm;

    @FindBy(xpath = "(//div[@class='header-text'])[2]")
    private WebElement formHeader;

    @FindBy(css = "#firstName")
    private WebElement firstName;

    @FindBy(css = "#lastName")
    private WebElement lastName;

    @FindBy(css = "#userEmail")
    private WebElement email;

    @FindBy(css = "#userNumber")
    private WebElement mobile;

    @FindBy(css = "#dateOfBirthInput")
    private WebElement dobField;

    @FindBy(xpath = "//div[@role='option']")
    private List<WebElement> dayPicker;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthPicker;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearPicker;

    @FindBy(className = "custom-control-label")
    private List<WebElement> buttonLabels;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsField;

    @FindBy(css = "#uploadPicture")
    private WebElement chooseFileBtn;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(xpath = "(//div[@id='stateCity-wrapper']/div[2]/div/div/div)[2]")
    private WebElement stateFld;

    @FindBy(xpath = "(//div[@id='stateCity-wrapper']/div[2]/div/div/div)[2]")
    private List<WebElement> stateFldList;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#submit")
    private WebElement submitButton;

    @FindBy (css = "#example-modal-sizes-title-lg")
    private WebElement modalHeader;

    @FindBy (css = "#closeLargeModal")
    private WebElement closeModalBtn;

    @FindBy (className = "was-validated")
    private WebElement formValidated;

    public void navigateToStudentForm() throws IOException, InterruptedException {
        lp = new LandingPage_PageObjects();
        lp.clickElementsCard();
        waitUntilVisibleAndClick(formHeader);
       //Thread.sleep(2000);
        //formHeader.click();
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

    public void verifyModalIsDisplayed ()
    {
        Assert.assertTrue(modalHeader.isDisplayed());
        System.out.println("Modal header text is: "+ modalHeader.getText());
    }

    public void closeModal ()
    {
        closeModalBtn.click();
    }

    public void formValidation(){
        Assert.assertTrue(formValidated.isDisplayed());
    }




}
