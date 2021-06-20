package demoQA.com;

import common_utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;

public class DatePicker_PageObjects extends BasePage {
    Tooltip_PageObjects tp=new Tooltip_PageObjects();
    public DatePicker_PageObjects() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//span[contains(text(),'Date Picker')]")
    protected WebElement datePickerPage;

    @FindBy (css = "#datePickerMonthYearInput")
    protected WebElement selectDatePiker;

    @FindBy (className = "react-datepicker__month-select")
    protected WebElement month;

    @FindBy (xpath = "//div[@role='option']")
    protected List <WebElement> dayInDatePicker;

    @FindBy (className = "react-datepicker__year-select")
    protected WebElement year;

    public void navigateToDatePickerPage () throws InterruptedException {
        Thread.sleep(500);
        javascriptClick(tp.widgetsCard);
        //waitUntilVisibleAndClick(tp.widgetsCard);
        scrollDown();
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
