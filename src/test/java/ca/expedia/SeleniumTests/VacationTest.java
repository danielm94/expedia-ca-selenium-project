package ca.expedia.SeleniumTests;

import org.testng.annotations.Test;

import java.time.Month;

public class VacationTest extends TestBase {
    @Test(description = "Vacation Tab Demo")
    public void vacationTabDemo() {
        vac.clickVacationPackagesTab();
        vac.clickFlightsSubTab();
        vac.clickStaysSubTab();
        vac.clickCarsSubTab();
        vac.clickFlightsSubTab();
        vac.clickStaysSubTab();
        vac.clickLeavingFrom();
        vac.sendKeysLeavingFrom("Delhi");
        vac.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        vac.clickGoingTo();
        vac.sendKeysGoingTo("Toronto");
        vac.clickSearchResult("Toronto", "Ontario, Canada");
        vac.clickAccommodationsCheckbox();
        vac.clickDepartingButton();
        vac.clickCalendarDay(Month.FEBRUARY, 20, 2021);
        vac.clickCalendarDone();
        vac.clickReturningButton();
        vac.clickCalendarDay(Month.FEBRUARY, 22, 2021);
        vac.clickCalendarDone();
        vac.clickCheckIn();
        vac.clickCalendarDay(Month.FEBRUARY, 25, 2021);
        vac.clickCalendarDone();
        vac.clickCheckOut();
        vac.clickCalendarDay(Month.FEBRUARY, 26, 2021);
        vac.clickCalendarDone();
        vac.clickPreferredClass();
        vac.clickFirstClass();
        vac.clickPreferredClass();
        vac.clickBusinessClass();
        vac.clickPreferredClass();
        vac.clickPremiumEconomy();
        vac.clickPreferredClass();
        vac.clickEconomy();
    }

    @Test(description = "Traveller Test")
    public void travellerTest() {
        vac.clickVacationPackagesTab();
        vac.clickTraveler();
        // Add 5 rooms
        for (int x = 0; x < 5; x++) {
            vac.clickTravellersAddRoom();
        }
        // Set the number of adults, children and infants to 6 in all the rooms.
        for (int room = 1; room < 7; room++) {
            while (vac.getTravellerAdultCount(room) != 6) {
                vac.clickTravellersAdultsInc(room);
            }
            while (vac.getTravellerChildCount(room) != 6) {
                vac.clickTravellersChildrenInc(room);
            }
            while (vac.getTravellerInfantCount(room) != 6) {
                vac.clickTravellersInfantsInc(room);
            }
        }

        // Set the age of the children in each room from 5-10. (Child 1 = 5, Child 2 =
        // 6, Child 3 = 7, etc.)
        // Set the age of every 2nd infant in each room to 1, else set it to under 1.
        for (int room = 1; room < 7; room++) {
            for (int x = 1; x < 7; x++) {
                vac.selectChildAge(room, x, Integer.toString(x + 4));
                if (x % 2 == 0) {
                    vac.selectInfantAge(room, x, 1);
                } else {
                    vac.selectInfantAge(room, x, 0);
                }
            }
        }
        // Set the number of adults to 1.
        // Set the number of children and infants to 0.
        for (int room = 6; room > 0; room--) {
            while (vac.getTravellerAdultCount(room) != 1) {
                vac.clickTravellersAdultsDec(room);
            }
            while (vac.getTravellerChildCount(room) != 0) {
                vac.clickTravellersChildrenDec(room);
            }
            while (vac.getTravellerInfantCount(room) != 0) {
                vac.clickTravellersInfantsDec(room);
            }
        }
        // Remove all the rooms
        for (int room = 6; room > 1; room--) {
            vac.clickTravellersRemoveRoom(room);
        }
        vac.clickTravellersInfantsInc(1);
        vac.clickChildInSeat();
        vac.clickChildOnLap();
        vac.clickTravellersDone();
        vac.clickTraveler();
        vac.clickAirlineAgeRules();
    }
}
