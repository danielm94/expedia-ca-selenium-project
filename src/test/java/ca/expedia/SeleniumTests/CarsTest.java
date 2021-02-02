package ca.expedia.SeleniumTests;

import org.testng.annotations.Test;

import java.time.Month;

public class CarsTest extends TestBase {
    @Test(description = "Cars Test")
    public void carsTest() {
        car.clickCarsTab();
        car.clickAirportTab();
        car.clickRentalTab();
        car.clickPickUp();
        car.sendKeysPickUp("Toronto");
        car.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        car.clickSameAsPickup();
        car.sendKeysSameAsPickUp("Delhi");
        car.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        car.clickPickUpDate();
        car.clickCalendarForwardArrow();
        car.clickCalendarDay(Month.MARCH, 19, 2021);
        car.clickCalendarDone();
        car.clickDropOffDate();
        car.clickCalendarForwardArrow();
        car.clickCalendarDay(Month.APRIL, 9, 2021);
        car.clickCalendarDone();
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
        car.clickCalendarDay(Month.MARCH, 20, 2021);
        car.clickCalendarDone();
        car.selectFlightArrivalTime("16:30");
        car.clickBookRoundtrip();
        car.clickFlightDepartureDate();
        car.clickCalendarDay(Month.MARCH, 25, 2021);
        car.clickCalendarDone();
        car.selectFlightDepratureTime("19:30");
        car.clickTraveller();
        car.clickTravellersAdultsInc();
        car.clickTravellersAdultsInc();
        car.clickTravellersChildrenInc();
        car.clickTravellersChildrenInc();
        car.clickTravellersInfantsInc();
        car.clickTravellersInfantsInc();
        car.clickTravellersAdultsDec();
        car.clickTravellersChildrenDec();
        car.clickTravellersInfantsDec();
        car.clickTravellersDone();
        car.clickSwapAirportHotel();
    }
}
