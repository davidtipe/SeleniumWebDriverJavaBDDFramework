package demoQA.com;

import common_utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;



public class LandingPage_PageObjects extends BasePage {
    public LandingPage_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='card-body'])[1]")
    private WebElement elementCard;

    public void navigateToHomePage() throws IOException {
        goToUrl(getProperty("url"));
        System.out.println("Page title is " + driver.getTitle());
    }

    public void clickElementsCard() {
        scrollDown();
        elementCard.click();
    }

}
