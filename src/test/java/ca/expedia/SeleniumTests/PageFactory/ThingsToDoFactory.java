package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThingsToDoFactory extends PageFactoryBase {

    private long globalTimeOutTime;
    @FindBy(xpath = "//button[@data-stid='location-field-location-menu-trigger']")
    private WebElement thingsToDoInButton;

    @FindBy(id = "location-field-location")
    private WebElement thingsToDoInInput;

    /**
     * This button opens the calendar to select a check in date.
     */
    @FindBy(id = "d1-btn")
    private WebElement fromButton;

    /**
     * This button opens the calendar to select a check out date.
     */
    @FindBy(id = "d2-btn")
    private WebElement toButton;

    public ThingsToDoFactory(WebDriver driver, ExtentTest test, long globalTimeOutTime) {
        super(driver, test);
        this.globalTimeOutTime = globalTimeOutTime;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the "Things to do in" button so that we may send keys to the input.
     */
    public void clickThingsToDoIn() {
        click(thingsToDoInButton, globalTimeOutTime, "Clicked the 'Things to do in' button.");
    }

    /**
     * Sends keys to the "Things to do in" input so that we may select a location.
     *
     * @param keys The location you wish to search.
     */
    public void sendKeysThingsToDoIn(String keys) {
        type(thingsToDoInInput, globalTimeOutTime, keys, "Sent the following keys to the 'Things to do in' input: " + keys);
    }

    /**
     * Clicks the "From" button so that we may open the calendar date picker and select our first date.
     */
    public void clickFromButton() {
        click(fromButton, globalTimeOutTime, "Clicked the 'From' button.");
    }

    /**
     * Clicks the "To" button so that we may open the calendar date picker and select our second date.
     */
    public void clickToButton() {
        click(toButton, globalTimeOutTime, "Clicked the 'To' button.");
    }
}
