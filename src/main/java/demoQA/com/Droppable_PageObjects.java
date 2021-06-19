package demoQA.com;

import common_utilities.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class Droppable_PageObjects extends BasePage {

    public Droppable_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='card-body'])[5]")
    protected WebElement interactionsCard;

    @FindBy(xpath = "//span[contains(text(),'Droppable')]")
    protected WebElement droppablePage;

    @FindBy(xpath = "//div[@id='draggable']")
    protected WebElement source;

    @FindBy (xpath = "(//div[@id='droppable']/p)[1]")
    protected WebElement destination;


    public void navigateToDroppable() throws IOException {
        goToUrl(getProperty("url"));
        waitUntilVisibleAndClick(interactionsCard);
        scrollDown();
        droppablePage.click();
    }

    public void dragAndDropElement() throws InterruptedException {
        Thread.sleep(2000);
        actions.dragAndDrop(source, destination).build().perform();
        Assert.assertTrue(destination.getText().equalsIgnoreCase("dropped!"));
        System.out.println(destination.getText());
    }
}
