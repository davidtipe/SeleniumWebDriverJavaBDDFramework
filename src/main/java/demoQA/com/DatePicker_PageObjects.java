package demoQA.com;

import common_utilities.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DatePicker_PageObjects extends BasePage {
    LandingPage_PageObjects lp=new LandingPage_PageObjects();
    public DatePicker_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="(//div[@class='header-text'])[4]")
    private WebElement widgetsHeader;

    @FindBy (xpath="//span[contains(text(),'Date Picker')]")
    private WebElement datePickerPage;

    @FindBy (css = "#datePickerMonthYearInput")
    private WebElement selectDatePiker;

    @FindBy (className = "react-datepicker__month-select")
    private WebElement month;

    @FindBy (xpath = "//div[@role='option']")
    private List <WebElement> dayInDatePicker;

    @FindBy (xpath = "//div[@role='option']")
    private WebElement day;

    @FindBy (className = "react-datepicker__year-select")
    private WebElement year;

    public void navigateToDatePickerPage ()
    {
        lp.clickElementsCard();
        scrollDown();
        waitUntilVisibleAndClick(widgetsHeader);
        datePickerPage.click();
    }

    public void selectPlusOneMonth()
    {
        LocalDate today = getCurrentDate();
        LocalDate oneMonthLater = today.plusMonths( 1 );

        String date=oneMonthLater.toString();
        String day=date.split("-")[2];
        String month=date.split("-")[1];
        String year=date.split("-")[0];

        month=monthToText(Integer.parseInt(month));

        selectDatePiker.click();

        this.month.click();
        Select selectMonth=new Select(this.month);
        selectMonth.selectByVisibleText(month);

        this.year.click();
        Select selectYear=new Select(this.year);
        selectYear.selectByVisibleText(year);

        cycleThroughList(this.dayInDatePicker, day);

    }
}
