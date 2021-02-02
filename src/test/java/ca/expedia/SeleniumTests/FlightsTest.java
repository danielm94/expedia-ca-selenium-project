package ca.expedia.SeleniumTests;

import org.testng.annotations.Test;

import java.time.Month;

public class FlightsTest extends TestBase {
    
    @Test(description = "Flights Tab Test" )
    public void flightsTabTest() {
        fli.clickFlightsTab();
        fli.clickLeavingFrom();
        fli.sendKeysLeaving("Delhi");
        fli.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        fli.clickGoingTo();
        fli.sendKeysGoing("Toronto");
        fli.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        fli.clickDeparting();
        fli.clickCalendarCheckInDate();
        fli.clickCalendarDay(Month.FEBRUARY, 5, 2021);
        fli.clickCalendarDone();
        fli.clickReturning();
        fli.clickCalendarCheckOutDate();
        fli.clickCalendarForwardArrow();
        fli.clickCalendarBackArrow();
        fli.clickCalendarDay(Month.FEBRUARY, 9, 2021);
        fli.clickCalendarDone();
        fli.clickPreferredClass();
        fli.clickPremiumEconomy();
        fli.clickOneWay();
        fli.clickLeavingFrom();
        fli.sendKeysLeaving("Delhi");
        fli.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        fli.clickGoingTo();
        fli.sendKeysGoing("Toronto");
        fli.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        fli.clickDeparting();
        fli.clickCalendarCheckInDate();
        fli.clickCalendarDay(Month.FEBRUARY, 9, 2021);
        fli.clickCalendarDone();
        fli.clickPreferredClass();
        fli.clickPremiumEconomy();
        fli.clickTraveller();
        for (int x = 0; x < 5; x++) {
            fli.clickTravellersChildrenInc();
        }
        fli.selectChildAge(1, 2);
        fli.selectChildAge(2, 3);
        fli.selectChildAge(3, 10);
        fli.selectChildAge(4, 9);
        fli.selectChildAge(5, 7);
        for (int x = 0; x < 5; x++) {
            fli.clickTravellersChildrenDec();
        }
        for (int x = 0; x < 5; x++) {
            fli.clickTravellersInfantsInc();
        }
        fli.selectInfantAge(1, 1);
        fli.selectInfantAge(2, 1);
        fli.selectInfantAge(3, 1);
        fli.selectInfantAge(4, 1);
        fli.selectInfantAge(5, 1);
        fli.selectInfantAge(5, 0);
        fli.clickTravellersInSeat();
        fli.clickTravellersOnLap();
        fli.clickAirlineAgeRules();
        fli.clickTravellersDone();
    }

    @Test(description = "Multi City Test")
    public void mutliCityTest() {
        fli.clickFlightsTab();
        fli.clickMultiCity();
        for (int x = 0; x < 3; x++) {
            fli.clickAddAnotherFlight();
        }
        fli.clickMultiCityLeavingFrom(1);
        fli.sendKeysMultiCityLeaving("Delhi", 1);
        fli.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        fli.clickMultiCityGoingTo(1);
        fli.sendKeysMultiCityGoing("Toronto", 1);
        fli.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        fli.clickMultiCityDeparting(1);
        fli.clickCalendarDay(Month.FEBRUARY, 8, 2021);
        fli.clickCalendarDone();
        fli.clickMultiCityLeavingFrom(2);
        fli.sendKeysMultiCityLeaving("Delhi", 2);
        fli.clickSearchResult("London (YXU - London Intl.)", "Near Delhi, Ontario, Canada");
        fli.clickMultiCityGoingTo(2);
        fli.sendKeysMultiCityGoing("Toronto", 2);
        fli.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        fli.clickMultiCityDeparting(2);
        fli.clickCalendarDay(Month.FEBRUARY, 9, 2021);
        fli.clickCalendarDone();
        fli.clickMultiCityLeavingFrom(3);
        fli.sendKeysMultiCityLeaving("Delhi", 3);
        fli.clickSearchResult("London (YXU - London Intl.)", "Near Delhi, Ontario, Canada");
        fli.clickMultiCityGoingTo(3);
        fli.sendKeysMultiCityGoing("Toronto", 3);
        fli.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        fli.clickMultiCityDeparting(3);
        fli.clickCalendarDay(Month.FEBRUARY, 10, 2021);
        fli.clickCalendarDone();
        fli.clickMultiCityLeavingFrom(4);
        fli.sendKeysMultiCityLeaving("Delhi", 4);
        fli.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        fli.clickMultiCityGoingTo(4);
        fli.sendKeysMultiCityGoing("Toronto", 4);
        fli.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        fli.clickMultiCityDeparting(4);
        fli.clickCalendarDay(Month.FEBRUARY, 11, 2021);
        fli.clickCalendarDone();
        fli.clickMultiCityLeavingFrom(5);
        fli.sendKeysMultiCityLeaving("Delhi", 5);
        fli.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        fli.clickMultiCityGoingTo(5);
        fli.sendKeysMultiCityGoing("Toronto", 5);
        fli.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        fli.clickMultiCityDeparting(5);
        fli.clickCalendarDay(Month.FEBRUARY, 12, 2021);
        fli.clickCalendarDone();
    }
}
