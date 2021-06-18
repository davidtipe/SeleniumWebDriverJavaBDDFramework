package demoQA.com;

import common_utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames_PageObjects extends BasePage {
    public Frames_PageObjects ()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "(//div[@class='card-body'])[3]")
    protected WebElement alertsFrameAndWindowsCard;

    @FindBy (xpath = "//span[contains(text(),'Frames')]")
    protected WebElement framesPage;

    @FindBy (xpath = "//iframe[@id='frame1']")
    protected WebElement iFrame;

    @FindBy (id = "sampleHeading")
    protected WebElement iFrameHeader;

    @FindBy (xpath = "//div[contains(text(),'Sample Iframe page There are 2 Iframes in this pag')]")
    protected WebElement defaultContentText;

    public void navigateToFramesPage ()
    {
        waitUntilVisibleAndClick(alertsFrameAndWindowsCard);
        framesPage.click();

    }

    public void getTextInFrame()
    {
        driver.switchTo().frame(iFrame);
        System.out.println(iFrameHeader.getText());
        driver.switchTo().defaultContent();
        System.out.println("default content text "+ defaultContentText.getText());
    }
}
