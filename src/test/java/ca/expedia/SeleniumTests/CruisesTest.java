package ca.expedia.SeleniumTests;

import org.testng.annotations.Test;

import java.time.Month;

public class CruisesTest extends TestBase {
    @Test(description = "Cruises Demo")
    public void cruisesDemo() {
        cru.clickCruisesTab();
        cru.selectCruiseDestination("Mexico");
        cru.clickTravellersButton();
        for (int x = 0; x < 4; x++) {
            if (x < 3) {
                cru.clickTravellersAdultsInc();
            }
            cru.clickTravellersChildrenInc();
            cru.selectChildAge(x + 1, x + 5);
        }
        for (int x = 0; x < 4; x++) {
            cru.clickTravellersAdultsDec();
            cru.clickTravellersChildrenDec();
        }
        cru.clickTravellersDone();
        cru.clickDepartsAsEarlyAs();
        cru.clickCalendarCheckOutDate();
        cru.clickCalendarCheckInDate();
        cru.clickCalendarForwardArrow();
        cru.clickCalendarBackArrow();
        cru.clickCalendarDay(Month.FEBRUARY, 10, 2021);
        cru.clickCalendarDone();
        cru.clickDepartsAsLateAs();
        cru.clickCalendarCheckInDate();
        cru.clickCalendarCheckOutDate();
        cru.clickCalendarForwardArrow();
        cru.clickCalendarBackArrow();
        cru.clickCalendarDay(Month.FEBRUARY, 20, 2021);
        cru.clickCalendarDone();
    }
}
