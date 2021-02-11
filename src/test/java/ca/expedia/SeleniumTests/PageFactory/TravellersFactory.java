package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TravellersFactory extends PageFactoryBase {
    private WebDriver driver;
    private long globalTimeOutTime;
    @FindBy(xpath = "//div[@data-testid='lob-error-summary']/div/h3")
    private WebElement travellersErrorMessage;
    @FindBy(xpath = "//h3[text()='Travellers']")
    private WebElement travellersMenuHeader;
    @FindBy(xpath = "//button[@data-testid='guests-done-button']/span")
    private WebElement travellersDoneSubText;
    @FindBy(xpath = "//button[@data-testid='add-room-button']")
    private WebElement travellersAddAnotherRoomButton;
    @FindBy(xpath = "//button[@data-testid='guests-done-button']")
    private WebElement travellersDoneButton;
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
    @FindBy(id = "airline-age-rules")
    private WebElement airlineAgeRules;


    public TravellersFactory(WebDriver driver, ExtentTest test, long globalTimeOutTime) {
        super(driver, test);
        this.driver = driver;
        this.globalTimeOutTime = globalTimeOutTime;
        PageFactory.initElements(driver, this);
    }


    /**
     * Clicks the "Travellers" button to open the travellers submenu.
     */
    public void clickTravellersButton() {
        if (!waitUntilClickable(By.xpath("//button[@data-testid='travelers-field-trigger']"), globalTimeOutTime, "Clicked on the 'Travellers' button")) {
            log(LogStatus.INFO, "Travellers button was not available, attempting to click anchor tag instead.");
            click(By.xpath("//a[@data-testid='travelers-field']"), globalTimeOutTime, "Clicked on the 'Travellers' anchor tag.");
        }
    }

    /**
     * Clicks on the 'Travellers' anchor tag to open the travellers submenu.
     */
    public void clickTravellersAnchorTag() {
        click(By.xpath("//a[@data-testid='travelers-field']"), globalTimeOutTime, "Clicked on the 'Travellers' anchor tag.");
    }

    /**
     * Finds the decrease button for adults in the Travellers panel.
     *
     * @param room The room number of the element.
     * @return Returns the adults decrease button.
     */
    private WebElement getAdultsDecreaseButton(int room) {
        return find(By.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[1]"), globalTimeOutTime);
    }

    /**
     * Finds the increase button for adults in the Travellers panel.
     *
     * @param room The room number of the element.
     * @return Returns the adults increase button.
     */
    private WebElement getAdultsIncreaseButton(int room) {
        return find(By.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[2]"), globalTimeOutTime);
    }

    /**
     * Finds the decrease button for children in the Travellers panel.
     *
     * @param room The room number of the element.
     * @return Returns the children decrease button.
     */
    private WebElement getChildrenDecreaseButton(int room) {
        return find(By.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'childStepInput')]/div/button[1]"), globalTimeOutTime);
    }

    /**
     * Finds the decrease button for children in the Travellers panel.
     *
     * @param room The room number of the element.
     * @return Returns the children increase button.
     */
    private WebElement getChildrenIncreaseButton(int room) {
        return find(By.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'childStepInput')]/div/button[2]"), globalTimeOutTime);
    }


    /**
     * Finds the remove room button for a specified room in the Travellers panel.
     *
     * @param room The room number of the element.
     * @return Returns the remove room button.
     */
    private WebElement getRemoveRoom(int room) {
        return find(By.xpath("//div[@data-testid='room-" + room + "']/div[@class='removeRoomButton uitk-type-right all-t-padding-four']/button"), globalTimeOutTime);
    }

    /**
     * Clicks the add another room button. You may only have a maximum of 8 rooms.
     */
    public void clickAddRoom() {
        click(travellersAddAnotherRoomButton, globalTimeOutTime, "Clicked on the 'Add another room button' in the travellers tab.");
    }

    /**
     * Clicks the remove room button. There must be at least 2 rooms available on the travellers panel.
     *
     * @param room The room number of the element.
     */
    public void clickRemoveRoom(int room) {
        click(getRemoveRoom(room), globalTimeOutTime, "Clicked on the 'Remove room' button for room " + room + ".");
    }

    /**
     * Clicks on the decrease button for adults in the travellers panel.
     *
     * @param room The room number in which the element is located.
     */
    public void clickAdultsDecrease(int room) {
        click(getAdultsDecreaseButton(room), globalTimeOutTime, "Clicked on the '-' button for adults in the travellers panel for room " + room + ".");
    }

    /**
     * Clicks on the increase button for adults in the travellers panel.
     *
     * @param room The room number in which the element is located.
     */
    public void clickAdultsIncrease(int room) {
        click(getAdultsIncreaseButton(room), globalTimeOutTime, "Clicked on the '+' button for adults in the travellers panel for room " + room + ".");
    }

    /**
     * Clicks on the decrease button for children in the travellers panel.
     *
     * @param room The room number in which the element is located.
     */
    public void clickChildrenDecrease(int room) {
        click(getChildrenDecreaseButton(room), globalTimeOutTime, "Clicked on the '-' button for children in the travellers panel for room " + room + ".");
    }

    /**
     * Clicks on the increase button for children in the travellers panel.
     *
     * @param room The room number in which the element is located.
     */
    public void clickChildrenIncrease(int room) {
        click(getChildrenIncreaseButton(room), globalTimeOutTime, "Clicked on the '+' button for children in the travellers panel for room " + room + ".");
    }


    /**
     * Clicks on the decrease button for adults in the travellers panel.
     */
    public void clickAdultsDecrease() {
        click(travellersAdultDec, globalTimeOutTime, "Clicked the decrease adult count button in the Travellers panel.");
    }

    /**
     * Clicks on the increase button for adults in the travellers panel.
     */
    public void clickAdultsIncrease() {
        click(travellersAdultInc, globalTimeOutTime, "Clicked the increase adult count button in the Travellers panel.");
    }

    /**
     * Clicks on the decrease button for children in the travellers panel.
     */
    public void clickChildrenDecrease() {
        click(travellersChildDec, globalTimeOutTime, "Clicked the decrease child count button in the Travellers panel.");
    }


    /**
     * Clicks on the increase button for children in the travellers panel.
     */
    public void clickChildrenIncrease() {
        click(travellersChildInc, globalTimeOutTime, "Clicked the increase child count button in the Travellers panel.");
    }


    /**
     * Clicks on the decrease button for infants in the travellers panel.
     */
    public void clickInfantsDecrease() {
        click(travellersInfantsDec, globalTimeOutTime, "Clicked the decrease infants count button in the Travellers panel.");
    }


    /**
     * Clicks on the increase button for infants in the travellers panel.
     */
    public void clickInfantsIncrease() {
        click(travellersInfantsInc, globalTimeOutTime, "Clicked the increase infants count button in the Travellers panel.");
    }

    /**
     * Finds the specified child age select element in the travellers panel.
     *
     * @param room  The room number in which the element is located.
     * @param child The child number.
     * @return The age select element for the specified child.
     */
    private WebElement getChildAgeSelect(int room, int child) {
        return find(By.id("child-age-input-" + (room - 1) + "-" + (child - 1)), globalTimeOutTime);
    }

    /**
     * Sets the value of the Child Age drop down menu in the travellers panel.
     *
     * @param room  The room number in which the element is located.
     * @param child The child number.
     * @param age   The age to be set.
     */
    public void selectChildAge(int room, int child, int age) {
        Select childAge = new Select(getChildAgeSelect(room, child));
        childAge.selectByIndex(age);
        log(LogStatus.INFO, "Set the age of child " + child + " in room " + room + " to " + age);
    }

    /**
     * Clicks the "Done" button in the "Travellers" panel.
     */
    public void clickDoneButton() {
        click(travellersDoneButton, globalTimeOutTime, "Clicked on the done button in the 'Travellers' panel.");
    }

    /**
     * Returns the visible text of the "Travellers" button.
     */
    public String getTravellersButtonText() {
        if (isClickable(By.xpath("//button[@data-testid='travelers-field-trigger']"), globalTimeOutTime)) {
            return find(By.xpath("//button[@data-testid='travelers-field-trigger']")).getText();
        } else {
            log(LogStatus.INFO, "Travellers button was not available, getting the text from travellers anchor tag instead.");
            return find(By.xpath("//a[@data-testid='travelers-field']")).getText();
        }
    }

    /**
     * Returns the visible text of the "Done" button in the travellers panel.
     */
    public String getDoneButtonText() {
        return getText(travellersDoneButton, globalTimeOutTime, "'Done' button for travellers menu was found with the following text");
    }

    /**
     * Returns the visible text of the "Travellers" header in the travellers panel.
     */
    public String getPanelHeaderText() {
        return getText(travellersMenuHeader, globalTimeOutTime, "'Travellers' header for travellers menu was found with the following text");
    }

    //TODO: ADD JAVADOC
    private WebElement getRoomHeaderElement(int room) {
        return find(By.xpath("//div[@data-testid='room-" + room + "']/h3/span"), globalTimeOutTime);
    }

    /**
     * Returns the visible text of a specific "Room" header.
     *
     * @param room The room which the "Room" header you are looking for is in.
     */

    public String getRoomHeaderText(int room) {
        return getText(getRoomHeaderElement(room), globalTimeOutTime,
                "'Room' header for room " + room + " in the travellers menu was found with the following text");
    }

    //TODO:ADD JAVADOC
    private WebElement getAdultsLabelElement(int room) {
        return find(By.xpath("//label[@for='adult-input-" + (room - 1) + "']"), globalTimeOutTime);
    }

    /**
     * Returns the visible text of a specific "Adults" label.
     *
     * @param room The room which the "Adults" label you are looking for is in.
     */
    public String getAdultsLabelText(int room) {
        return getText(getAdultsLabelElement(room), globalTimeOutTime,
                "'Adults' label for room " + room + " was found with the following text");
    }

    private WebElement getChildrenLabelElement(int room) {
        return find(By.xpath("//label[@for='child-input-" + (room - 1) + "']"), globalTimeOutTime);
    }

    /**
     * Returns the visible text of a specific "Children" label.
     *
     * @param room The room which the "Children" label you are looking for is in.
     */
    public String getChildrenLabelText(int room) {
        return getText(getChildrenLabelElement(room), globalTimeOutTime,
                "'Travellers' label for room " + room + " was found with the following text");
    }

    /**
     * Returns the visible text of the label displayed above the selected option on a Child select element.
     *
     * @param room  The room which the label is located in.
     * @param child The specific child select which contains the label.
     */
    public String getChildSelectLabelText(int room, int child) {
        return getText(By.xpath("//label[@for='child-age-input-" + (room - 1) + "-" + (child - 1) + "']"), globalTimeOutTime,
                "The label for child " + child + " in room " + room + " had the following text");
    }

    /**
     * Returns the selected option of a child select element.
     *
     * @param room  The room which the child select element is in.
     * @param child The specific child select.
     */
    public String getChildSelectedText(int room, int child) {
        Select childAgeSelect = new Select(getChildAgeSelect(room, child));
        return getText(childAgeSelect.getFirstSelectedOption(), globalTimeOutTime,
                "The selected option for the drop menu for child " + child + " in room " + room + " had the following text");
    }

    private WebElement getAdultCountElement(int room) {
        return find(By.id("adult-input-" + (room - 1)), globalTimeOutTime);
    }

    /**
     * Returns the "Adults" count.
     *
     * @param room The specific room which the counter is located.
     */
    public String getAdultsCountText(int room) {
        return getAdultCountElement(room).getAttribute("value");
    }

    private WebElement getChildCountElement(int room) {
        return find(By.id("child-input-" + (room - 1)), globalTimeOutTime);
    }

    /**
     * Returns the "Children" count.
     *
     * @param room The specific room which the counter is located.
     */
    public String getChildCountText(int room) {
        return getChildCountElement(room).getAttribute("value");
    }

    /**
     * Returns the visible text of the "Add another room" button.
     */
    public String getAddAnotherRoomText() {
        return getText(travellersAddAnotherRoomButton, globalTimeOutTime, "The 'Add another room' button was found with the following text");
    }

    /**
     * Returns the visible text of the "Remove room" button.
     *
     * @param room The specific room in which the element is located in.
     */
    public String getRemoveRoomText(int room) {
        return getText(getRemoveRoom(room), globalTimeOutTime,
                "The 'Remove room' button for room " + room + " was found with the following text");
    }

    /**
     * Sets the age for the specified infant in the travellers panel.
     *
     * @param infant Which infant you'd like to edit.
     * @param age    The age you'd like to set it to.
     */

    public void selectInfantAge(int infant, int age) {
        Select infantAge = new Select(getInfantsAgeSelect(infant));
        infantAge.selectByIndex(age);
        log(LogStatus.INFO, "Set the age of infant " + infant + " to " + age);
    }

    /**
     * Finds the specified infant age select element in the travellers panel.
     *
     * @param infant The infant number for the select element you wish to find.
     * @return The age select element for the specified infant.
     */
    private WebElement getInfantsAgeSelect(int infant) {
        return find(By.id("infant-age-input-0-" + (infant - 1)), globalTimeOutTime);
    }

    /**
     * Finds the specified child age select element in the travellers panel.
     *
     * @param child The child number.
     * @return The age select element for the specified child.
     */
    private WebElement getChildAgeSelect(int child) {
        return find(By.id("child-age-input-0-" + (child - 1)), globalTimeOutTime);
    }

    /**
     * Sets the value of the Child Age drop down menu in the travellers panel.
     *
     * @param child The child number.
     * @param age   The age to be set.
     */
    public void selectChildAge(int child, int age) {
        Select childAge = new Select(getChildAgeSelect(child));
        if (childAge.getOptions().get(0).getText().equals("2")) {
            childAge.selectByIndex(age - 2);
        } else {
            childAge.selectByIndex(age);
        }
        log(LogStatus.INFO, "Set the age of child " + child + " to " + age);
    }

    /**
     * Clicks the "On lap" radio button in the travellers panel.
     */
    public void clickTravellersOnLap(Boolean isRadioButtonSelected) {
        click(childOnLap, ExpectedConditions.elementSelectionStateToBe(childOnLap, isRadioButtonSelected),
                globalTimeOutTime, "Clicked the 'On lap' radio button in the travellers panel.");
    }

    /**
     * Clicks the "In seat" radio button in the travellers panel.
     */
    public void clickTravellersInSeat(Boolean isRadioButtonSelected) {
        click(childInSeat, ExpectedConditions.elementSelectionStateToBe(childInSeat, isRadioButtonSelected),
                globalTimeOutTime, "Clicked the 'On lap' radio button in the travellers panel.");
    }

    /**
     * Returns the visible text of the error message that is displayed when you try to book more than 14 people in the
     * 'Stays' travellers panel.
     */
    public String getStaysErrorMessageText() {
        return getText(travellersErrorMessage, globalTimeOutTime,
                "The error message that is displayed when you try to book more than " +
                        "14 people in the travellers panel was found with the following text");
    }

    /**
     * Clicks the "Airline age rules" hyperlink in the travellers panel.
     */
    public void clickAirlineAgeRules() {
        click(airlineAgeRules, globalTimeOutTime, "Clicked the 'Airline age rules' hyperlink in the travellers panel");
    }

    /**
     * Checks that a specific child select element is displaying the correct options.
     *
     * @param room            The room in which the child select is located.
     * @param child           The specific child select we are checking.
     * @param expectedOptions What options the child select should have.
     * @return True if all the options are correct, else false.
     */
    public Boolean isChildSelectListingCorrectOptions(int room, int child, String[] expectedOptions) {
        Select childAgeSelect = new Select(getChildAgeSelect(room, child));
        List<WebElement> actualOptions = childAgeSelect.getOptions();
        for (int x = 0; x < actualOptions.size(); x++) {
            if (!actualOptions.get(x).getText().equals(expectedOptions[x])) {
                log(LogStatus.ERROR, "The available options of child select element " + child + " room " + room + " did not contain the expected options.");
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether or not the increase button for adults in the travellers panel is enabled or not.
     *
     * @param room - The room in which the button is located in.
     * @return True if it is enabled, else false.
     */
    public Boolean isAdultIncreaseButtonEnabled(int room) {
        return getAdultsIncreaseButton(room).isEnabled();
    }

    /**
     * Determines whether or not the increase button for children in the travellers panel is enabled or not.
     *
     * @param room - The room in which the button is located in.
     * @return True if it is enabled, else false.
     */
    public Boolean isChildIncreaseButtonEnabled(int room) {
        return getChildrenIncreaseButton(room).isEnabled();
    }

    /**
     * Determines whether or not the decrease button for adults in the travellers panel is enabled or not.
     *
     * @param room - The room in which the button is located in.
     * @return True if it is enabled, else false.
     */
    public Boolean isAdultDecreaseButtonEnabled(int room) {
        return getAdultsDecreaseButton(room).isEnabled();
    }

    /**
     * Determines whether or not the decrease button for children in the travellers panel is enabled or not.
     *
     * @param room - The room in which the button is located in.
     * @return True if it is enabled, else false.
     */
    public Boolean isChildDecreaseButtonEnabled(int room) {
        return getChildrenDecreaseButton(room).isEnabled();
    }

    public Boolean isRoomHeaderRemoved(int room) {
        return waitUntilInvisible(By.xpath("//div[@data-testid='room-" + room + "']/h3/span"), globalTimeOutTime);
    }

    public Boolean isAdultsLabelRemoved(int room) {
        return waitUntilInvisible(By.xpath("//label[@for='adult-input-" + (room - 1) + "']"), globalTimeOutTime);
    }

    public Boolean isChildrenLabelRemoved(int room) {
        return waitUntilInvisible(By.xpath("//label[@for='child-input-" + (room - 1) + "']"), globalTimeOutTime);
    }

    public Boolean isChildrenSelectRemoved(int room, int child) {
        return waitUntilInvisible(By.id("child-age-input-" + (room - 1) + "-" + (child - 1)), globalTimeOutTime);
    }

    public Boolean isAdultsDecreaseButtonRemoved(int room) {
        return waitUntilInvisible(By.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[1]"), globalTimeOutTime);
    }

    public Boolean isAdultsIncreaseButtonRemoved(int room) {
        return waitUntilInvisible(By.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[2]"), globalTimeOutTime);
    }

    public Boolean isChildrenDecreaseButtonRemoved(int room) {
        return waitUntilInvisible(By.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'childStepInput')]/div/button[1]"), globalTimeOutTime);
    }

    public Boolean isChildrenIncreaseButtonRemoved(int room) {
        return waitUntilInvisible(By.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'childStepInput')]/div/button[2]"), globalTimeOutTime);
    }

    public Boolean isAdultsCountRemoved(int room) {
        return waitUntilInvisible(By.id("adult-input-" + (room - 1)), globalTimeOutTime);
    }

    public Boolean isChildCountRemoved(int room) {
        return waitUntilInvisible(By.id("child-input-" + (room - 1)), globalTimeOutTime);
    }

    public Boolean isRemoveRoomButtonRemoved(int room) {
        return waitUntilInvisible(By.xpath("//div[@data-testid='room-" + room + "']/div[@class='removeRoomButton uitk-type-right all-t-padding-four']/button"), globalTimeOutTime);
    }
}
