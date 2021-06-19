package demoQA.com;

import common_utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Alerts_PageObjects extends BasePage {
    Frames_PageObjects fp=new Frames_PageObjects();
    public Alerts_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    protected WebElement alertsPage;

    @FindBy(css = "#alertButton")
    protected WebElement clickToSeeAlertButton;

    @FindBy(css = "#timerAlertButton")
    protected WebElement timerAlertButton;

    @FindBy(css = "#confirmButton")
    protected WebElement confirmBtn;

    @FindBy(id = "promtButton")
    protected WebElement promtBtn;

    public void navigateToAlertPage() {
        fp.alertsFrameAndWindowsCard.click();
        alertsPage.click();
    }

    public void clickToSeeAlert() {
        waitUntilVisibleAndClick(clickToSeeAlertButton);
    }

    public void acceptAlert() {
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

    public void timedAlert() {
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
