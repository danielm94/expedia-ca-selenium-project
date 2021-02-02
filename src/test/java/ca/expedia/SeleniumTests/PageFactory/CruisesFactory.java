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

public class CruisesFactory extends CommonFactory {
    private WebDriver driver;

    @FindBy(id = "cruise-destination")
    private WebElement goingTo;

    /**
     * This button opens the calendar to select a check in date.
     */
    @FindBy(id = "d1-btn")
    private WebElement departsAsEarlyAsButton;

    /**
     * This button opens the calendar to select a check out date.
     */
    @FindBy(id = "d2-btn")
    private WebElement departsAsLateAsButton;

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

    /**
     * Constructor
     *
     * @param driver Driver instance from TestBase.
     * @param test ExtentTest instance from TestBase.
     */
    public CruisesFactory(WebDriver driver, ExtentTest test) {
        super(driver, test);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects a cruise destination from the "Going to" select.
     *
     * @param destination : The destination you wish to select. Use the exact text for the option you wish to select.
     */
    public void selectCruiseDestination(String destination) {
        Select sel = new Select(goingTo);
        sel.selectByVisibleText(destination);
        log(LogStatus.INFO, "Set the value of the 'Going to' select to: " + destination);
    }

    /**
     * Clicks the "Departs as early as" button so that we may open the calendar date picker and select our first date.
     */
    public void clickDepartsAsEarlyAs() {
        departsAsEarlyAsButton.click();
        log(LogStatus.INFO, "Clicked the 'Departs as early as' button.");
    }

    /**
     * Clicks the "Departs as late as" button so that we may open the calendar date picker and select our second date.
     */
    public void clickDepartsAsLateAs() {
        departsAsLateAsButton.click();
        log(LogStatus.INFO, "Clicked the 'Departs as late as' button.");
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
     * Clicks the "Travellers" button/hyperlink to open the travellers submenu.
     */
    public void clickTravellersButton() {
        try {
            WebElement travellerButton = driver
                    .findElement(By.xpath("//button[@data-testid='travelers-field-trigger']"));
            travellerButton.click();
            log(LogStatus.INFO, "Clicked on the 'Travellers' button");
        } catch (NoSuchElementException e) {
            WebElement alternativeTravellerButton = driver.findElement(By.xpath("//a[@data-testid='travelers-field']"));
            alternativeTravellerButton.click();
            log(LogStatus.INFO, "Clicked on the 'Travellers' anchor tag.");
        }
    }

    /**
     * Finds the specified child age select element in the travellers panel.
     *
     * @param child The child number. Range: 1-4
     * @return The age select element for the specified child.
     */
    private Select getChildAgeSelect(int child) {
        WebElement element = driver.findElement(By.id("child-age-input-0-" + (child - 1)));
        return new Select(element);
    }

    /**
     * Sets the value of the Child Age drop down menu in the travellers panel.
     *
     * @param child The child number. Range: 1-4
     * @param age   The age to be set. Range: 0-17
     */
    public void selectChildAge(int child, int age) {
        Select childAge = getChildAgeSelect(child);
        childAge.selectByIndex(age);
        log(LogStatus.INFO, "Set the age of child " + child + " to " + age + ".");
    }
}
