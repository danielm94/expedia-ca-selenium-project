package ca.expedia.SeleniumTests.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightsFactory extends CommonFactory {
    private WebDriver driver;

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

    @FindBy(xpath = "//a[@data-testid='travelers-field']")
    private WebElement travelerAnchor;

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

    @FindBy(xpath = "//button[@data-testid='guests-done-button']")
    private WebElement travellersDone;

    @FindBy(xpath = "//div[contains(@class,'adultStepInput')]/div/button[1]")
    private WebElement travellersAdultDec;

    @FindBy(xpath = "//div[contains(@class,'adultStepInput')]/div/button[2]")
    private WebElement travellersAdultInc;

    @FindBy(xpath = "//div[contains(@class,'childStepInput')][1]/div/button[1]")
    private WebElement travellersChildDec;

    @FindBy(xpath = "//div[contains(@class,'childStepInput')][1]/div/button[2]")
    private WebElement travellersChildInc;

    @FindBy(xpath = "//div[contains(@class,'childStepInput')][2]/div/button[1]")
    private WebElement travellersInfantsDec;

    @FindBy(xpath = "//div[contains(@class,'childStepInput')][2]/div/button[2]")
    private WebElement travellersInfantsInc;

    @FindBy(id = "ChildOnLap")
    private WebElement childOnLap;

    @FindBy(id = "ChildInSeat")
    private WebElement childInSeat;

    @FindBy(xpath = "//button[text()='Add another flight']")
    private WebElement addAnotherFlight;

    @FindBy(xpath = "//fieldset[1]//button[@data-stid='location-field-leg1-destination-menu-trigger']")
    private WebElement multiCityFlight1Going;

    @FindBy(xpath = "//fieldset[1]//button[@id='d1-btn']")
    private WebElement multiCityFlight1OpenCalendar;

    @FindBy(id = "airline-age-rules")
    private WebElement airlineAgeRules;

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
    public FlightsFactory(WebDriver driver, ExtentTest test) {
        super(driver, test);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Clicks the departing button so the user may select a check in date from
     * the calendar date picker panel.
     */
    public void clickDeparting() {
        departingButton.click();
        log(LogStatus.INFO, "Clicked on the 'Departing' button.");
    }

    /**
     * Clicks the returning button so the user may select a check out date from
     * the calendar date picker panel.
     */
    public void clickReturning() {
        returningButton.click();
        log(LogStatus.INFO, "Clicked on the 'Returning' button.");
    }

    /**
     * Clicks the "Roundtrip" anchor subtab in the Flights tab.
     */
    public void clickRoundtrip() {
        roundtrip.click();
        log(LogStatus.INFO, "Clicked on the 'Roundtrip' subtab.");
    }

    /**
     * Clicks the "One-way" subtab in the Flights tab.
     */
    public void clickOneWay() {
        oneWay.click();
        log(LogStatus.INFO, "Clicked on the 'One-way' subtab.");
    }

    /**
     * Clicks the "Multi-city" subtab in the Flights tab.
     */
    public void clickMultiCity() {
        multiCity.click();
        log(LogStatus.INFO, "Clicked on the 'Multi-city' subtab.");
    }

    /**
     * Clicks the "Leaving from" button in the Flights tab so that we may send keys
     * to the input.
     */
    public void clickLeavingFrom() {
        leavingFromButton.click();
        log(LogStatus.INFO, "Clicked on the 'Leaving from' button.");
    }

    /**
     * Clicks the "Going to" button in the Flights tab so that we may send keys to
     * the input.
     */
    public void clickGoingTo() {
        goingTo.click();
        log(LogStatus.INFO, "Clicked on the 'Going to' button.");
    }

    /**
     * Clicks the traveler anchor tag so that the user may access the "Travellers"
     * submenu.
     */
    public void clickTraveller() {
        travelerAnchor.click();
        log(LogStatus.INFO, "Clicked on the 'Travellers' button.");
    }

    /**
     * Clicks the preferred class anchor tag in the "Flights" tab so that the user
     * may select which class of fight they wish to book. (Default "Economy")
     */
    public void clickPreferredClass() {
        preferredClass.click();
        log(LogStatus.INFO, "Clicked on the preferred flight class button.");
    }

    /**
     * Clicks the "Economy" menu option in the preferred class drop down menu in the
     * "Flights" tab.
     */
    public void clickEconomy() {
        economy.click();
        log(LogStatus.INFO, "Clicked on the 'Economy' menu option.");
    }

    /**
     * Clicks the "Premium economy" menu option in the preferred class drop down
     * menu in the "Flights" tab.
     */
    public void clickPremiumEconomy() {
        premiumEconomy.click();
        log(LogStatus.INFO, "Clicked on the 'Premium economy' menu option.");
    }

    /**
     * Clicks the "Business class" menu option in the preferred class drop down menu
     * in the "Flights" tab.
     */
    public void clickBusinessClass() {
        businessClass.click();
        log(LogStatus.INFO, "Clicked on the 'Business class' menu option.");
    }

    /**
     * Clicks the "First class" menu option in the preferred class drop down menu in
     * the "Flights" tab.
     */
    public void clickFirstClass() {
        firstClass.click();
        log(LogStatus.INFO, "Clicked on the 'First class' menu option.");
    }

    /**
     * Clears and sends keys to the "Leaving from" input in the flights tab.
     * Requires clicking the input first. (Use clickFlightsLeavingFrom())
     *
     * @param keys Keys that will be entered.
     */
    public void sendKeysLeaving(String keys) {
        leavingFromInput.clear();
        leavingFromInput.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the 'Leaving from' input: " + keys);
    }

    /**
     * Clears and sends keys to the "Going to" input in the flights tab. Requires
     * clicking the input first. (Use clickFlightsGoingTo())
     *
     * @param keys Keys that will be entered.
     */
    public void sendKeysGoing(String keys) {
        goingToInput.clear();
        goingToInput.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the 'Going to' input: " + keys);
    }

    /**
     * Clicks the "Done" button in the "Travellers" panel.
     */
    public void clickTravellersDone() {
        travellersDone.click();
        log(LogStatus.INFO, "Clicked the 'Done' button in the Travellers panel.");
    }

    /**
     * Clicks on the decrease button for adults in the travellers panel.
     */
    public void clickTravellersAdultsDec() {
        travellersAdultDec.click();
        log(LogStatus.INFO, "Clicked the decrease adult count button in the Travellers panel.");
    }

    /**
     * Clicks on the increase button for adults in the travellers panel.
     */
    public void clickTravellersAdultsInc() {
        travellersAdultInc.click();
        log(LogStatus.INFO, "Clicked the increase adult count button in the Travellers panel.");
    }

    /**
     * Clicks on the decrease button for children in the travellers panel.
     */
    public void clickTravellersChildrenDec() {
        travellersChildDec.click();
        log(LogStatus.INFO, "Clicked the decrease child count button in the Travellers panel.");
    }


    /**
     * Clicks on the increase button for children in the travellers panel.
     */
    public void clickTravellersChildrenInc() {
        travellersChildInc.click();
        log(LogStatus.INFO, "Clicked the increase child count button in the Travellers panel.");
    }


    /**
     * Clicks on the decrease button for infants in the travellers panel.
     */
    public void clickTravellersInfantsDec() {
        travellersInfantsDec.click();
        log(LogStatus.INFO, "Clicked the decrease infants count button in the Travellers panel.");
    }


    /**
     * Clicks on the increase button for infants in the travellers panel.
     */
    public void clickTravellersInfantsInc() {
        travellersInfantsInc.click();
        log(LogStatus.INFO, "Clicked the increase infants count button in the Travellers panel.");
    }


    /**
     * Clicks the "On lap" radio button in the travellers panel.
     */
    public void clickTravellersOnLap() {
        childOnLap.click();
        log(LogStatus.INFO, "Clicked the 'On lap' radio button in the travellers panel.");
    }

    /**
     * Clicks the "In seat" radio button in the travellers panel.
     */
    public void clickTravellersInSeat() {
        childInSeat.click();
        log(LogStatus.INFO, "Clicked the 'In seat' radio button in the travellers panel.");
    }

    /**
     * Clicks "Add another flight" in the "Multi-city" subtab in the "Flights" tab.
     */
    public void clickAddAnotherFlight() {
        addAnotherFlight.click();
        log(LogStatus.INFO, "Clicked 'Add another flight' in the 'Multi-city' subtab.");
    }

    /**
     * Sets the age for the specified infant in the travellers panel.
     *
     * @param infant Which infant you'd like to edit. Range: 1-6
     * @param age    The age you'd like to set it to. Range: 0-1, 0 being "Under 1".
     */

    public void selectInfantAge(int infant, int age) {
        Select childAge = getInfantsAgeSelect(infant);
        childAge.selectByIndex(age);
        log(LogStatus.INFO, "Set the age of infant " + infant + " to " + age);
    }

    /**
     * Finds the specified infant age select element in the travellers panel.
     *
     * @param infant The infant number for the select element you wish to find.
     *               Range: 1-6
     * @return The age select element for the specified infant.
     */
    private Select getInfantsAgeSelect(int infant) {
        WebElement element = driver.findElement(By.id("infant-age-input-0-" + (infant - 1)));
        return new Select(element);
    }

    /**
     * Finds the specified child age select element in the travellers panel.
     *
     * @param room  The room number in which the element is located. Range: 1-8
     * @param child The child number. Range: 1-6
     * @return The age select element for the specified child.
     */
    private Select getChildAgeSelect(int room, int child) {
        WebElement element = driver.findElement(By.id("child-age-input-" + (room - 1) + "-" + (child - 1)));
        return new Select(element);
    }

    /**
     * Sets the value of the Child Age drop down menu in the travellers panel.
     *
     * @param child The child number. Range: 1-6
     * @param age   The age to be set. Range: 2-17
     */
    public void selectChildAge(int child, int age) {
        Select childAge = getChildAgeSelect(1, child);
        childAge.selectByIndex(age - 2);
        log(LogStatus.INFO, "Set the age of child " + child + " to " + age);
    }

    /**
     * Finds the "Remove" button for a specified flight in the "Multi-city" subtab
     * in the "Flights" tab.
     *
     * @param flight Which flight you'd like to remove. Range (3-5)
     * @return The "Remove" button as a WebElement.
     */
    private WebElement getRemoveButton(int flight) {
        return driver.findElement(By.xpath("//fieldset[" + flight + "]//button[@id='removeFlightLeg']"));
    }

    /**
     * Clicks the "Remove" button for a specified flight in the "Multi-city" subtab
     * in the "Flights" tab.
     *
     * @param flight Which flight you'd like to remove. Range (3-5). Note that it's
     *               not necessary, for example, to click the remove button under
     *               Flight 5 to remove Flight 5. You may click the remove button
     *               under Flight 3 or Flight 4 and remove Flight 5.
     */

    public void clickRemove(int flight) {
        WebElement element = getRemoveButton(flight);
        element.click();
        log(LogStatus.INFO, "Clicked the remove button for flight " + flight);
    }

    /**
     * Finds the specified "Leaving from" button in the "Multi-city" subtab in the
     * "Flights" tab.
     *
     * @param flight The corresponding flight for the "Leaving from" button we are
     *               looking for. Range (1-5)
     * @return The "Leaving from" button.
     */
    private WebElement getMultiCityLeavingFromButton(int flight) {
        return driver
                .findElement(By.xpath("//button[@data-stid='location-field-leg" + (flight) + "-origin-menu-trigger']"));
    }

    /**
     * Clicks the specified "Leaving from" button in the "Multi-city" subtab in the
     * "Flights" tab.
     *
     * @param flight The corresponding flight for the "Leaving from" button we want
     *               to click. Range (1-5)
     */
    public void clickMultiCityLeavingFrom(int flight) {
        WebElement element = getMultiCityLeavingFromButton(flight);
        element.click();
        log(LogStatus.INFO, "Click the 'Leaving from' button for flight " + flight);
    }

    /**
     * Finds the specified "Going to" button in the "Multi-city" subtab in the
     * "Flights" tab.
     *
     * @param flight The corresponding flight for the "Going to" button we are
     *               looking for. Range (1-5)
     * @return The "Going to" button.
     */
    private WebElement getMultiCityGoingToButton(int flight) {
        return driver.findElement(
                By.xpath("//button[@data-stid='location-field-leg" + (flight) + "-destination-menu-trigger']"));
    }

    /**
     * Clicks the specified "Going to" button in the "Multi-city" subtab in the
     * "Flights" tab.
     *
     * @param flight The corresponding flight for the "Going to" button we want to
     *               click. Range (1-5)
     */
    public void clickMultiCityGoingTo(int flight) {
        WebElement element = getMultiCityGoingToButton(flight);
        element.click();
        log(LogStatus.INFO, "Clicked the 'Going to' button for flight " + flight);
    }

    /**
     * Finds the departing button for a specific flight in the "Multi-city" sub tab
     * in the "Flights" tab.
     *
     * @param flight The relevant flight.
     * @return The "Departing" button as a WebElement.
     */
    private WebElement getMultiCityDepartingButton(int flight) {
        return driver.findElement(By.xpath("//fieldset[" + flight + "]//button[@id='d1-btn']"));
    }

    public void clickMultiCityDeparting(int flight) {
        WebElement element = getMultiCityDepartingButton(flight);
        element.click();
        log(LogStatus.INFO, "Clicked the departing button for flight " + flight);
    }

    /**
     * Finds the specified "Leaving from" input in the "Multi-city" subtab in the
     * "Flights" tab.
     *
     * @param flight The corresponding flight for the "Leaving from" input we are
     *               looking for. Range (1-5)
     * @return The "Leaving from" input.
     */
    private WebElement getMultiCityLeavingFromInput(int flight) {
        return driver.findElement(By.xpath("//input[@id='location-field-leg" + (flight) + "-origin']"));
    }

    /**
     * Sends keys to the specified "Leaving from" input field in the "Multi-city"
     * subtab in the "Flights" tab.
     *
     * @param keys   Keys to be typed in the input.
     * @param flight The flight number corresponding to the input. Range: (1-5)
     */
    public void sendKeysMultiCityLeaving(String keys, int flight) {
        WebElement element = getMultiCityLeavingFromInput(flight);
        element.clear();
        element.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the 'Leaving from' input for flight " + flight + ": " + keys);
    }

    /**
     * Finds the specified "Going to" input in the "Multi-city" subtab in the
     * "Flights" tab.
     *
     * @param flight The corresponding flight for the "Going to" input we are
     *               looking for. Range (1-5)
     * @return The "Going to" input.
     */
    private WebElement getMultiCityGoingToInput(int flight) {
        return driver.findElement(By.xpath("//input[@id='location-field-leg" + (flight) + "-destination']"));
    }

    /**
     * Sends keys to the specified "Going to" input in the "multi-city" subtab in
     * the "Flights" tab.
     *
     * @param keys   The keys you want to type into the input.
     * @param flight The corresponding flight of the input.
     */
    public void sendKeysMultiCityGoing(String keys, int flight) {
        WebElement element = getMultiCityGoingToInput(flight);
        element.clear();
        element.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the 'Going to' input for flight " + flight + ": " + keys);

    }

    /**
     * Clicks the "Airline age rules" hyperlink in the travellers panel.
     */
    public void clickAirlineAgeRules() {
        airlineAgeRules.click();
        log(LogStatus.INFO,"Clicked the 'Airline age rules' hyperlink in the travellers panel");
    }

}
