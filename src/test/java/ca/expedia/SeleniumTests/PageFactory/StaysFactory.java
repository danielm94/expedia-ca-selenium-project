package ca.expedia.SeleniumTests.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StaysFactory extends CommonFactory {

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

    @FindBy(xpath = "//button[@data-testid='add-room-button']")
    private WebElement travellersAddAnotherRoomButton;

    @FindBy(xpath = "//button[@data-testid='guests-done-button']")
    private WebElement travellersDoneButton;

    @FindBy(xpath = "//button[@data-stid='location-field-origin-menu-trigger']")
    private WebElement leavingFromButton;

    @FindBy(id = "location-field-origin")
    private WebElement leavingFromInput;

    @FindBy(xpath = "//ul[@data-stid='location-field-origin-results']")
    private WebElement leavingFromResultList;

    @FindBy(xpath = "//button[@data-testid='guests-done-button']")
    private WebElement travellersDone;

    @FindBy(xpath = "//button[@data-testid='guests-done-button']/span")
    private WebElement travellersDoneSubText;

    @FindBy(xpath = "//div[@class='uitk-empty-state-body']")
    private WebElement goingToEmptyState;

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
    public StaysFactory(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the "Going to" button in the "Stays" tab so that we can access the input field and send keys to it.
     */
    public void clickGoingTo() {
        goingToButton.click();
        log(LogStatus.INFO, "Clicked on 'Going to'.");
    }

    /**
     * Types the destination into the "Going to" input field. Requires clickStaysGoingToButton() method to be used
     * before.
     *
     * @param destination The destination you wish to search for.
     */
    public void sendKeysGoingTo(String destination) {
        goingToInput.clear();
        goingToInput.sendKeys(destination);
        log(LogStatus.INFO, "Typed '" + destination + "' into the 'Going to' field.");
    }

    /**
     * Clicks the clear button for the going to field.
     */
    public void clickGoingToClear() {
        goingToClearButton.click();
        log(LogStatus.INFO, "Clicked on the X button and cleared the 'Going to' field.");
    }

    /**
     * Clicks the clear button for the going to field.
     */
    public void clickLeavingFromClear() {
        leavingFromClearButton.click();
        log(LogStatus.INFO, "Clicked on the X button and cleared the 'Leaving from' field.");
    }

    /**
     * Clicks the add flight checkbox in the "Stays" tab.
     */
    public void clickAddFlight() {
        addFlightCheckbox.click();
        log(LogStatus.INFO, "Clicked on the 'Add a flight' checkbox.");
    }

    /**
     * Clicks the add car checkbox in the "Stays" tab.
     */
    public void clickAddCar() {
        addCarCheckbox.click();
        log(LogStatus.INFO, "Clicked on the 'Add a car' checkbox");
    }

    /**
     * Clicks the "Check-in" button so the user may open the calendar and select a check in date from the calendar date
     * picker panel. Works for all tabs except for "Multi-city" in flights tab.
     */
    public void clickCheckIn() {
        checkInButton.click();
        log(LogStatus.INFO, "Clicked on the 'Check-in' button");
    }

    /**
     * Clicks the "Check-out" button so the user may open the calendar and select a check out date from the calendar
     * date picker panel. Works for all tabs except for "Multi-city" in flights tab.
     */
    public void clickCheckOut() {
        checkOutButton.click();
        log(LogStatus.INFO, "Clicked on the 'Check-out' button");
    }

    /**
     * Clicks the "Travellers" button to open the travellers submenu in the "Stays" tab.
     */
    public void clickTravellersButton() {
        try {
            WebElement alternativeStaysTravellerButton = driver
                    .findElement(By.xpath("//a[@data-testid='travelers-field']"));
            alternativeStaysTravellerButton.click();
            log(LogStatus.INFO, "Clicked on the 'Travellers' anchor tag.");
        } catch (NoSuchElementException e) {
            WebElement staysTravellerButton = driver
                    .findElement(By.xpath("//button[@data-testid='travelers-field-trigger']"));
            staysTravellerButton.click();
            log(LogStatus.INFO, "Clicked on the 'Travellers' button");
        }
    }

    /**
     * Finds the decrease button for adults in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-8
     * @return Returns the adults decrease button.
     */
    private WebElement getTravellersAdultsDec(int room) {
        return driver.findElement(By
                .xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[1]"));
    }

    /**
     * Finds the increase button for adults in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-8
     * @return Returns the adults increase button.
     */
    private WebElement getTravellersAdultsInc(int room) {
        return driver.findElement(By
                .xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[2]"));
    }

    /**
     * Finds the decrease button for children in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-8
     * @return Returns the children decrease button.
     */
    private WebElement getTravellersChildrenDec(int room) {
        return driver.findElement(By
                .xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'childStepInput')]/div/button[1]"));
    }

    /**
     * Finds the decrease button for children in the Travellers panel.
     *
     * @param room The room number of the element. Range: 1-8
     * @return Returns the children increase button.
     */
    private WebElement getTravellersChildrenInc(int room) {
        return driver.findElement(By
                .xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'childStepInput')]/div/button[2]"));
    }


    /**
     * Finds the remove room button for a specified room in the Travellers panel.
     *
     * @param room The room number of the element. Range: 2-8
     * @return Returns the remove room button.
     */
    private WebElement getTravellersRemoveRoom(int room) {
        return driver.findElement(By.xpath("//div[@data-testid='room-" + room
                + "']/div[@class='removeRoomButton uitk-type-right all-t-padding-four']/button"));
    }

    /**
     * Clicks the add another room button. You may only have a maximum of 8 rooms.
     */
    public void clickTravellersAddRoom() {
        travellersAddAnotherRoomButton.click();
        log(LogStatus.INFO, "Clicked on the 'Add another room button' in the travellers tab.");
    }

    /**
     * Clicks the remove room button. There must be at least 2 rooms available on the travellers panel.
     *
     * @param room The room number of the element. Range: 2-8
     */
    public void clickTravellersRemoveRoom(int room) {
        getTravellersRemoveRoom(room).click();
        log(LogStatus.INFO, "Clicked on the 'Remove room' button for room " + room + ".");
    }

    /**
     * Clicks on the decrease button for adults in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-8
     */
    public void clickTravellersAdultsDec(int room) {
        getTravellersAdultsDec(room).click();
        log(LogStatus.INFO, "Clicked on the '-' button for adults in the travellers panel for room " + room + ".");
    }

    /**
     * Clicks on the increase button for adults in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-8
     */
    public void clickTravellersAdultsInc(int room) {
        getTravellersAdultsInc(room).click();
        log(LogStatus.INFO, "Clicked on the '+' button for adults in the travellers panel for room " + room + ".");
    }

    /**
     * Clicks on the decrease button for children in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-8
     */
    public void clickTravellersChildrenDec(int room) {
        getTravellersChildrenDec(room).click();
        log(LogStatus.INFO, "Clicked on the '-' button for children in the travellers panel for room " + room + ".");
    }

    /**
     * Clicks on the increase button for children in the travellers panel.
     *
     * @param room The room number in which the element is located. Range: 1-8
     */
    public void clickTravellersChildrenInc(int room) {
        getTravellersChildrenInc(room).click();
        log(LogStatus.INFO, "Clicked on the '+' button for children in the travellers panel for room " + room + ".");
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
     * @param room  The room number in which the element is located. Range: 1-8
     * @param child The child number. Range: 1-6
     * @param age   The age to be set. Range: 0-17, 0 being "Under 1"
     */
    public void selectChildAge(int room, int child, int age) {
        Select childAge = getChildAgeSelect(room, child);
        childAge.selectByIndex(age);
        log(LogStatus.INFO, "Set the age of child " + child + " in room " + room + " to " + age);
    }

    /**
     * Clicks the "Leaving from" input so that we may send keys to it. Requires clicking the "Add a flight" checkbox
     * first.
     */
    public void clickLeavingFrom() {
        leavingFromButton.click();
        log(LogStatus.INFO, "Clicked on 'Leaving from'.");
    }

    /**
     * Sends keys to the "Leaving from" input. Requires clicking on the input first, (use clickStaysLeavingFrom())
     */
    public void sendKeysLeavingFrom(String keys) {
        leavingFromInput.clear();
        leavingFromInput.sendKeys(keys);
        log(LogStatus.INFO, "Sent the following keys to the 'Leaving from' input: '" + keys + "'");
    }

    /**
     * Clicks the search button. Usable on all tabs, (stays, cars, flights, etc.)
     */
    public void clickSearch() {
        searchButton.click();
        log(LogStatus.INFO, "Clicked on the search button.");
    }

    /**
     * Clicks the "Done" button in the "Travellers" panel.
     */
    public void clickTravellersDone() {
        travellersDone.click();
        log(LogStatus.INFO, "Clicked on the done button in the 'Travellers' panel.");
    }

    public String getGoingToButtonText() {
        return goingToButton.getText();
    }

    public String getLeavingFromButtonText() {
        return leavingFromButton.getText();
    }

    public String getGoingToPlaceholderText() {
        return goingToInput.getAttribute("placeholder");
    }

    public String getGoingToEmptyStateText() {
        return goingToEmptyState.getText();
    }

    public String getCheckInButtonText() {
        return checkInButton.getText();
    }

    public String getCheckOutButtonText() {
        return checkOutButton.getText();
    }

    public String getTravellersText() {
        try {
            WebElement staysTravellerButton = driver
                    .findElement(By.xpath("//button[@data-testid='travelers-field-trigger']"));
            return staysTravellerButton.getText();

        } catch (NoSuchElementException e) {
            WebElement alternativeStaysTravellerButton = driver
                    .findElement(By.xpath("//a[@data-testid='travelers-field']"));
            return alternativeStaysTravellerButton.getText();
        }
    }

    public String getAddAFlightLabelText() {
        return addAFlightLabel.getText();
    }

    public String getAddACarLabelText() {
        return addACarLabel.getText();
    }

    public String getLeavingFromInputValue() {
        return leavingFromInput.getAttribute("value");
    }

    public String getGoingToInputValue() {
        return goingToInput.getAttribute("value");
    }

    public String getTravellersDoneButtonSubText(){
        return travellersDoneSubText.getText();
    }
    //TODO: Add javadoc
    public Boolean isTravellersPanelDisplayingRooms(int rooms) {
        for (int x = rooms; x > 0; x--) {
            try {
                driver.findElement(By.xpath("//div[@data-testid='room-" + x + "']"));
            } catch (NoSuchElementException e) {
                log(LogStatus.ERROR, "Room " + x + " was not displayed on the travellers panel correctly.");
                return false;
            }
        }
        if (rooms > 1) {
            log(LogStatus.INFO, rooms + " rooms were displayed on the travellers panel correctly.");
        } else {
            log(LogStatus.INFO, rooms + " room was displayed on the travellers panel correctly.");
        }
        return true;
    }
}
