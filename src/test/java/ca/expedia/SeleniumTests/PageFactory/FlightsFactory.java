package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsFactory extends PageFactoryBase {
    private long globalTimeOutTime;

    @FindBy(xpath = "//a[@href='?flightType=roundtrip']")
    private WebElement roundtrip;

    @FindBy(xpath = "//a[@href='?flightType=oneway']")
    private WebElement oneWay;

    @FindBy(xpath = "//a[@href='?flightType=multicity']")
    private WebElement multiCity;

    @FindBy(xpath = "//button[@data-stid='location-field-leg1-origin-menu-trigger']")
    private WebElement leavingFromButton;

    @FindBy(xpath = "//button[@data-stid='location-field-leg1-destination-menu-trigger']")
    private WebElement goingTo;

    @FindBy(id = "preferred-class-input-trigger")
    private WebElement preferredClass;

    @FindBy(xpath = "//a[@role='button']/span[text()='Economy']")
    private WebElement economy;

    @FindBy(xpath = "//a[@role='button']/span[text()='Premium economy']")
    private WebElement premiumEconomy;

    @FindBy(xpath = "//a[@role='button']/span[text()='Business class']")
    private WebElement businessClass;

    @FindBy(xpath = "//a[@role='button']/span[text()='First class']")
    private WebElement firstClass;

    @FindBy(id = "location-field-leg1-origin")
    private WebElement leavingFromInput;

    @FindBy(id = "location-field-leg1-destination")
    private WebElement goingToInput;

    @FindBy(xpath = "//button[text()='Add another flight']")
    private WebElement addAnotherFlight;

    @FindBy(xpath = "//fieldset[1]//button[@data-stid='location-field-leg1-destination-menu-trigger']")
    private WebElement multiCityFlight1Going;

    @FindBy(xpath = "//fieldset[1]//button[@id='d1-btn']")
    private WebElement multiCityFlight1OpenCalendar;

    /**
     * This button opens the calendar to select a departing date.
     */
    @FindBy(id = "d1-btn")
    private WebElement departingButton;

    /**
     * This button opens the calendar to select a returning date.
     */
    @FindBy(id = "d2-btn")
    private WebElement returningButton;

    /**
     * Constructor
     *
     * @param driver Driver instance from test class.
     */
    public FlightsFactory(WebDriver driver, ExtentTest test, long globalTimeOutTime) {
        super(driver, test);
        PageFactory.initElements(driver, this);
        this.globalTimeOutTime = globalTimeOutTime;
    }

    /**
     * Clicks the departing button so the user may select a check in date from the calendar date picker panel.
     */
    public void clickDeparting() {
        click(departingButton, globalTimeOutTime, "Clicked on the 'Departing' button.");
    }

    /**
     * Clicks the returning button so the user may select a check out date from the calendar date picker panel.
     */
    public void clickReturning() {
        click(returningButton, globalTimeOutTime, "Clicked on the 'Returning' button.");
    }

    /**
     * Clicks the "Roundtrip" anchor subtab in the Flights tab.
     */
    public void clickRoundtrip() {
        click(roundtrip, globalTimeOutTime, "Clicked on the 'Roundtrip' subtab.");
    }

    /**
     * Clicks the "One-way" subtab in the Flights tab.
     */
    public void clickOneWay() {
        click(oneWay, globalTimeOutTime, "Clicked on the 'One-way' subtab.");
    }

    /**
     * Clicks the "Multi-city" subtab in the Flights tab.
     */
    public void clickMultiCity() {
        click(multiCity, globalTimeOutTime, "Clicked on the 'Multi-city' subtab.");
    }

    /**
     * Clicks the "Leaving from" button in the Flights tab so that we may send keys to the input.
     */
    public void clickLeavingFrom() {
        click(leavingFromButton, globalTimeOutTime, "Clicked on the 'Leaving from' button.");
    }

    /**
     * Clicks the "Going to" button in the Flights tab so that we may send keys to the input.
     */
    public void clickGoingTo() {
        click(goingTo, globalTimeOutTime, "Clicked on the 'Going to' button.");
    }

    /**
     * Clicks the preferred class anchor tag in the "Flights" tab so that the user may select which class of fight they
     * wish to book. (Default "Economy")
     */
    public void clickPreferredClass() {
        click(preferredClass, globalTimeOutTime, "Clicked on the preferred flight class button.");
    }

    /**
     * Clicks the "Economy" menu option in the preferred class drop down menu in the "Flights" tab.
     */
    public void clickEconomy() {
        click(economy, globalTimeOutTime, "Clicked on the 'Economy' menu option.");
    }

    /**
     * Clicks the "Premium economy" menu option in the preferred class drop down menu in the "Flights" tab.
     */
    public void clickPremiumEconomy() {
        click(premiumEconomy, globalTimeOutTime, "Clicked on the 'Premium economy' menu option.");
    }

    /**
     * Clicks the "Business class" menu option in the preferred class drop down menu in the "Flights" tab.
     */
    public void clickBusinessClass() {
        click(businessClass, globalTimeOutTime, "Clicked on the 'Business class' menu option.");
    }

    /**
     * Clicks the "First class" menu option in the preferred class drop down menu in the "Flights" tab.
     */
    public void clickFirstClass() {
        click(firstClass, globalTimeOutTime, "Clicked on the 'First class' menu option.");
    }

    /**
     * Clears and sends keys to the "Leaving from" input in the flights tab. Requires clicking the input first. (Use
     * clickFlightsLeavingFrom())
     *
     * @param keys Keys that will be entered.
     */
    public void sendKeysLeaving(String keys) {
        type(leavingFromInput, globalTimeOutTime, keys, "Entered the following keys into the 'Leaving from' input: " + keys);
    }

    /**
     * Clears and sends keys to the "Going to" input in the flights tab. Requires clicking the input first. (Use
     * clickFlightsGoingTo())
     *
     * @param keys Keys that will be entered.
     */
    public void sendKeysGoing(String keys) {
        type(goingToInput, globalTimeOutTime, keys, "Entered the following keys into the 'Going to' input: " + keys);
    }

    /**
     * Clicks "Add another flight" in the "Multi-city" subtab in the "Flights" tab.
     */
    public void clickAddAnotherFlight() {
        click(addAnotherFlight, globalTimeOutTime, "Clicked 'Add another flight' in the 'Multi-city' subtab.");
    }

    /**
     * Finds the "Remove" button for a specified flight in the "Multi-city" subtab in the "Flights" tab.
     *
     * @param flight Which flight you'd like to remove. Range (3-5)
     * @return The "Remove" button as a WebElement.
     */
    private WebElement getRemoveButton(int flight) {
        return find(By.xpath("//fieldset[" + flight + "]//button[@id='removeFlightLeg']"), globalTimeOutTime);
    }

    /**
     * Clicks the "Remove" button for a specified flight in the "Multi-city" subtab in the "Flights" tab.
     *
     * @param flight Which flight you'd like to remove. Range (3-5). Note that it's not necessary, for example, to click
     *               the remove button under Flight 5 to remove Flight 5. You may click the remove button under Flight 3
     *               or Flight 4 and remove Flight 5.
     */

    public void clickRemove(int flight) {
        click(getRemoveButton(flight), globalTimeOutTime, "Clicked the remove button for flight " + flight);
    }

    /**
     * Finds the specified "Leaving from" button in the "Multi-city" subtab in the "Flights" tab.
     *
     * @param flight The corresponding flight for the "Leaving from" button we are looking for. Range (1-5)
     * @return The "Leaving from" button.
     */
    private WebElement getMultiCityLeavingFromButton(int flight) {
        return find(By.xpath("//button[@data-stid='location-field-leg" + (flight) + "-origin-menu-trigger']"), globalTimeOutTime);
    }

    /**
     * Clicks the specified "Leaving from" button in the "Multi-city" subtab in the "Flights" tab.
     *
     * @param flight The corresponding flight for the "Leaving from" button we want to click. Range (1-5)
     */
    public void clickMultiCityLeavingFrom(int flight) {
        click(getMultiCityLeavingFromButton(flight), globalTimeOutTime, "Click the 'Leaving from' button for flight " + flight);
    }

    /**
     * Finds the specified "Going to" button in the "Multi-city" subtab in the "Flights" tab.
     *
     * @param flight The corresponding flight for the "Going to" button we are looking for. Range (1-5)
     * @return The "Going to" button.
     */
    private WebElement getMultiCityGoingToButton(int flight) {
        return find(By.xpath("//button[@data-stid='location-field-leg" + (flight) + "-destination-menu-trigger']"), globalTimeOutTime);
    }

    /**
     * Clicks the specified "Going to" button in the "Multi-city" subtab in the "Flights" tab.
     *
     * @param flight The corresponding flight for the "Going to" button we want to click. Range (1-5)
     */
    public void clickMultiCityGoingTo(int flight) {
        click(getMultiCityGoingToButton(flight), globalTimeOutTime, "Clicked the 'Going to' button for flight " + flight);
    }

    /**
     * Finds the departing button for a specific flight in the "Multi-city" sub tab in the "Flights" tab.
     *
     * @param flight The relevant flight.
     * @return The "Departing" button as a WebElement.
     */
    private WebElement getMultiCityDepartingButton(int flight) {
        return find(By.xpath("//fieldset[" + flight + "]//button[@id='d1-btn']"), globalTimeOutTime);
    }

    public void clickMultiCityDeparting(int flight) {
        click(getMultiCityDepartingButton(flight), globalTimeOutTime, "Clicked the departing button for flight " + flight);
    }

    /**
     * Finds the specified "Leaving from" input in the "Multi-city" subtab in the "Flights" tab.
     *
     * @param flight The corresponding flight for the "Leaving from" input we are looking for. Range (1-5)
     * @return The "Leaving from" input.
     */
    private WebElement getMultiCityLeavingFromInput(int flight) {
        return find(By.xpath("//input[@id='location-field-leg" + (flight) + "-origin']"), globalTimeOutTime);
    }

    /**
     * Sends keys to the specified "Leaving from" input field in the "Multi-city" subtab in the "Flights" tab.
     *
     * @param keys   Keys to be typed in the input.
     * @param flight The flight number corresponding to the input. Range: (1-5)
     */
    public void sendKeysMultiCityLeaving(String keys, int flight) {
        type(getMultiCityLeavingFromInput(flight), globalTimeOutTime, keys,
                "Entered the following keys into the 'Leaving from' input for flight " + flight + ": " + keys);
    }

    /**
     * Finds the specified "Going to" input in the "Multi-city" subtab in the "Flights" tab.
     *
     * @param flight The corresponding flight for the "Going to" input we are looking for. Range (1-5)
     * @return The "Going to" input.
     */
    private WebElement getMultiCityGoingToInput(int flight) {
        return find(By.xpath("//input[@id='location-field-leg" + (flight) + "-destination']"), globalTimeOutTime);
    }

    /**
     * Sends keys to the specified "Going to" input in the "multi-city" subtab in the "Flights" tab.
     *
     * @param keys   The keys you want to type into the input.
     * @param flight The corresponding flight of the input.
     */
    public void sendKeysMultiCityGoing(String keys, int flight) {
        type(getMultiCityGoingToInput(flight), globalTimeOutTime, keys,
                "Entered the following keys into the 'Going to' input for flight " + flight + ": " + keys);
    }
}
