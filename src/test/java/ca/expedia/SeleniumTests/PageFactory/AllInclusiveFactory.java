package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllInclusiveFactory extends PageFactoryBase {
    private WebDriver driver;
    private long globalTimeOutTime;

    @FindBy(xpath = "//a[@href='http://allinclusiveforgroups.expedia.ca/en-CA/LandGroup']")
    private WebElement bookFor10;

    /**
     * This button opens the calendar to select a departing date.
     */
    @FindBy(id = "d1-btn")
    private WebElement departingButton;

    /**
     * Constructor
     *
     * @param driver Driver instance from CommonTestBase.
     * @param test   ExtentTest instance from CommonTestBase.
     */
    public AllInclusiveFactory(WebDriver driver, ExtentTest test, long globalTimeOutTime) {
        super(driver, test);
        this.driver = driver;
        this.globalTimeOutTime = globalTimeOutTime;
        PageFactory.initElements(driver, this);
    }

    /**
     * Finds the "Leaving from" drop down menu and returns it as a select.
     *
     * @return "Leaving from" drop down as a select.
     */
    private Select getLeavingFromSelect() {
        WebDriverWait wait = new WebDriverWait(driver, globalTimeOutTime);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='leaving-3pp']/option"), 1));
        return new Select(find(ExpectedConditions.elementToBeClickable((By.id("leaving-3pp"))), globalTimeOutTime));
    }

    /**
     * Selects an option from the "Leaving from" select.
     *
     * @param option : The option you wish to select. Use visible text only.
     */
    public void selectLeavingFrom(String option) {
        Select leavingFromSelect = getLeavingFromSelect();
        leavingFromSelect.selectByVisibleText(option);
        log(LogStatus.INFO, "Set the value of the 'Leaving from' select to: " + option);
    }

    /**
     * Finds the "Going to" drop down menu and returns it as a select.
     *
     * @return "Going to" drop down as a select.
     */
    private Select getGoingToSelect() {
        WebDriverWait wait = new WebDriverWait(driver, globalTimeOutTime);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='going-3pp']/option"), 1));
        return new Select(find(ExpectedConditions.elementToBeClickable((By.id("going-3pp"))), globalTimeOutTime));
    }

    /**
     * Selects an option from the "Going to" select.
     *
     * @param option : The option you wish to select. Use visible text only.
     */
    public void selectGoingTo(String option) {
        Select goingToSelect = getGoingToSelect();
        goingToSelect.selectByVisibleText(option);
        log(LogStatus.INFO, "Set the value of the 'Going to' select to: " + option);
    }

    /**
     * Finds the "Vacation length" drop down menu and returns it as a select.
     *
     * @return "Vacation length" drop down as a select.
     */
    private Select getVacationLengthSelect() {
        return new Select(find(By.id("threepp-duration-select"), globalTimeOutTime));
    }

    /**
     * Selects an option from the "Vacation length" select.
     *
     * @param option : The option you wish to select. Use visible text only.
     */
    public void selectVacationLength(String option) {
        Select vacationLengthSelect = getVacationLengthSelect();
        vacationLengthSelect.selectByVisibleText(option);
        log(LogStatus.INFO, "Set the value of the 'Vacation length' select to: " + option);
    }

    /**
     * Finds the specified child age select element in the travellers panel.
     *
     * @param child The child number. Range: 1-6
     * @return The age select element for the specified child.
     */
    private Select getChildAgeSelect(int child) {
        return new Select(find(By.id("child-age-input-0-" + (child - 1)), globalTimeOutTime));
    }

    /**
     * Sets the value of the Child Age drop down menu in the travellers panel.
     *
     * @param child The child number. Range: 1-6
     * @param age   The age to be set. Range: 0-17, 0 being "Under-1".
     */
    public void selectChildAge(int child, int age) {
        Select childAge = getChildAgeSelect(child);
        childAge.selectByIndex(age);
        log(LogStatus.INFO, "Set the age of child " + child + " to " + age);
    }

    /**
     * Clicks the "Book for 10+ people" hyperlink.
     */
    public void clickBookFor10() {
        click(bookFor10, globalTimeOutTime, "Clicked the 'Book for 10+ people' hyperlink.");
    }

    /**
     * Clicks the departing button so the user may select a check in date from the calendar date picker panel.
     */
    public void clickDeparting() {
        click(departingButton, globalTimeOutTime, "Clicked the 'Departing' button.");
    }
}
