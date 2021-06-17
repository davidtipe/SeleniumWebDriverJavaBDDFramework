package demoQA.com;

import common_utilities.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Droppable_PageObjects extends BasePage {
    LandingPage_PageObjects lp = new LandingPage_PageObjects();

    public Droppable_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='header-text'])[5]")
    private WebElement interactionsHeader;

    @FindBy(xpath = "//span[contains(text(),'Droppable')]")
    private WebElement droppablePage;

    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement source;

    @FindBy(xpath = "//div[@id='simpleDropContainer']//div[@id='droppable']")
    private WebElement destination;


    public void navigateToDroppable() throws InterruptedException {
        Thread.sleep(2000);
        scrollDown();
        waitUntilVisibleAndClick(interactionsHeader);
        droppablePage.click();
    }

    public void dragAndDropElement() {
        actions.dragAndDropBy(source, 270, 50).build().perform();
        Assert.assertTrue(destination.getText().equalsIgnoreCase("dropped!"));
        System.out.println(destination.getText());
    }
}
