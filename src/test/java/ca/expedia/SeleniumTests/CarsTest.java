package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.CarsFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;


public class CarsTest extends TestBase {
    private CarsFactory f;

    @BeforeMethod
    public void beforeMethod() {
        reportName = "cars-tab";
        f = new CarsFactory(driver);
        super.beforeMethod();
    }

    @Test()
    public void carsTest() {
        test = f.createTestReport(report,"Cars Test");
        f.clickCarsTab();
        f.clickAirportTab();
        f.clickRentalTab();
        f.clickPickUp();
        f.sendKeysPickUp("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickSameAsPickup();
        f.sendKeysSameAsPickUp("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickPickUpDate();
        f.clickCalendarForwardArrow();
        f.clickCalendarDay(Month.MARCH, 19, 2021);
        f.clickCalendarDone();
        f.clickDropOffDate();
        f.clickCalendarForwardArrow();
        f.clickCalendarDay(Month.APRIL, 9, 2021);
        f.clickCalendarDone();
        f.selectPickUpTime("15:00");
        f.selectDropOffTime("22:15");
        f.clickIHaveADiscountCode();
        f.clickIHaveADiscountCode();
        f.clickIHaveADiscountCode();
        f.selectRentalCarCompany("Thrifty Car Rental");
        f.selectDiscountType("Special or advertised");
        f.sendKeysCouponInput1("Test1");
        f.sendKeysCouponInput2("Test2");
        f.sendKeysCouponInput3("Test3");
        f.clickAirportTab();
        f.clickAirportButton();
        f.sendKeysAirportInput("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickHotelNameButton();
        f.sendKeysHotelNameInput("Toronto");
        f.clickSearchResult("Hotel Toronto", "New Delhi, National Capital Territory of Delhi, India");
        f.clickFlightArrivalDate();
        f.clickCalendarDay(Month.MARCH, 20, 2021);
        f.clickCalendarDone();
        f.selectFlightArrivalTime("16:30");
        f.clickBookRoundtrip();
        f.clickFlightDepartureDate();
        f.clickCalendarDay(Month.MARCH, 25, 2021);
        f.clickCalendarDone();
        f.selectFlightDepratureTime("19:30");
        f.clickTraveller();
        f.clickTravellersAdultsInc();
        f.clickTravellersAdultsInc();
        f.clickTravellersChildrenInc();
        f.clickTravellersChildrenInc();
        f.clickTravellersInfantsInc();
        f.clickTravellersInfantsInc();
        f.clickTravellersAdultsDec();
        f.clickTravellersChildrenDec();
        f.clickTravellersInfantsDec();
        f.clickTravellersDone();
        f.clickSwapAirportHotel();
    }
}
