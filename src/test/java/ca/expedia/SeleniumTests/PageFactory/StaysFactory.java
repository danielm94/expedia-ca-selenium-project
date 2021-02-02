package ca.expedia.SeleniumTests.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    @FindBy(xpath = "//label[@for='add-flight-switch']")
    private WebElement addAFlightLabel;

    @FindBy(xpath = "//label[@for='add-car-switch']")
    private WebElement addACarLabel;

    @FindBy(xpath = "//h3[text()='Travellers']")
    private WebElement travellersMenuHeader;

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

    @FindBy(xpath = "//div[@data-testid='lob-error-summary']/div/h3")
    private WebElement travellersErrorMessage;

    /**
     * Constructor
     *
     * @param driver Driver instance from test class.
     */
    public StaysFactory(WebDriver driver, ExtentTest test) {
        super(driver,test);
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

    /**
     * Returns the visible text of the "Going to" button.
     */
    public String getGoingToButtonText() {
        return goingToButton.getText();
    }

    /**
     * Returns the visible text of the "Leaving from" button.
     */
    public String getLeavingFromButtonText() {
        return leavingFromButton.getText();
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
        return checkInButton.getText();
    }

    /**
     * Returns the visible text of the "Check-out" button.
     */
    public String getCheckOutButtonText() {
        return checkOutButton.getText();
    }

    /**
     * Returns the visible text of the "Travellers" button.
     */
    public String getTravellersButtonText() {
        try {
            return driver.findElement(By.xpath("//button[@data-testid='travelers-field-trigger']")).getText();
        } catch (NoSuchElementException e) {
            return driver.findElement(By.xpath("//a[@data-testid='travelers-field']")).getText();
        }
    }

    /**
     * Returns the visible text of the "Add a flight" label.
     */
    public String getAddAFlightLabelText() {
        return addAFlightLabel.getText();
    }

    /**
     * Returns the visible text of the "Add a car" label.
     */
    public String getAddACarLabelText() {
        return addACarLabel.getText();
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

    /**
     * Returns the visible text of the "Done" button in the travellers panel.
     */
    public String getTravellersDoneButtonText() {
        return travellersDoneButton.getText();
    }

    /**
     * Returns the visible text of the "Travellers" header in the travellers panel.
     */
    public String getTravellersPanelHeaderText() {
        return travellersMenuHeader.getText();
    }

    /**
     * Returns the visible text of a specific "Room" header.
     *
     * @param room The room which the "Room" header you are looking for is in. Range: 1-8
     */

    public String getTravellersRoomHeaderText(int room) {
        return driver.findElement((By.xpath("//div[@data-testid='room-" + room + "']/h3/span"))).getText();
    }

    /**
     * Returns the visible text of a specific "Adults" label.
     *
     * @param room The room which the "Adults" label you are looking for is in. Range: 1-8
     */
    public String getTravellersAdultsLabelText(int room) {
        return driver.findElement(By.xpath("//label[@for='adult-input-" + (room - 1) + "']")).getText();
    }

    /**
     * Returns the visible text of a specific "Children" label.
     *
     * @param room The room which the "Children" label you are looking for is in. Range: 1-8
     */
    public String getTravellersChildrenLabelText(int room) {
        return driver.findElement(By.xpath("//label[@for='child-input-" + (room - 1) + "']")).getText();
    }

    /**
     * Returns the visible text of the label displayed above the selected option on a Child select element.
     *
     * @param room  The room which the label is located in. Range 1-8
     * @param child The specific child select which contains the label. Range: 1-6
     */
    public String getTravellersChildSelectLabelText(int room, int child) {
        return driver.findElement(By.xpath("//label[@for='child-age-input-" + (room - 1) + "-" + (child - 1) + "']")).getText();
    }

    /**
     * Returns the selected option of a child select element.
     *
     * @param room  The room which the child select element is in. Range: 1-8
     * @param child The specific child select. Range 1-6
     */
    public String getTravellersChildSelectedText(int room, int child) {
        return getChildAgeSelect(room, child).getFirstSelectedOption().getText();
    }

    /**
     * Returns the "Adults" count.
     *
     * @param room The specific room which the counter is located. Range: 1-8
     */
    public String getTravellersAdultsCount(int room) {
        return driver.findElement(By.id("adult-input-" + (room - 1))).getAttribute("value");
    }

    /**
     * Returns the "Children" count.
     *
     * @param room The specific room which the counter is located. Range: 1-8
     */
    public String getTravellersChildCount(int room) {
        return driver.findElement(By.id("child-input-" + (room - 1))).getAttribute("value");
    }

    /**
     * Returns the visible text of the "Add another room" button.
     */
    public String getTravellersAddAnotherRoomText() {
        return travellersAddAnotherRoomButton.getText();
    }

    /**
     * Returns the visible text of the "Remove room" button.
     *
     * @param room The specific room in which the element is located in. Range: 2-8
     */
    public String getTravellersRemoveRoomButtonText(int room) {
        return getTravellersRemoveRoom(room).getText();
    }

    /**
     * Returns the visible text of the error message that is displayed when you try to book more than 14 people.
     */
    public String getTravellersErrorMessageText() {
        return travellersErrorMessage.getText();
    }

    /**
     * Checks that a specific child select element is displaying the correct options.
     *
     * @param room            The room in which the child select is located. Range 1-8
     * @param child           The specific child select we are checking. Range 1-6
     * @param expectedOptions What options the child select should have.
     * @return True if all the options are correct, else false.
     */
    public Boolean isChildSelectListingCorrectOptions(int room, int child, String[] expectedOptions) {
        List<WebElement> actualOptions = getChildAgeSelect(room, child).getOptions();
        for (int x = 0; x < actualOptions.size(); x++) {
            if (!actualOptions.get(x).getText().equals(expectedOptions[x])) {
                log(LogStatus.ERROR, "The available options of child select element " + child + " room " + room + " did not contain the expected options.");
                return false;
            }
        }
        return true;
    }
}
