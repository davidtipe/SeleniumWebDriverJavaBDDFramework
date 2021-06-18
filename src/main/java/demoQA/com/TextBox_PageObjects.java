package demoQA.com;

import common_utilities.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBox_PageObjects extends BasePage {
    public TextBox_PageObjects() {PageFactory.initElements(driver, this); }

    @FindBy(id = "item-0")
    protected List<WebElement> textBox;

    @FindBy(css = "#userName")
    protected WebElement fullName;

    @FindBy(css = "#userEmail")
    protected WebElement email;

    @FindBy(css = "#currentAddress")
    protected WebElement currentAddress;

    @FindBy(css = "#permanentAddress")
    protected WebElement permanentAddress;

    @FindBy(css = "#submit")
    protected WebElement submitButton;

    @FindBy (css= "#name")
    protected WebElement formNameField;

    @FindBy (css= "#email")
    protected WebElement formEmailField;

    @FindBy (xpath= "//p[@id='currentAddress']")
    protected WebElement formCurrentAddressField;

    @FindBy (xpath= "//p[@id='permanentAddress']")
    protected WebElement formPermanentAddressField;

    public void clickTextBox() {
        textBox.get(0).click();
    }

    public void fillOutForm(String fullName, String email, String currentAddress, String permanentAddress) {
        clickAndSendKeys(this.fullName, fullName);
        clickAndSendKeys(this.email, email);
        clickAndSendKeys(this.currentAddress,currentAddress);
        clickAndSendKeys(this.permanentAddress, permanentAddress);
    }

    public void submit()
    {
        scrollDown();
        submitButton.click();
    }

    public void checkCompletedForm (String fullName, String email, String currentAddress, String permanentAddress)
    {
        waitUntilVisibleAndClick(formNameField);
        Assert.assertEquals(formNameField.getText().split(":")[1], fullName);
        Assert.assertEquals(formEmailField.getText().split(":")[1], email);
        Assert.assertEquals(formCurrentAddressField.getText().split(":")[1], currentAddress);
        Assert.assertEquals(formPermanentAddressField.getText().split(":")[1], permanentAddress);
    }
}
