package ca.expedia.SeleniumTests;

import org.testng.annotations.Test;

import java.time.Month;

public class AllInclusiveTest extends TestBase {
    @Test(description = "All Inclusive Test")
    public void allInclusiveTest() {
        all.clickAllInclusiveVacationsTab();
        all.selectLeavingFrom("Toronto");
        all.selectGoingTo("Bermuda");
        all.clickDeparting();
        all.clickCalendarCheckInDate();
        all.clickCalendarForwardArrow();
        all.clickCalendarForwardArrow();
        all.clickCalendarBackArrow();
        all.clickCalendarDay(Month.FEBRUARY, 24, 2021);
        all.clickCalendarDone();
        all.selectVacationLength("7 days");
        all.clickTraveller();
        for (int x = 0; x < 12; x++) {
            all.clickTravellersAdultsInc();
            if (x < 6) {
                all.clickTravellersChildrenInc();
                all.selectChildAge(x + 1, x + 1);
            }
        }
        for (int x = 0; x < 13; x++) {
            all.clickTravellersAdultsDec();
            if (x < 6) {
                all.clickTravellersChildrenDec();
            }
        }
        all.clickTravellersDone();
        all.clickBookFor10();
    }
}
