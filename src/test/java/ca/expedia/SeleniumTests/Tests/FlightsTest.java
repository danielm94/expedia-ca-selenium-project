package ca.expedia.SeleniumTests.Tests;

import ca.expedia.SeleniumTests.PageFactory.CalendarFactory;
import ca.expedia.SeleniumTests.PageFactory.FlightsFactory;
import ca.expedia.SeleniumTests.PageFactory.TabFactory;
import ca.expedia.SeleniumTests.PageFactory.TravellersFactory;
import ca.expedia.SeleniumTests.SetUp.CommonTestBase;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;

public class FlightsTest extends CommonTestBase {
    private FlightsFactory flights;
    private CalendarFactory cal;
    private TravellersFactory travel;
    private TabFactory tab;

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        super.beforeMethod(result);
        flights = new FlightsFactory(driver, test, 5);
        cal = new CalendarFactory(driver, test, 5);
        travel = new TravellersFactory(driver, test, 5);
        tab = new TabFactory(driver,test,5);
    }

    @Test(description = "Flights Tab Test")
    public void flightsTabTest() {
        tab.clickFlightsTab();
        flights.clickLeavingFrom();
        flights.sendKeysLeaving("Delhi");
        flights.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        flights.clickGoingTo();
        flights.sendKeysGoing("Toronto");
        flights.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        flights.clickDeparting();
        cal.clickCalendarCheckInDate();
        cal.clickCalendarDay(Month.FEBRUARY, 5, 2021);
        cal.clickCalendarDone();
        flights.clickReturning();
        cal.clickCalendarCheckOutDate();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarBackArrow();
        cal.clickCalendarDay(Month.FEBRUARY, 9, 2021);
        cal.clickCalendarDone();
        flights.clickPreferredClass();
        flights.clickPremiumEconomy();
        flights.clickOneWay();
        flights.clickLeavingFrom();
        flights.sendKeysLeaving("Delhi");
        flights.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        flights.clickGoingTo();
        flights.sendKeysGoing("Toronto");
        flights.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        flights.clickDeparting();
        cal.clickCalendarCheckInDate();
        cal.clickCalendarDay(Month.FEBRUARY, 9, 2021);
        cal.clickCalendarDone();
        flights.clickPreferredClass();
        flights.clickPremiumEconomy();
        travel.clickTravellersAnchorTag();
        for (int x = 0; x < 5; x++) {
            travel.clickTravellersChildrenInc();
        }
        travel.selectChildAge(1, 2);
        travel.selectChildAge(2, 3);
        travel.selectChildAge(3, 10);
        travel.selectChildAge(4, 9);
        travel.selectChildAge(5, 7);
        for (int x = 0; x < 5; x++) {
            travel.clickTravellersChildrenDec();
        }
        for (int x = 0; x < 5; x++) {
            travel.clickTravellersInfantsInc();
        }
        travel.selectInfantAge(1, 1);
        travel.selectInfantAge(2, 1);
        travel.selectInfantAge(3, 1);
        travel.selectInfantAge(4, 1);
        travel.selectInfantAge(5, 1);
        travel.selectInfantAge(5, 0);
        travel.clickTravellersInSeat();
        travel.clickTravellersOnLap();
        travel.clickAirlineAgeRules();
        travel.clickTravellersDoneButton();
    }

    @Test(description = "Multi City Test")
    public void multiCityTest() {
        tab.clickFlightsTab();
        flights.clickMultiCity();
        for (int x = 0; x < 3; x++) {
            flights.clickAddAnotherFlight();
        }
        flights.clickMultiCityLeavingFrom(1);
        flights.sendKeysMultiCityLeaving("Delhi", 1);
        flights.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        flights.clickMultiCityGoingTo(1);
        flights.sendKeysMultiCityGoing("Toronto", 1);
        flights.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        flights.clickMultiCityDeparting(1);
        cal.clickCalendarDay(Month.FEBRUARY, 8, 2021);
        cal.clickCalendarDone();
        flights.clickMultiCityLeavingFrom(2);
        flights.sendKeysMultiCityLeaving("Delhi", 2);
        flights.clickSearchResult("London (YXU - London Intl.)", "Near Delhi, Ontario, Canada");
        flights.clickMultiCityGoingTo(2);
        flights.sendKeysMultiCityGoing("Toronto", 2);
        flights.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        flights.clickMultiCityDeparting(2);
        cal.clickCalendarDay(Month.FEBRUARY, 9, 2021);
        cal.clickCalendarDone();
        flights.clickMultiCityLeavingFrom(3);
        flights.sendKeysMultiCityLeaving("Delhi", 3);
        flights.clickSearchResult("London (YXU - London Intl.)", "Near Delhi, Ontario, Canada");
        flights.clickMultiCityGoingTo(3);
        flights.sendKeysMultiCityGoing("Toronto", 3);
        flights.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        flights.clickMultiCityDeparting(3);
        cal.clickCalendarDay(Month.FEBRUARY, 10, 2021);
        cal.clickCalendarDone();
        flights.clickMultiCityLeavingFrom(4);
        flights.sendKeysMultiCityLeaving("Delhi", 4);
        flights.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        flights.clickMultiCityGoingTo(4);
        flights.sendKeysMultiCityGoing("Toronto", 4);
        flights.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        flights.clickMultiCityDeparting(4);
        cal.clickCalendarDay(Month.FEBRUARY, 11, 2021);
        cal.clickCalendarDone();
        flights.clickMultiCityLeavingFrom(5);
        flights.sendKeysMultiCityLeaving("Delhi", 5);
        flights.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        flights.clickMultiCityGoingTo(5);
        flights.sendKeysMultiCityGoing("Toronto", 5);
        flights.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        flights.clickMultiCityDeparting(5);
        cal.clickCalendarDay(Month.FEBRUARY, 12, 2021);
        cal.clickCalendarDone();
    }
}
