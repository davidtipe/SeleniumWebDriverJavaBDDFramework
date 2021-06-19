package demoQA.com;

import common_utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Tooltip_PageObjects extends BasePage {
    public Tooltip_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='card-body'])[4]")
    protected WebElement widgetsCard;

    @FindBy(xpath = "//span[contains(text(),'Tool Tips')]")
    protected WebElement toolTipPage;

    @FindBy(css = "#toolTipButton")
    protected WebElement button;

    @FindBy(css = "#toolTipTextField")
    protected WebElement inputField;

    @FindBy(className = "tooltip-inner")
    protected WebElement hoverText;

    public void navigateToToolTipPage() {
        widgetsCard.click();
        scrollDown();
        waitUntilVisibleAndClick(toolTipPage);
    }


    public void hoverOverButton() throws InterruptedException {
        actions.moveToElement(button).perform();
        Thread.sleep(5000);
        System.out.println(hoverText.getText());
    }

    public void hoverOverInputFieldAndGetText() throws InterruptedException {
        actions.moveToElement(inputField).perform();
        Thread.sleep(5000);
        System.out.println(hoverText.getText());
    }


}
