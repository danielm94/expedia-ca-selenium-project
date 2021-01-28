package ca.expedia.SeleniumTests.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CarsFactory extends CommonFactory {
    private WebDriver driver;

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

    @FindBy(xpath = "//div[contains(@class,'childStepInput')][2]/div/button[1]")
    private WebElement travellersInfantsDec;

    @FindBy(xpath = "//div[contains(@class,'childStepInput')][2]/div/button[2]")
    private WebElement travellersInfantsInc;
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

    /**
     * Constructor
     *
     * @param driver Driver instance from test class.
     */
    public CarsFactory(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the pick up date button so the user may select a check in date from
     * the calendar date picker panel.
     */
    public void clickPickUpDate() {
        pickUpDate.click();
        log(LogStatus.INFO, "Clicked the 'Pick-up date' button.");
    }

    /**
     * Clicks the drop off date button so the user may select a check out date from
     * the calendar date picker panel.
     */
    public void clickDropOffDate() {
        dropOffDate.click();
        log(LogStatus.INFO, "Clicked the 'Drop-off date' button.");
    }

    /**
     * Clicks the flight arrival date button so the user may select a check in date from
     * the calendar date picker panel. This method is functionally identical as "clickPickUpDate()", however it exists
     * to reduce confusion for people who are not familiar with this framework when developing tests.
     */
    public void clickFlightArrivalDate() {
        pickUpDate.click();
        log(LogStatus.INFO, "Clicked the 'Flight arrival date' button.");
    }

    /**
     * Clicks the flight arrival date button so the user may select a check in date from
     * the calendar date picker panel. This method is functionally identical as "clickDropOffDate()", however it exists
     * to reduce confusion for people who are not familiar with this framework when developing tests.
     */
    public void clickFlightDepartureDate() {
        dropOffDate.click();
        log(LogStatus.INFO, "Clicked the 'Flight departure date' button.");
    }

    /**
     * Clicks the traveler anchor tag so that the user may access the "Travellers"
     * submenu.
     */
    public void clickTraveller() {
        travelerAnchor.click();
        log(LogStatus.INFO, "Clicked the 'Travellers' button.");
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
        log(LogStatus.INFO, "Clicked on the decrease button for adults in the travellers panel.");
    }

    /**
     * Clicks on the increase button for adults in the travellers panel.
     */
    public void clickTravellersAdultsInc() {
        travellersAdultInc.click();
        log(LogStatus.INFO, "Clicked on the increase button for adults in the travellers panel.");
    }

    /**
     * Clicks on the decrease button for children in the travellers panel.
     */
    public void clickTravellersChildrenDec() {
        travellersChildDec.click();
        log(LogStatus.INFO, "Clicked on the decrease button for children in the travellers panel.");
    }

    /**
     * Clicks on the increase button for children in the travellers panel.
     */
    public void clickTravellersChildrenInc() {
        travellersChildInc.click();
        log(LogStatus.INFO, "Clicked on the increase button for children in the travellers panel.");
    }

    /**
     * Clicks on the decrease button for infants in the travellers panel.
     */
    public void clickTravellersInfantsDec() {
        travellersInfantsDec.click();
        log(LogStatus.INFO, "Clicked on the decrease button for infants in the travellers panel.");
    }

    /**
     * Clicks on the increase button for infants in the travellers panel.
     */
    public void clickTravellersInfantsInc() {
        travellersInfantsInc.click();
        log(LogStatus.INFO, "Clicked on the increase button for infants in the travellers panel.");
    }

    /**
     * Clicks the "Rental cars" subtab in the "Cars" tab.
     */
    public void clickRentalTab() {
        rentalTab.click();
        log(LogStatus.INFO, "Clicked on the 'Rental cars' subtab.");
    }

    /**
     * Clicks the "Airport transportation" subtab in the "Cars" tab.
     */
    public void clickAirportTab() {
        airportTab.click();
        log(LogStatus.INFO, "Clicked on the 'Airport transportation' subtab.");
    }

    /**
     * Clicks the "Pick-up" button so that we may access the input.
     */
    public void clickPickUp() {
        pickUpButton.click();
        log(LogStatus.INFO, "Clicked on the 'Pick-up' button.");
    }

    /**
     * Clicks the "Same as pick-up" button so that we may access the input.
     */
    public void clickSameAsPickup() {
        samePickupButton.click();
        log(LogStatus.INFO, "Clicked on the 'Same as pick-up' button.");
    }

    /**
     * Sets the value of the "Pick-up time" select in the "Rental cars" subtab in
     * the "Cars" tab.
     *
     * @param time : The time value you'd like to set it to. Use the visible text in
     *             the select menu as the parameter. E.g., "00:00" for 12AM.
     */
    public void selectPickUpTime(String time) {
        Select sel = new Select(pickUpTime);
        sel.selectByVisibleText(time);
        log(LogStatus.INFO, "Set the value of the 'Pick-up time' select element to " + time);
    }

    /**
     * Sets the value of the "Drop-off time" select in the "Rental cars" subtab in
     * the "Cars" tab.
     *
     * @param time : The time value you'd like to set it to. Use the visible text in
     *             the select menu as the parameter. E.g., "00:00" for 12AM.
     */
    public void selectDropOffTime(String time) {
        Select sel = new Select(dropOffTime);
        sel.selectByVisibleText(time);
        log(LogStatus.INFO, "Set the value of the 'Drop-off time' select element to " + time);
    }

    /**
     * Sends keys to the "Pick-up" input in the "Rental cars" subtab in the "Cars"
     * tab.
     *
     * @param keys : The keys you wish to type into the input.
     */
    public void sendKeysPickUp(String keys) {
        pickUpInput.clear();
        pickUpInput.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the 'Pick-up' input: " + keys);
    }

    /**
     * Sends keys to the "Same as pick-up" input field in the "Rental cars" subtab
     * in the "Cars" tab.
     *
     * @param keys : The keys you wish to send to the input.
     */
    public void sendKeysSameAsPickUp(String keys) {
        sameAsPickUpInput.clear();
        sameAsPickUpInput.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the 'Same as pick-up' input: " + keys);
    }

    /**
     * Clicks the "I have a discount code" span in the "Rental cars" sub tab in the
     * "Cars" tab.
     */
    public void clickIHaveADiscountCode() {
        iHaveADiscountCode.click();
        log(LogStatus.INFO, "Clicked on 'I have a discount code'.");
    }

    /**
     * Selects a rental car company from the "Preferred brand" select in the "Rental
     * cars" subtab in the "Cars" tab.
     *
     * @param company : The company you'd wish to select. Use the visible text from
     *                the select as a parameter. E.g., "Enterprise" or "Hertz".
     */
    public void selectRentalCarCompany(String company) {
        Select sel = new Select(rentalCarCompanySelect);
        sel.selectByVisibleText(company);
        log(LogStatus.INFO, "Set the value of 'Preferred brand' select to: " + company);
    }

    /**
     * Selects a coupon type from the "Discount type" select in the "Rental cars"
     * subtab in the "Cars" tab.
     *
     * @param couponType : The coupon you'd wish to select. Use the visible text
     *                   from the select as a parameter. E.g., "I don't have a
     *                   code".
     */
    public void selectDiscountType(String couponType) {
        Select sel = new Select(discountTypeSelect);
        sel.selectByVisibleText(couponType);
        log(LogStatus.INFO, "Set the value of 'Discount type' select to: " + couponType);
    }

    /**
     * Sends keys to the first discount code input in the "Rental cars" subtab in
     * the "Cars" tab.
     *
     * @param keys : The keys you'd wish to type into the input.
     */
    public void sendKeysCouponInput1(String keys) {
        couponInput1.clear();
        couponInput1.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the first discount code input: " + keys);
    }

    /**
     * Sends keys to the second discount code input in the "Rental cars" subtab in
     * the "Cars" tab.
     *
     * @param keys : The keys you'd wish to type into the input.
     */
    public void sendKeysCouponInput2(String keys) {
        couponInput2.clear();
        couponInput2.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the second discount code input: " + keys);
    }

    /**
     * Sends keys to the third discount code input in the "Rental cars" subtab in
     * the "Cars" tab.
     *
     * @param keys : The keys you'd wish to type into the input.
     */
    public void sendKeysCouponInput3(String keys) {
        couponInput3.clear();
        couponInput3.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the third discount code input: " + keys);
    }

    /**
     * Clicks the "Airport" button so that we may send keys to its input.
     */
    public void clickAirportButton() {
        airportButton.click();
        log(LogStatus.INFO, "Clicked on the 'Airport' button.");
    }

    /**
     * Sends keys to the "Airport" input field in the "Airport transportation"
     * subtab in the "Cars" tab.
     *
     * @param keys The keys you wish to send to the input.
     */
    public void sendKeysAirportInput(String keys) {
        airportInput.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the 'Airport' input: " + keys);
    }

    /**
     * Clicks the "Hotel name" button so that we may send keys to its input.
     */
    public void clickHotelNameButton() {
        hotelNameButton.click();
        log(LogStatus.INFO, "Clicked on the 'Hotel name' button.");
    }

    /**
     * Sends keys to the "Hotel name" input field in the "Airport transportation"
     * subtab in the "Cars" tab.
     *
     * @param keys The keys you wish to send to the input.
     */
    public void sendKeysHotelNameInput(String keys) {
        hotelNameInput.clear();
        hotelNameInput.sendKeys(keys);
        log(LogStatus.INFO, "Entered the following keys into the 'Hotel name' input: " + keys);
    }

    /**
     * Selects a time from the "Flight arrival time" select in the "Airport
     * transportation" subtab in the "Cars" tab.
     *
     * @param time : The time you wish to select. Use visible text from the select
     *             as the parameter. E.g., "00:00" for 12AM, "14:15" for 2:15PM,
     *             etc.
     */
    public void selectFlightArrivalTime(String time) {
        Select sel = new Select(flightArrivalTimeSelect);
        sel.selectByVisibleText(time);
        log(LogStatus.INFO, "Set the value of the 'Flight arrival time' select to: " + time);
    }

    /**
     * Clicks the "Book roundtrip" checkbox in the "Airport transportation" subtab
     * in the "Cars" tab.
     */
    public void clickBookRoundtrip() {
        bookRoundtrip.click();
        log(LogStatus.INFO, "Clicked on the 'Book roundtrip' checkbox.");
    }

    /**
     * Selects a time from the "Flight departure time" select in the "Airport
     * transportation" subtab in the "Cars" tab.
     *
     * @param time : The time you wish to select. Use visible text from the select
     *             as the parameter. E.g., "00:00" for 12AM, "14:15" for 2:15PM,
     *             etc.
     */
    public void selectFlightDepratureTime(String time) {
        Select sel = new Select(flightDepartureTimeSelect);
        sel.selectByVisibleText(time);
        log(LogStatus.INFO, "Set the value of the 'Flight departure time' select to: " + time);
    }

    /**
     * Clicks on the swap Airport/Hotel name button in the "Airport transportation" subtab.
     */
    public void clickSwapAirportHotel() {
        swapAirportHotel.click();
        log(LogStatus.INFO, "Clicked on the swap airport/hotel button.");
    }
}
