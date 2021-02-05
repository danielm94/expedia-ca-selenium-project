package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CarsFactory extends PageFactoryBase {
    private long globalTimeOutTimer;
    @FindBy(xpath = "//a[@href='carsForm']")
    private WebElement rentalTab;

    @FindBy(xpath = "//a[@href='gtForm']")
    private WebElement airportTab;

    @FindBy(xpath = "//button[@data-stid='location-field-locn-menu-trigger']")
    private WebElement pickUpButton;

    @FindBy(xpath = "//button[@data-stid='location-field-loc2-menu-trigger']")
    private WebElement samePickupButton;

    @FindBy(xpath = "//select[@aria-label='Pick-up time']")
    private WebElement pickUpTime;

    @FindBy(xpath = "//select[@aria-label='Drop-off time']")
    private WebElement dropOffTime;

    @FindBy(id = "location-field-locn")
    private WebElement pickUpInput;

    @FindBy(xpath = "//span[text()='I have a discount code' and not(@class='is-visually-hidden')]")
    private WebElement iHaveADiscountCode;

    @FindBy(id = "location-field-loc2")
    private WebElement sameAsPickUpInput;

    @FindBy(xpath = "//select[@aria-label='Preferred brand']")
    private WebElement rentalCarCompanySelect;

    @FindBy(xpath = "//select[@aria-label='Discount type']")
    private WebElement discountTypeSelect;

    @FindBy(id = "coupon-code-0")
    private WebElement couponInput1;

    @FindBy(id = "coupon-code-1")
    private WebElement couponInput2;

    @FindBy(id = "coupon-code-2")
    private WebElement couponInput3;

    @FindBy(xpath = "//button[@data-stid='location-field-location-menu-trigger']")
    private WebElement airportButton;

    @FindBy(id = "location-field-location")
    private WebElement airportInput;

    @FindBy(xpath = "//button[@data-stid='location-field-hotelName-menu-trigger']")
    private WebElement hotelNameButton;

    @FindBy(id = "location-field-hotelName")
    private WebElement hotelNameInput;

    @FindBy(xpath = "//select[@aria-label='Flight arrival time']")
    private WebElement flightArrivalTimeSelect;

    @FindBy(id = "book-roundtrip-toggle")
    private WebElement bookRoundtrip;

    @FindBy(xpath = "//select[@aria-label='Flight departure time']")
    private WebElement flightDepartureTimeSelect;

    @FindBy(xpath = "//button[@data-testid='swap_horiz']")
    private WebElement swapAirportHotel;
    /**
     * This button opens the calendar to select a pick up date.
     */
    @FindBy(id = "d1-btn")
    private WebElement pickUpDate;

    /**
     * This button opens the calendar to select a drop off date.
     */
    @FindBy(id = "d2-btn")
    private WebElement dropOffDate;

    public CarsFactory(WebDriver driver, ExtentTest test, long globalTimeOutTimer) {
        super(driver, test);
        this.globalTimeOutTimer = globalTimeOutTimer;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the pick up date button so the user may select a check in date from the calendar date picker panel.
     */
    public void clickPickUpDate() {
        click(pickUpDate, globalTimeOutTimer, "Clicked the 'Pick-up date' button.");
    }

    /**
     * Clicks the drop off date button so the user may select a check out date from the calendar date picker panel.
     */
    public void clickDropOffDate() {
        click(dropOffDate, globalTimeOutTimer, "Clicked the 'Drop-off date' button.");
    }

    /**
     * Clicks the flight arrival date button so the user may select a check in date from the calendar date picker panel.
     * This method is functionally identical as "clickPickUpDate()", however it exists to reduce confusion for people
     * who are not familiar with this framework when developing tests.
     */
    public void clickFlightArrivalDate() {
        click(pickUpDate, globalTimeOutTimer, "Clicked the 'Flight arrival date' button.");
    }

    /**
     * Clicks the flight arrival date button so the user may select a check in date from the calendar date picker panel.
     * This method is functionally identical as "clickDropOffDate()", however it exists to reduce confusion for people
     * who are not familiar with this framework when developing tests.
     */
    public void clickFlightDepartureDate() {
        click(dropOffDate, globalTimeOutTimer, "Clicked the 'Flight departure date' button.");
    }

    /**
     * Clicks the "Rental cars" subtab in the "Cars" tab.
     */
    public void clickRentalTab() {
        click(rentalTab, globalTimeOutTimer, "Clicked on the 'Rental cars' subtab.");
    }

    /**
     * Clicks the "Airport transportation" subtab in the "Cars" tab.
     */
    public void clickAirportTab() {
        click(airportTab, globalTimeOutTimer, "Clicked on the 'Airport transportation' subtab.");
    }

    /**
     * Clicks the "Pick-up" button so that we may access the input.
     */
    public void clickPickUp() {
        click(pickUpButton, globalTimeOutTimer, "Clicked on the 'Pick-up' button.");
    }

    /**
     * Clicks the "Same as pick-up" button so that we may access the input.
     */
    public void clickSameAsPickup() {
        click(samePickupButton, globalTimeOutTimer, "Clicked on the 'Same as pick-up' button.");
    }

    /**
     * Sets the value of the "Pick-up time" select in the "Rental cars" subtab in the "Cars" tab.
     *
     * @param time : The time value you'd like to set it to. Use the visible text in the select menu as the parameter.
     *             E.g., "00:00" for 12AM.
     */
    public void selectPickUpTime(String time) {
        Select sel = new Select(waitUntilVisible(pickUpTime, globalTimeOutTimer));
        sel.selectByVisibleText(time);
        log(LogStatus.INFO, "Set the value of the 'Pick-up time' select element to " + time);
    }

    /**
     * Sets the value of the "Drop-off time" select in the "Rental cars" subtab in the "Cars" tab.
     *
     * @param time : The time value you'd like to set it to. Use the visible text in the select menu as the parameter.
     *             E.g., "00:00" for 12AM.
     */
    public void selectDropOffTime(String time) {
        Select sel = new Select(waitUntilVisible(dropOffTime, globalTimeOutTimer));
        sel.selectByVisibleText(time);
        log(LogStatus.INFO, "Set the value of the 'Drop-off time' select element to " + time);
    }

    /**
     * Sends keys to the "Pick-up" input in the "Rental cars" subtab in the "Cars" tab.
     *
     * @param keys : The keys you wish to type into the input.
     */
    public void sendKeysPickUp(String keys) {
        type(pickUpInput, globalTimeOutTimer, keys, "Entered the following keys into the 'Pick-up' input: " + keys);
    }

    /**
     * Sends keys to the "Same as pick-up" input field in the "Rental cars" subtab in the "Cars" tab.
     *
     * @param keys : The keys you wish to send to the input.
     */
    public void sendKeysSameAsPickUp(String keys) {
        type(sameAsPickUpInput, globalTimeOutTimer, keys, "Entered the following keys into the 'Same as pick-up' input: " + keys);
    }

    /**
     * Clicks the "I have a discount code" span in the "Rental cars" sub tab in the "Cars" tab.
     */
    public void clickIHaveADiscountCode() {
        click(iHaveADiscountCode, globalTimeOutTimer, "Clicked on 'I have a discount code'.");
    }

    /**
     * Selects a rental car company from the "Preferred brand" select in the "Rental cars" subtab in the "Cars" tab.
     *
     * @param company : The company you'd wish to select. Use the visible text from the select as a parameter. E.g.,
     *                "Enterprise" or "Hertz".
     */
    public void selectRentalCarCompany(String company) {
        Select sel = new Select(waitUntilVisible(rentalCarCompanySelect, globalTimeOutTimer));
        sel.selectByVisibleText(company);
        log(LogStatus.INFO, "Set the value of 'Preferred brand' select to: " + company);
    }

    /**
     * Selects a coupon type from the "Discount type" select in the "Rental cars" subtab in the "Cars" tab.
     *
     * @param couponType : The coupon you'd wish to select. Use the visible text from the select as a parameter. E.g.,
     *                   "I don't have a code".
     */
    public void selectDiscountType(String couponType) {
        Select sel = new Select(waitUntilVisible(discountTypeSelect, globalTimeOutTimer));
        sel.selectByVisibleText(couponType);
        log(LogStatus.INFO, "Set the value of 'Discount type' select to: " + couponType);
    }

    /**
     * Sends keys to the first discount code input in the "Rental cars" subtab in the "Cars" tab.
     *
     * @param keys : The keys you'd wish to type into the input.
     */
    public void sendKeysCouponInput1(String keys) {
        type(couponInput1, globalTimeOutTimer, keys, "Entered the following keys into the first discount code input: " + keys);
    }

    /**
     * Sends keys to the second discount code input in the "Rental cars" subtab in the "Cars" tab.
     *
     * @param keys : The keys you'd wish to type into the input.
     */
    public void sendKeysCouponInput2(String keys) {
        type(couponInput2, globalTimeOutTimer, keys, "Entered the following keys into the second discount code input: " + keys);
    }

    /**
     * Sends keys to the third discount code input in the "Rental cars" subtab in the "Cars" tab.
     *
     * @param keys : The keys you'd wish to type into the input.
     */
    public void sendKeysCouponInput3(String keys) {
        type(couponInput3, globalTimeOutTimer, keys, "Entered the following keys into the third discount code input: " + keys);
    }

    /**
     * Clicks the "Airport" button so that we may send keys to its input.
     */
    public void clickAirportButton() {
        click(airportButton, globalTimeOutTimer, "Clicked on the 'Airport' button.");
    }

    /**
     * Sends keys to the "Airport" input field in the "Airport transportation" subtab in the "Cars" tab.
     *
     * @param keys The keys you wish to send to the input.
     */
    public void sendKeysAirportInput(String keys) {
        type(airportInput, globalTimeOutTimer, keys, "Entered the following keys into the 'Airport' input: " + keys);
    }

    /**
     * Clicks the "Hotel name" button so that we may send keys to its input.
     */
    public void clickHotelNameButton() {
        click(hotelNameButton, globalTimeOutTimer, "Clicked on the 'Hotel name' button.");
    }

    /**
     * Sends keys to the "Hotel name" input field in the "Airport transportation" subtab in the "Cars" tab.
     *
     * @param keys The keys you wish to send to the input.
     */
    public void sendKeysHotelNameInput(String keys) {
        type(hotelNameInput, globalTimeOutTimer, keys, "Entered the following keys into the 'Hotel name' input: " + keys);
    }

    /**
     * Selects a time from the "Flight arrival time" select in the "Airport transportation" subtab in the "Cars" tab.
     *
     * @param time : The time you wish to select. Use visible text from the select as the parameter. E.g., "00:00" for
     *             12AM, "14:15" for 2:15PM, etc.
     */
    public void selectFlightArrivalTime(String time) {
        Select sel = new Select(waitUntilVisible(flightArrivalTimeSelect, globalTimeOutTimer));
        sel.selectByVisibleText(time);
        log(LogStatus.INFO, "Set the value of the 'Flight arrival time' select to: " + time);
    }

    /**
     * Clicks the "Book roundtrip" checkbox in the "Airport transportation" subtab in the "Cars" tab.
     * @param isTheCheckBoxChecked If the checkbox is checked, true, else false.
     */
    public void clickBookRoundtrip(boolean isTheCheckBoxChecked) {
        click(bookRoundtrip, ExpectedConditions.elementSelectionStateToBe(bookRoundtrip, isTheCheckBoxChecked), globalTimeOutTimer, "Clicked on the 'Book roundtrip' checkbox.");
    }

    /**
     * Selects a time from the "Flight departure time" select in the "Airport transportation" subtab in the "Cars" tab.
     *
     * @param time : The time you wish to select. Use visible text from the select as the parameter. E.g., "00:00" for
     *             12AM, "14:15" for 2:15PM, etc.
     */
    public void selectFlightDepratureTime(String time) {
        Select sel = new Select(waitUntilVisible(flightDepartureTimeSelect, globalTimeOutTimer));
        sel.selectByVisibleText(time);
        log(LogStatus.INFO, "Set the value of the 'Flight departure time' select to: " + time);
    }

    /**
     * Clicks on the swap Airport/Hotel name button in the "Airport transportation" subtab.
     */
    public void clickSwapAirportHotel() {
        click(swapAirportHotel, globalTimeOutTimer, "Clicked on the swap airport/hotel button.");
    }
}
