package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StaysFactory extends PageFactoryBase {
    private long globalTimeOutTime;
    private WebDriver driver;
    @FindBy(xpath = "//div[@id='location-field-destination-menu']//button")
    private WebElement goingToButton;

    @FindBy(id = "location-field-destination")
    private WebElement goingToInput;

    @FindBy(xpath = "//ul[@data-stid='location-field-destination-results']")
    private WebElement goingToResultList;

    @FindBy(xpath = "//div[@id='location-field-destination-menu']//button[contains(@class,'uitk-clear-button')]")
    private WebElement goingToClearButton;

    @FindBy(xpath = "//div[@id='location-field-origin-menu']//button[contains(@class,'uitk-clear-button')]")
    private WebElement leavingFromClearButton;

    @FindBy(id = "add-flight-switch")
    private WebElement addFlightCheckbox;

    @FindBy(id = "add-car-switch")
    private WebElement addCarCheckbox;

    @FindBy(xpath = "//button[@data-stid='location-field-origin-menu-trigger']")
    private WebElement leavingFromButton;

    @FindBy(id = "location-field-origin")
    private WebElement leavingFromInput;

    @FindBy(xpath = "//ul[@data-stid='location-field-origin-results']")
    private WebElement leavingFromResultList;

    @FindBy(xpath = "//label[@for='add-flight-switch']")
    private WebElement addAFlightLabel;

    @FindBy(xpath = "//label[@for='add-car-switch']")
    private WebElement addACarLabel;

    /**
     * This button opens the calendar to select a check in date.
     */
    @FindBy(id = "d1-btn")
    private WebElement checkInButton;

    /**
     * This button opens the calendar to select a check out date.
     */
    @FindBy(id = "d2-btn")
    private WebElement checkOutButton;

    /**
     * Constructor
     *
     * @param driver Driver instance from test class.
     */
    public StaysFactory(WebDriver driver, ExtentTest test, long globalTimeOutTime) {
        super(driver, test);
        PageFactory.initElements(driver, this);
        this.globalTimeOutTime = globalTimeOutTime;
        this.driver = driver;
    }

    /**
     * Clicks on the "Going to" button in the "Stays" tab so that we can access the input field and send keys to it.
     */
    public void clickGoingTo() {
        click(goingToButton, globalTimeOutTime, "Clicked on 'Going to'.");
    }

    /**
     * Types the destination into the "Going to" input field. Requires clickStaysGoingToButton() method to be used
     * before.
     *
     * @param destination The destination you wish to search for.
     */
    public void sendKeysGoingTo(String destination) {
        type(goingToInput, globalTimeOutTime, destination, "Typed '" + destination + "' into the 'Going to' field.");
    }

    /**
     * Clicks the clear button for the going to field.
     */
    public void clickGoingToClear() {
        click(goingToClearButton, globalTimeOutTime, "Clicked on the X button and cleared the 'Going to' field.");
    }

    /**
     * Clicks the clear button for the going to field.
     */
    public void clickLeavingFromClear() {
        click(leavingFromClearButton, globalTimeOutTime, "Clicked on the X button and cleared the 'Leaving from' field.");
    }

    /**
     * Clicks the add flight checkbox in the "Stays" tab.
     */
    public void clickAddFlight(Boolean isTheBoxChecked) {
        checkBox(addFlightCheckbox, globalTimeOutTime, isTheBoxChecked, "Clicked on the 'Add a flight' checkbox.");
    }

    /**
     * Clicks the add car checkbox in the "Stays" tab.
     */
    public void clickAddCar(Boolean isTheBoxChecked) {
        checkBox(addCarCheckbox, globalTimeOutTime, isTheBoxChecked, "Clicked on the 'Add a car' checkbox");
    }

    /**
     * Clicks the "Check-in" button so the user may open the calendar and select a check in date from the calendar date
     * picker panel. Works for all tabs except for "Multi-city" in flights tab.
     */
    public void clickCheckIn() {
        click(checkInButton, globalTimeOutTime, "Clicked on the 'Check-in' button");
    }

    /**
     * Clicks the "Check-out" button so the user may open the calendar and select a check out date from the calendar
     * date picker panel. Works for all tabs except for "Multi-city" in flights tab.
     */
    public void clickCheckOut() {
        click(checkOutButton, globalTimeOutTime, "Clicked on the 'Check-out' button");
    }

    /**
     * Clicks the "Leaving from" input so that we may send keys to it. Requires clicking the "Add a flight" checkbox
     * first.
     */
    public void clickLeavingFrom() {
        click(leavingFromButton, globalTimeOutTime, "Clicked on 'Leaving from'.");
    }

    /**
     * Sends keys to the "Leaving from" input. Requires clicking on the input first, (use clickStaysLeavingFrom())
     */
    public void sendKeysLeavingFrom(String keys) {
        type(leavingFromInput, globalTimeOutTime, keys, "Sent the following keys to the 'Leaving from' input: '" + keys + "'");
    }

    /**
     * Returns the visible text of the "Going to" button.
     */
    public String getGoingToButtonText() {
        return getText(goingToButton, globalTimeOutTime, "'Going to' button was found with the following text");
    }

    /**
     * Returns the visible text of the "Leaving from" button.
     */
    public String getLeavingFromButtonText() {
        return getText(leavingFromButton, globalTimeOutTime, "'Leaving from' button was found with the following text");
    }

    /**
     * Returns the placeholder text that is displayed on the "Going to" input when nothing has been entered.
     */
    public String getGoingToInputPlaceholderText() {
        return goingToInput.getAttribute("placeholder");
    }

    /**
     * Returns the visible text of the "Check-in" button.
     */
    public String getCheckInButtonText() {
        return getText(checkInButton, globalTimeOutTime, "'Check in' button was found with the following text");
    }

    /**
     * Returns the visible text of the "Check-out" button.
     */
    public String getCheckOutButtonText() {
        return getText(checkOutButton, globalTimeOutTime, "'Check out' button was found with the following text");
    }

    /**
     * Returns the visible text of the "Add a flight" label.
     */
    public String getAddAFlightLabelText() {
        return getText(addAFlightLabel, globalTimeOutTime, "'Add a flight' label was found with the following text");
    }

    /**
     * Returns the visible text of the "Add a car" label.
     */
    public String getAddACarLabelText() {
        return getText(addACarLabel, globalTimeOutTime, "'Add a car' label was found with the following text");
    }

    /**
     * Returns the text currently displayed in the "Leaving from" input.
     */
    public String getLeavingFromInputValue() {
        return leavingFromInput.getAttribute("value");
    }

    /**
     * Returns the text currently displayed in the "Going to" input.
     */
    public String getGoingToInputValue() {
        return goingToInput.getAttribute("value");
    }
}
