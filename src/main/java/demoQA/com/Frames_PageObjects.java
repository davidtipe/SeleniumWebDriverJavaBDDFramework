package demoQA.com;

import common_utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames_PageObjects extends BasePage {
    LandingPage_PageObjects lp=new LandingPage_PageObjects();
    public Frames_PageObjects ()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "(//div[@class='header-text'])[3]")
    private WebElement frameHeader;

    @FindBy (xpath = "//span[contains(text(),'Frames')]")
    private WebElement framesPage;

    @FindBy (xpath = "//iframe[@id='frame1']")
    private WebElement iFrame;

    @FindBy (id = "sampleHeading")
    private WebElement iFrameHeader;

    @FindBy (xpath = "//div[contains(text(),'Sample Iframe page There are 2 Iframes in this pag')]")
    private WebElement defaultContentText;

    public void navigateToFramesPage ()
    {
        lp.clickElementsCard();
        scrollDown();
        waitUntilVisibleAndClick(frameHeader);
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
