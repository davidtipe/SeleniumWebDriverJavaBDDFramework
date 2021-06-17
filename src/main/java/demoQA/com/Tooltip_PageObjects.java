package demoQA.com;

import common_utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Tooltip_PageObjects extends BasePage {
    LandingPage_PageObjects lp=new LandingPage_PageObjects();
    public Tooltip_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "(//div[@class='header-text'])[4]")
    private WebElement toolTipHeader;

    @FindBy (xpath = "//span[contains(text(),'Tool Tips')]")
    private WebElement toolTipPage;

    @FindBy (css = "#toolTipButton")
    private WebElement button;

    @FindBy (css = "#toolTipTextField")
    private WebElement inputField;


    public void navigateToToolTipPage(){
        lp.clickElementsCard();
        waitUntilVisibleAndClick(toolTipHeader);
        scrollDown();
        waitUntilVisibleAndClick(toolTipPage);
    }


    public void hoverOverButton()
    {
        actions.moveToElement(button).perform();
        System.out.println(button.getAttribute("id"));
    }

    public void hoverOverInputField()
    {
        actions.moveToElement(inputField).perform();
        System.out.println(inputField.getAttribute("id"));
    }
}
