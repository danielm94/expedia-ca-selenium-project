package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CruisesFactory extends PageFactoryBase {
    private WebDriver driver;
    private long globalTimeOutTime;

    @FindBy(id = "cruise-destination")
    private WebElement goingTo;

    /**
     * This button opens the calendar to select a check in date.
     */
    @FindBy(id = "d1-btn")
    private WebElement departsAsEarlyAsButton;

    /**
     * This button opens the calendar to select a check out date.
     */
    @FindBy(id = "d2-btn")
    private WebElement departsAsLateAsButton;

    /**
     * Constructor
     *
     * @param driver Driver instance from CommonTestBase.
     * @param test   ExtentTest instance from CommonTestBase.
     */
    public CruisesFactory(WebDriver driver, ExtentTest test, long globalTimeOutTime) {
        super(driver, test);
        this.driver = driver;
        this.globalTimeOutTime = globalTimeOutTime;
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects a cruise destination from the "Going to" select.
     *
     * @param destination : The destination you wish to select. Use the exact text for the option you wish to select.
     */
    public void selectCruiseDestination(String destination) {
        Select sel = new Select(waitUntilVisible(goingTo, globalTimeOutTime));
        sel.selectByVisibleText(destination);
        log(LogStatus.INFO, "Set the value of the 'Going to' select to: " + destination);
    }

    /**
     * Clicks the "Departs as early as" button so that we may open the calendar date picker and select our first date.
     */
    public void clickDepartsAsEarlyAs() {
        click(departsAsEarlyAsButton, globalTimeOutTime, "Clicked the 'Departs as early as' button.");
    }

    /**
     * Clicks the "Departs as late as" button so that we may open the calendar date picker and select our second date.
     */
    public void clickDepartsAsLateAs() {
        click(departsAsLateAsButton, globalTimeOutTime, "Clicked the 'Departs as late as' button.");
    }
}
