package ca.expedia.SeleniumTests.Tests;

import ca.expedia.SeleniumTests.PageFactory.CalendarFactory;
import ca.expedia.SeleniumTests.PageFactory.CarsFactory;
import ca.expedia.SeleniumTests.PageFactory.TabFactory;
import ca.expedia.SeleniumTests.PageFactory.TravellersFactory;
import ca.expedia.SeleniumTests.SetUp.CommonTestBase;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;

public class CarsTest extends CommonTestBase {
    private CarsFactory car;
    private TabFactory tab;
    private CalendarFactory cal;
    private TravellersFactory travel;

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        super.beforeMethod(result);
        car = new CarsFactory(driver, test, 5);
        tab = new TabFactory(driver, test, 5);
        cal = new CalendarFactory(driver, test, 5);
        travel = new TravellersFactory(driver, test, 5);
    }

    @Test(description = "Cars Test")
    public void carsTest() {
        tab.clickCarsTab();
        car.clickAirportTab();
        car.clickRentalTab();
        car.clickPickUp();
        car.sendKeysPickUp("Toronto");
        car.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        car.clickSameAsPickup();
        car.sendKeysSameAsPickUp("Delhi");
        car.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        car.clickPickUpDate();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarDay(Month.MARCH, 19, 2021);
        cal.clickCalendarDone();
        car.clickDropOffDate();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarDay(Month.APRIL, 9, 2021);
        cal.clickCalendarDone();
        car.selectPickUpTime("15:00");
        car.selectDropOffTime("22:15");
        car.clickIHaveADiscountCode();
        car.clickIHaveADiscountCode();
        car.clickIHaveADiscountCode();
        car.selectRentalCarCompany("Thrifty Car Rental");
        car.selectDiscountType("Special or advertised");
        car.sendKeysCouponInput1("Test1");
        car.sendKeysCouponInput2("Test2");
        car.sendKeysCouponInput3("Test3");
        car.clickAirportTab();
        car.clickAirportButton();
        car.sendKeysAirportInput("Delhi");
        car.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        car.clickHotelNameButton();
        car.sendKeysHotelNameInput("Toronto");
        car.clickSearchResult("Hotel Toronto", "New Delhi, National Capital Territory of Delhi, India");
        car.clickFlightArrivalDate();
        cal.clickCalendarDay(Month.MARCH, 20, 2021);
        cal.clickCalendarDone();
        car.selectFlightArrivalTime("16:30");
        car.clickBookRoundtrip();
        car.clickFlightDepartureDate();
        cal.clickCalendarDay(Month.MARCH, 25, 2021);
        cal.clickCalendarDone();
        car.selectFlightDepratureTime("19:30");
        travel.clickTravellersAnchorTag();
        travel.clickTravellersAdultsInc();
        travel.clickTravellersAdultsInc();
        travel.clickTravellersChildrenInc();
        travel.clickTravellersChildrenInc();
        travel.clickTravellersInfantsInc();
        travel.clickTravellersInfantsInc();
        travel.clickTravellersAdultsDec();
        travel.clickTravellersChildrenDec();
        travel.clickTravellersInfantsDec();
        travel.clickTravellersDoneButton();
        car.clickSwapAirportHotel();
    }
}
