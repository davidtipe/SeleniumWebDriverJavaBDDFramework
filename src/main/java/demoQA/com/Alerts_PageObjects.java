package demoQA.com;

import common_utilities.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Alerts_PageObjects extends BasePage {
    LandingPage_PageObjects lp = new LandingPage_PageObjects();

    public Alerts_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='header-text'])[3]")
    private WebElement alertHeader;

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    private WebElement alertsPage;

    @FindBy(css = "#alertButton")
    private WebElement clickToSeeAlertButton;

    @FindBy(css = "#timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(css = "#confirmButton")
    private WebElement confirmBtn;

    @FindBy(id = "promtButton")
    private WebElement promtBtn;

    public void navigateToAlertPage() {
        lp.clickElementsCard();
        waitUntilVisibleAndClick(alertHeader);
        alertsPage.click();
    }

    public void clickToSeeAlert() {
        clickToSeeAlertButton.click();
    }

    public void acceptAlert() throws InterruptedException {
        waitUntilAlertPresent();
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() throws InterruptedException {
        waitUntilAlertPresent();
        Thread.sleep(5000);
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void timedAlert() throws InterruptedException {
        timerAlertButton.click();
    }

    public void confirmBoxAlert() {
        confirmBtn.click();
    }

    public void promptAlert() throws IOException {
        promtBtn.click();
        waitUntilAlertPresent();
        alert = driver.switchTo().alert();
        alert.sendKeys(getProperty("firstName") + " " + getProperty("lastName"));
    }


}
