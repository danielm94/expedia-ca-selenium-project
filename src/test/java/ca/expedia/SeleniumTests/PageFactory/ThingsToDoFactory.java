package ca.expedia.SeleniumTests.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThingsToDoFactory extends CommonFactory {

    private WebDriver driver;

    @FindBy(xpath = "//button[@data-stid='location-field-location-menu-trigger']")
    private WebElement thingsToDoInButton;

    @FindBy(id = "location-field-location")
    private WebElement thingsToDoInInput;

    @FindBy(xpath = "//button[@data-testid='submit-button']")
    private WebElement searchButton;

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

    /**
     * Constructor
     *
     * @param driver Driver instance from test class.
     */
    public ThingsToDoFactory(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the "Things to do in" button so that we may send keys to the input.
     */
    public void clickThingsToDoIn() {
        thingsToDoInButton.click();
        log(LogStatus.INFO, "Clicked the 'Things to do in' button.");
    }

    /**
     * Sends keys to the "Things to do in" input so that we may select a location.
     *
     * @param keys The location you wish to search.
     */
    public void sendKeysThingsToDoIn(String keys) {
        thingsToDoInInput.sendKeys(keys);
        log(LogStatus.INFO, "Sent the following keys to the 'Things to do in' input: " + keys);
    }

    /**
     * Clicks the "From" button so that we may open the calendar date picker and
     * select our first date.
     */
    public void clickFromButton() {
        fromButton.click();
        log(LogStatus.INFO,"Clicked the 'From' button.");
    }

    /**
     * Clicks the "To" button so that we may open the calendar date picker and
     * select our second date.
     */
    public void clickToButton() {
        toButton.click();
        log(LogStatus.INFO,"Clicked the 'To' button.");
    }
}
