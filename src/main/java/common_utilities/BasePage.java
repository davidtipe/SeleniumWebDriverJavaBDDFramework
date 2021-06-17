package common_utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Properties;
import static common_utilities.Enums.CHROME;
import static common_utilities.BrowserDirector.get;

public abstract class BasePage {
    protected static WebDriver driver;
    //public static WebDriverManager;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor js;
    protected static Actions actions;
    protected static Alert alert;

    protected static void startDriver()
    {
        driver=get(CHROME);
        wait=new WebDriverWait(driver, 100);
        js=(JavascriptExecutor) driver;
        actions =new Actions (driver);
    }

    protected static String getProperty(String property) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/common_utilities/data.properties");
        prop.load(fis);
        String dataObject = prop.getProperty(property);
        return dataObject;
    }

    protected static void setProperty(String key, String value) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/common_utilities/data.properties");
        prop.load(fis);
        prop.setProperty(key, value);
    }

    protected void goToUrl(String url) throws IOException {
        driver.navigate().to(url);
    }

    protected void waitUntilVisibleAndClick(WebElement ele)
    {
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.click();
    }

    protected void scrollDown(){
        try{
            js.executeScript("window.scrollBy(0,50000)");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void scrollUp(){
        try{
            js.executeScript("window.scrollBy(0,-250)");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void clickAndSendKeys(WebElement ele, String value){
        try{
            ele.click();
            ele.clear();
            ele.sendKeys(value);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void cycleThroughList (List <WebElement> ele, String value) {
        for (WebElement element : ele) {
            if (value.equalsIgnoreCase(element.getText())) {
                element.click();
                break;
            }
        }
    }

    public boolean retryingFindClick(WebElement ele) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                ele.click();
                result = true;
                break;
            } catch(Exception e) {
                e.printStackTrace();
            }
            attempts++;
        }
        return result;
    }


    public void retryingFindClickInList(List <WebElement> ele, String value) {
        int attempts = 0;
        while(attempts < 2) {
            try {
                cycleThroughList(ele, value);
                break;
            } catch(Exception e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }

    protected void doubleClick(WebElement ele){
        actions.doubleClick(ele).perform();
    }

    protected void sendKeysStringWithActionsClass(String value)
    {
        actions.sendKeys(value).perform();
    }

    protected void sendKeyKeysWithActionsClass(Keys value)
    {
        actions.sendKeys(value).perform();
    }

    protected void waitUntilAlertPresent (){
        wait.ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
    }

    protected LocalDate getCurrentDate()
    {
        ZoneId z = ZoneId.of( "Etc/Greenwich" );
        LocalDate today = LocalDate.now( z );
        return today;
    }

    protected String monthToText(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }

    protected void scrollIntoView(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}