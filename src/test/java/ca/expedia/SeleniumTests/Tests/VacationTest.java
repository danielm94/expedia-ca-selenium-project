package ca.expedia.SeleniumTests.Tests;

import ca.expedia.SeleniumTests.PageFactory.CalendarFactory;
import ca.expedia.SeleniumTests.PageFactory.TabFactory;
import ca.expedia.SeleniumTests.PageFactory.TravellersFactory;
import ca.expedia.SeleniumTests.PageFactory.VacationFactory;
import ca.expedia.SeleniumTests.SetUp.CommonTestBase;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;

public class VacationTest extends CommonTestBase {
    private VacationFactory vacation;
    private TabFactory tab;
    private CalendarFactory cal;
    private TravellersFactory travel;

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        super.beforeMethod(result);
        vacation = new VacationFactory(driver, test, 5);
        tab = new TabFactory(driver, test, 5);
        cal = new CalendarFactory(driver, test, 5);
        travel = new TravellersFactory(driver, test, 5);

    }

    @Test(description = "Vacation Tab Demo")
    public void vacationTabDemo() {
        tab.clickVacationPackagesTab();
        vacation.clickFlightsSubTab();
        vacation.clickStaysSubTab();
        vacation.clickCarsSubTab();
        vacation.clickFlightsSubTab();
        vacation.clickStaysSubTab();
        vacation.clickLeavingFrom();
        vacation.sendKeysLeavingFrom("Delhi");
        vacation.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        vacation.clickGoingTo();
        vacation.sendKeysGoingTo("Toronto");
        vacation.clickSearchResult("Toronto", "Ontario, Canada");
        vacation.clickAccommodationsCheckbox();
        vacation.clickDepartingButton();
        cal.clickCalendarDay(Month.FEBRUARY, 20, 2021);
        cal.clickCalendarDone();
        vacation.clickReturningButton();
        cal.clickCalendarDay(Month.FEBRUARY, 22, 2021);
        cal.clickCalendarDone();
        vacation.clickCheckIn();
        cal.clickCalendarDay(Month.FEBRUARY, 25, 2021);
        cal.clickCalendarDone();
        vacation.clickCheckOut();
        cal.clickCalendarDay(Month.FEBRUARY, 26, 2021);
        cal.clickCalendarDone();
        vacation.clickPreferredClass();
        vacation.clickFirstClass();
        vacation.clickPreferredClass();
        vacation.clickBusinessClass();
        vacation.clickPreferredClass();
        vacation.clickPremiumEconomy();
        vacation.clickPreferredClass();
        vacation.clickEconomy();
    }

    @Test(description = "Traveller Test")
    public void travellerTest() {
        tab.clickVacationPackagesTab();
        travel.clickTravellersAnchorTag();
        // Add 5 rooms
        for (int x = 0; x < 5; x++) {
            travel.clickTravellersAddRoom();
        }
        // Set the number of adults, children and infants to 6 in all the rooms.
        for (int room = 1; room < 7; room++) {
            while (vacation.getTravellerAdultCount(room) != 6) {
                vacation.clickTravellersAdultsInc(room);
            }
            while (vacation.getTravellerChildCount(room) != 6) {
                vacation.clickTravellersChildrenInc(room);
            }
            while (vacation.getTravellerInfantCount(room) != 6) {
                vacation.clickTravellersInfantsInc(room);
            }
        }

        // Set the age of the children in each room from 5-10. (Child 1 = 5, Child 2 =
        // 6, Child 3 = 7, etc.)
        // Set the age of every 2nd infant in each room to 1, else set it to under 1.
        for (int room = 1; room < 7; room++) {
            for (int x = 1; x < 7; x++) {
                vacation.selectChildAge(room, x, Integer.toString(x + 4));
                if (x % 2 == 0) {
                    vacation.selectInfantAge(room, x, 1);
                } else {
                    vacation.selectInfantAge(room, x, 0);
                }
            }
        }
        // Set the number of adults to 1.
        // Set the number of children and infants to 0.
        for (int room = 6; room > 0; room--) {
            while (vacation.getTravellerAdultCount(room) != 1) {
                vacation.clickTravellersAdultsDec(room);
            }
            while (vacation.getTravellerChildCount(room) != 0) {
                vacation.clickTravellersChildrenDec(room);
            }
            while (vacation.getTravellerInfantCount(room) != 0) {
                vacation.clickTravellersInfantsDec(room);
            }
        }
        // Remove all the rooms
        for (int room = 6; room > 1; room--) {
            vacation.clickTravellersRemoveRoom(room);
        }
        vacation.clickTravellersInfantsInc(1);
        travel.clickTravellersInSeat();
        travel.clickTravellersOnLap();
        travel.clickTravellersDoneButton();
        travel.clickTravellersAnchorTag();
        travel.clickAirlineAgeRules();
    }
}
