package ca.expedia.SeleniumTests.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VacationFactory extends CommonFactory {
    private WebDriver driver;

    @FindBy(xpath = "//label[@for='package-pills-hotels']")
    private WebElement staysSubTab;

    @FindBy(xpath = "//label[@for='package-pills-flights']")
    private WebElement flightsSubTab;

    @FindBy(xpath = "//label[@for='package-pills-cars']")
    private WebElement carsSubTab;

    @FindBy(xpath = "//button[@data-stid='location-field-origin-menu-trigger']")
    private WebElement leavingFromButton;

    @FindBy(id = "location-field-origin")
    private WebElement leavingFromInput;

    @FindBy(xpath = "//button[@data-stid='location-field-destination-menu-trigger']")
    private WebElement goingToButton;

    @FindBy(id = "location-field-destination")
    private WebElement goingToInput;

    @FindBy(xpath = "//button[@id='d1-btn' and contains(@aria-label,'Departing')]")
    private WebElement departingButton;

    @FindBy(xpath = "//button[@id='d2-btn' and contains(@aria-label,'Returning')]")
    private WebElement returningButton;

    @FindBy(xpath = "//button[@id='d1-btn' and contains(@aria-label,'Check-in')]")
    private WebElement checkInButton;

    @FindBy(xpath = "//button[@id='d2-btn' and contains(@aria-label,'Check-out')]")
    private WebElement checkOutButton;

    @FindBy(id = "package-partial-stay")
    private WebElement partAccommodations;

    @FindBy(id = "preferred-class-input-trigger")
    private WebElement prefferedClassAnchor;

    @FindBy(xpath = "//a[@role='button']/span[text()='Economy']")
    private WebElement economy;

    @FindBy(xpath = "//a[@role='button']/span[text()='Premium economy']")
    private WebElement premiumEconomy;

    @FindBy(xpath = "//a[@role='button']/span[text()='Business class']")
    private WebElement businessClass;

    @FindBy(xpath = "//a[@role='button']/span[text()='First class']")
    private WebElement firstClass;

    @FindBy(xpath = "//a[@data-testid='travelers-field']")
    private WebElement travelerAnchor;

    @FindBy(xpath = "//button[@data-testid='add-room-button']")
    private WebElement travellersAddAnotherRoom;

    @FindBy(id = "ChildInSeat")
    private WebElement childInSeat;

    @FindBy(id = "ChildOnLap")
    private WebElement childOnLap;

    @FindBy(id = "airline-age-rules")
    private WebElement airlineAgeRules;

    @FindBy(xpath = "//button[@data-testid='guests-done-button']")
    private WebElement travellersDone;

    /**
     * Constructor
     *
     * @param driver Driver instance from test class.
     */
    public VacationFactory(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the "Stays" pill subtab.
     */
    public void clickStaysSubTab() {
        staysSubTab.click();
        log(LogStatus.INFO, "Clicked on the 'Stays' subtab.");
    }

    /**
     * Clicks the "Flights" pill subtab.
     */
    public void clickFlightsSubTab() {
        flightsSubTab.click();
        log(LogStatus.INFO, "Clicked on the 'Flights' subtab.");
    }

    /**
     * Clicks the "Cars" pill subtab.
     */
    public void clickCarsSubTab() {
        carsSubTab.click();
        log(LogStatus.INFO, "Clicked on the 'Cars' subtab.");
    }

    /**
     * Clicks the "Leaving from" button so that we may send keys to its input.
     */
    public void clickLeavingFrom() {
        leavingFromButton.click();
        log(LogStatus.INFO, "Clicked on the 'Leaving from' button.");
    }

    /**
     * Sends keys to the "Leaving from" input. Requires clicking the "Leaving from"
     * button first, (use <b>clickLeavingFrom()</b>)
     */
    public void sendKeysLeavingFrom(String keysToSend) {
        leavingFromInput.clear();
        leavingFromInput.sendKeys(keysToSend);
        log(LogStatus.INFO, "Sent the following keys to the 'Leaving from' input: " + keysToSend);
    }

    /**
     * Clicks the "Going to" button so that we may send keys to its input.
     */
    public void clickGoingTo() {
        goingToButton.click();
        log(LogStatus.INFO, "Clicked on the 'Going to' button.");
    }

    /**
     * Sends keys to the "Going to" input. Requires clicking the "Going to" button
     * first, (use <b>clickGoingTo()</b>)
     */
    public void sendKeysGoingTo(String keysToSend) {
        goingToInput.clear();
        goingToInput.sendKeys(keysToSend);
        log(LogStatus.INFO, "Sent the following keys to the 'Going to' input: " + keysToSend);
    }

    /**
     * Clicks the preferred class anchor tag in the "Vacation packages" tab so that
     * the user may select which class of fight they wish to book. (Default
     * "Economy")
     */
    public void clickPreferredClass() {
        prefferedClassAnchor.click();
        log(LogStatus.INFO, "Clicked on the preferred class button.");
    }

    /**
     * Clicks the "Economy" menu option in the preferred class drop down menu in the
     * "Vacation packages" tab.
     */
    public void clickEconomy() {
        economy.click();
        log(LogStatus.INFO, "Clicked on the 'Economy' menu option.");
    }

    /**
     * Clicks the "Premium economy" menu option in the preferred class drop down
     * menu in the "Vacation packages" tab.
     */
    public void clickPremiumEconomy() {
        premiumEconomy.click();
        log(LogStatus.INFO, "Clicked on the 'Premium economy' menu option.");
    }

    /**
     * Clicks the "Business class" menu option in the preferred class drop down menu
     * in the "Vacation packages" tab.
     */
    public void clickBusinessClass() {
        businessClass.click();
        log(LogStatus.INFO, "Clicked on the 'Business Class' menu option.");
    }

    /**
     * Clicks the "First class" menu option in the preferred class drop down menu in
     * the "Vacation packages" tab.
     */
    public void clickFirstClass() {
        firstClass.click();
        log(LogStatus.INFO, "Clicked on the 'First Class' menu option.");
    }

    /**
     * Clicks the traveler anchor tag so that the user may access the "Travellers"
     * submenu.
     */
    public void clickTraveler() {
        travelerAnchor.click();
        log(LogStatus.INFO, "Clicked on the 'Travellers' button.");
    }

    /**
     * Finds the decrease button for adults in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-6
     * @return Returns the adults decrease button.
     */
    private WebElement getTravellersAdultsDec(int room) {
        return driver.findElement(By
                .xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[1]"));
    }

    /**
     * Finds the increase button for adults in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-6
     * @return Returns the adults increase button.
     */
    private WebElement getTravellersAdultsInc(int room) {
        return driver.findElement(By
                .xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[2]"));
    }

    /**
     * Finds the decrease button for children in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-6
     * @return Returns the children decrease button.
     */
    private WebElement getTravellersChildrenDec(int room) {
        return driver.findElement(By.xpath("//div[@data-testid='room-" + room
                + "']/div[descendant::label[@for='child-input-" + (room - 1) + "']]/div/button[1]"));
    }

    /**
     * Finds the decrease button for children in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-6
     * @return Returns the children increase button.
     */
    private WebElement getTravellersChildrenInc(int room) {
        return driver.findElement(By.xpath("//div[@data-testid='room-" + room
                + "']/div[descendant::label[@for='child-input-" + (room - 1) + "']]/div/button[2]"));
    }

    /**
     * Finds the decrease button for infants in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-6
     * @return Returns the infants decrease button.
     */
    private WebElement getTravellersInfantsDec(int room) {
        return driver.findElement(By.xpath("//div[@data-testid='room-" + room
                + "']/div[descendant::label[@for='infant-input-" + (room - 1) + "']]/div/button[1]"));
    }

    /**
     * Finds the decrease button for infants in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-6
     * @return Returns the infants increase button.
     */
    private WebElement getTravellersInfantsInc(int room) {
        return driver.findElement(By.xpath("//div[@data-testid='room-" + room
                + "']/div[descendant::label[@for='infant-input-" + (room - 1) + "']]/div/button[2]"));
    }

    /**
     * Finds the remove room button for a specified room in the Travellers panel.
     *
     * @param room The room number of the element. Range: 2-6
     * @return Returns the remove room button.
     */
    private WebElement getTravellersRemoveRoom(int room) {
        return driver.findElement(By.xpath("//div[@data-testid='room-" + room
                + "']/div[@class='removeRoomButton uitk-type-right all-t-padding-four']/button"));
    }

    /**
     * Clicks the add another room button. You may only have a maximum of 6 rooms.
     */
    public void clickTravellersAddRoom() {
        travellersAddAnotherRoom.click();
        log(LogStatus.INFO, "Clicked on the 'Add another room' button.");
    }

    /**
     * Clicks the remove room button. There must be at least 2 rooms available on
     * the travellers panel.
     *
     * @param room The room number of the element. Range: 2-6
     */
    public void clickTravellersRemoveRoom(int room) {
        getTravellersRemoveRoom(room).click();
        log(LogStatus.INFO, "Clicked on the 'Remove room' button.");
    }

    /**
     * Clicks on the decrease button for adults in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-6
     */
    public void clickTravellersAdultsDec(int room) {
        getTravellersAdultsDec(room).click();
        log(LogStatus.INFO, "Clicked on the decrease button for adults in the travellers panel for room " + room);
    }

    /**
     * Clicks on the increase button for adults in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-6
     */
    public void clickTravellersAdultsInc(int room) {
        getTravellersAdultsInc(room).click();
        log(LogStatus.INFO, "Clicked on the increase button for adults in the travellers panel for room " + room);
    }

    /**
     * Clicks on the decrease button for children in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-6
     */
    public void clickTravellersChildrenDec(int room) {
        getTravellersChildrenDec(room).click();
        log(LogStatus.INFO, "Clicked on the decrease button for children in the travellers panel for room " + room);
    }

    /**
     * Clicks on the increase button for children in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-6
     */
    public void clickTravellersChildrenInc(int room) {
        getTravellersChildrenInc(room).click();
        log(LogStatus.INFO, "Clicked on the increase button for children in the travellers panel for room " + room);
    }

    /**
     * Clicks on the decrease button for infants in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-6
     */
    public void clickTravellersInfantsDec(int room) {
        getTravellersInfantsDec(room).click();
        log(LogStatus.INFO, "Clicked on the decrease button for infants in the travellers panel for room " + room);
    }

    /**
     * Clicks on the increase button for infants in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-6
     */
    public void clickTravellersInfantsInc(int room) {
        getTravellersInfantsInc(room).click();
        log(LogStatus.INFO, "Clicked on the increase button for infants in the travellers panel for room " + room);
    }

    /**
     * Finds the specified child age select element in the travellers panel.
     *
     * @param room  The room number in which the element is located. Range: 1-6
     * @param child The child number. Range: 1-6
     * @return The age select element for the specified child.
     */
    private Select getChildAgeSelect(int room, int child) {
        WebElement element = driver.findElement(By.id("child-age-input-" + (room - 1) + "-" + (child - 1)));
        return new Select(element);
    }

    /**
     * Finds the specified infant age select element in the travellers panel.
     *
     * @param room   The room number in which the element is located. Range: 1-6
     * @param infant The infant number. Range: 1-6
     * @return The age select element for the specified infant.
     */
    private Select getInfantAgeSelect(int room, int infant) {
        WebElement element = driver.findElement(By.id("infant-age-input-" + (room - 1) + "-" + (infant - 1)));
        return new Select(element);
    }

    /**
     * Sets the value of the Child Age select in the travellers panel.
     *
     * @param room  The room number in which the element is located. Range: 1-6
     * @param child The child number. Range: 1-6
     * @param age   The age to be set. Range: 2-17.
     */
    public void selectChildAge(int room, int child, String age) {
        Select childAge = getChildAgeSelect(room, child);
        childAge.selectByValue(age);
        log(LogStatus.INFO, "Set the age of child " + child + " to " + age + " for room " + room + ".");
    }

    /**
     * Sets the value of the Infant Age select in the travellers panel.
     *
     * @param room   The room number in which the element is located. Range: 1-6
     * @param infant The child number. Range: 1-6
     * @param age    The age to be set. Range: 0-1, 0 being "Under 1"
     */
    public void selectInfantAge(int room, int infant, int age) {
        Select infantAge = getInfantAgeSelect(room, infant);
        infantAge.selectByIndex(age);
        log(LogStatus.INFO, "Set the age of infant " + infant + " to " + age + " for room " + room + ".");
    }

    /**
     * Clicks the "Airline age rules" hyperlink in the travellers panel.
     */
    public void clickAirlineAgeRules() {
        airlineAgeRules.click();
        log(LogStatus.INFO, "Clicked on the 'Airline age rules' hyperlink.");
    }

    /**
     * Clicks the "I only need accommodations for part of my trip" checkbox.
     */
    public void clickAccommodationsCheckbox() {
        partAccommodations.click();
        log(LogStatus.INFO, "Clicked the 'I only need accommodations for part of my trip' checkbox.");
    }

    /**
     * Clicks the "Departing" button so the user can access the calendar date picker
     * panel.
     */
    public void clickDepartingButton() {
        departingButton.click();
        log(LogStatus.INFO, "Clicked the 'Departing' button.");
    }

    /**
     * Clicks the "Returning" button so the user can access the calendar date picker
     * panel.
     */
    public void clickReturningButton() {
        returningButton.click();
        log(LogStatus.INFO, "Clicked the 'Returning' button.");
    }

    /**
     * Clicks the "Check-in" button so the user can access the calendar date picker
     * panel.
     */
    public void clickCheckIn() {
        checkInButton.click();
        log(LogStatus.INFO, "Clicked the 'Check-in' button.");
    }

    /**
     * Clicks the "Check-out" button so the user can access the calendar date picker
     * panel.
     */
    public void clickCheckOut() {
        checkOutButton.click();
        log(LogStatus.INFO, "Clicked the 'Check-out' button.");
    }

    /**
     * Gets the count for Adults in the "Travellers" panel for the specified room.
     *
     * @param room The respective room the counter is located in. Range: (1-6)
     * @return The count for Adults as an integer.
     */
    public int getTravellerAdultCount(int room) {
        WebElement adultCount = driver.findElement(By.id("adult-input-" + (room - 1)));
        return Integer.parseInt(adultCount.getAttribute("value"));
    }

    /**
     * Gets the count for Children in the "Travellers" panel for the specified room.
     *
     * @param room The respective room the counter is located in. Range: (1-6)
     * @return The count for Children as an integer.
     */
    public int getTravellerChildCount(int room) {
        WebElement childCount = driver.findElement(By.id("child-input-" + (room - 1)));
        return Integer.parseInt(childCount.getAttribute("value"));
    }

    /**
     * Gets the count for Infants in the "Travellers" panel for the specified room.
     *
     * @param room The respective room the counter is located in. Range: (1-6)
     * @return The count for Infants as an integer.
     */
    public int getTravellerInfantCount(int room) {
        WebElement childCount = driver.findElement(By.id("infant-input-" + (room - 1)));
        return Integer.parseInt(childCount.getAttribute("value"));
    }

    /**
     * Clicks the "On lap" radio button in the "Travellers" panel.
     */
    public void clickChildOnLap() {
        childOnLap.click();
        log(LogStatus.INFO, "Clicked the 'On lap' radio button.");
    }

    /**
     * Clicks the "In seat" radio button in the "Travellers" panel.
     */
    public void clickChildInSeat() {
        childInSeat.click();
        log(LogStatus.INFO, "Clicked the 'In seat' radio button.");
    }

    /**
     * Clicks the "Done" button in the "Travellers" panel.
     */
    public void clickTravellersDone() {
        travellersDone.click();
        log(LogStatus.INFO, "Clicked the 'Done' button in the 'Travellers' panel.");
    }
}
