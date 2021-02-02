package ca.expedia.SeleniumTests;

import org.testng.annotations.Test;

import java.time.Month;

public class ThingsToDoTest extends TestBase {
    @Test(description = "Things To Do Demo")
    public void thingsToDoDemo() {
        ttd.clickThingsToDoTab();
        ttd.clickThingsToDoIn();
        ttd.sendKeysThingsToDoIn("Toronto");
        ttd.clickSearchResult("Toronto", "Ontario, Canada");
        ttd.clickFromButton();
        ttd.clickCalendarForwardArrow();
        ttd.clickCalendarForwardArrow();
        ttd.clickCalendarCheckOutDate();
        ttd.clickCalendarCheckInDate();
        ttd.clickCalendarBackArrow();
        ttd.clickCalendarBackArrow();
        ttd.clickCalendarDay(Month.FEBRUARY, 18, 2021);
        ttd.clickCalendarDone();
        ttd.clickToButton();
        ttd.clickCalendarForwardArrow();
        ttd.clickCalendarForwardArrow();
        ttd.clickCalendarCheckInDate();
        ttd.clickCalendarCheckOutDate();
        ttd.clickCalendarBackArrow();
        ttd.clickCalendarDay(Month.MARCH, 1, 2021);
        ttd.clickCalendarDone();
        ttd.clickSearchButton();
    }
}
