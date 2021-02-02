package ca.expedia.SeleniumTests.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AllInclusiveFactory extends CommonFactory {
    private WebDriver driver;

    @FindBy(xpath = "//a[@data-testid='travelers-field']")
    private WebElement travelerAnchor;

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

    @FindBy(xpath = "//a[@href='http://allinclusiveforgroups.expedia.ca/en-CA/LandGroup']")
    private WebElement bookFor10;

    /**
     * This button opens the calendar to select a departing date.
     */
    @FindBy(id = "d1-btn")
    private WebElement departingButton;

    /**
     * Constructor
     *
     * @param driver Driver instance from TestBase.
     * @param test ExtentTest instance from TestBase.
     */
    public AllInclusiveFactory(WebDriver driver, ExtentTest test) {
        super(driver,test);
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
     * Clicks the "Done" button in the "Travellers" panel.
     */
    public void clickTravellersDone() {
        travellersDone.click();
        log(LogStatus.INFO, "Clicked the 'Done' button in the 'Travellers' panel.");
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
     * Finds the "Leaving from" drop down menu and returns it as a select.
     *
     * @return "Leaving from" drop down as a select.
     */
    private Select getLeavingFromSelect() {
        WebElement leavingFromSelect = driver.findElement(By.id("leaving-3pp"));
        return new Select(leavingFromSelect);

    }

    /**
     * Selects an option from the "Leaving from" select.
     *
     * @param option : The option you wish to select. Use visible text only.
     */
    public void selectLeavingFrom(String option) {
        Select leavingFromSelect = getLeavingFromSelect();
        leavingFromSelect.selectByVisibleText(option);
        log(LogStatus.INFO, "Set the value of the 'Leaving from' select to: " + option);
    }

    /**
     * Finds the "Going to" drop down menu and returns it as a select.
     *
     * @return "Going to" drop down as a select.
     */
    private Select getGoingToSelect() {
        WebElement goingToSelect = driver.findElement(By.id("going-3pp"));
        return new Select(goingToSelect);
    }

    /**
     * Selects an option from the "Going to" select.
     *
     * @param option : The option you wish to select. Use visible text only.
     */
    public void selectGoingTo(String option) {
        Select goingToSelect = getGoingToSelect();
        goingToSelect.selectByVisibleText(option);
        log(LogStatus.INFO, "Set the value of the 'Going to' select to: " + option);
    }

    /**
     * Finds the "Vacation length" drop down menu and returns it as a select.
     *
     * @return "Vacation length" drop down as a select.
     */
    private Select getVacationLengthSelect() {
        WebElement vacationLengthSelect = driver.findElement(By.id("threepp-duration-select"));
        return new Select(vacationLengthSelect);
    }

    /**
     * Selects an option from the "Vacation length" select.
     *
     * @param option : The option you wish to select. Use visible text only.
     */
    public void selectVacationLength(String option) {
        Select vacationLengthSelect = getVacationLengthSelect();
        vacationLengthSelect.selectByVisibleText(option);
        log(LogStatus.INFO, "Set the value of the 'Vacation length' select to: " + option);
    }

    /**
     * Finds the specified child age select element in the travellers panel.
     *
     * @param child The child number. Range: 1-6
     * @return The age select element for the specified child.
     */
    private Select getChildAgeSelect(int child) {
        WebElement element = driver.findElement(By.id("child-age-input-0-" + (child - 1)));
        return new Select(element);
    }

    /**
     * Sets the value of the Child Age drop down menu in the travellers panel.
     *
     * @param child The child number. Range: 1-6
     * @param age   The age to be set. Range: 0-17, 0 being "Under-1".
     */
    public void selectChildAge(int child, int age) {
        Select childAge = getChildAgeSelect(child);
        childAge.selectByIndex(age);
        log(LogStatus.INFO, "Set the age of child " + child + " to " + age);
    }

    /**
     * Clicks the "Book for 10+ people" hyperlink.
     */
    public void clickBookFor10() {
        bookFor10.click();
        log(LogStatus.INFO, "Clicked the 'Book for 10+ people' hyperlink.");
    }

    /**
     * Clicks the departing button so the user may select a check in date from
     * the calendar date picker panel.
     */
    public void clickDeparting() {
        departingButton.click();
        log(LogStatus.INFO, "Clicked the 'Departing' button.");
    }
}
