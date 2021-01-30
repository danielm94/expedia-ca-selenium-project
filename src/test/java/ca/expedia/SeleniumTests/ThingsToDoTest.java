package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.ThingsToDoFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;

public class ThingsToDoTest extends TestBase {
    private ThingsToDoFactory f;

    @BeforeMethod
    public void beforeMethod() {
        reportName = "things-to-do-tab";
        f = new ThingsToDoFactory(driver);
        super.beforeMethod();
    }

    @Test
    public void thingsToDoDemo() {
        test = f.createTestReport(report, "Things To Do Demo");
        f.clickThingsToDoTab();
        f.clickThingsToDoIn();
        f.sendKeysThingsToDoIn("Toronto");
        f.clickSearchResult("Toronto", "Ontario, Canada");
        f.clickFromButton();
        f.clickCalendarForwardArrow();
        f.clickCalendarForwardArrow();
        f.clickCalendarCheckOutDate();
        f.clickCalendarCheckInDate();
        f.clickCalendarBackArrow();
        f.clickCalendarBackArrow();
        f.clickCalendarDay(Month.FEBRUARY, 18, 2021);
        f.clickCalendarDone();
        f.clickToButton();
        f.clickCalendarForwardArrow();
        f.clickCalendarForwardArrow();
        f.clickCalendarCheckInDate();
        f.clickCalendarCheckOutDate();
        f.clickCalendarBackArrow();
        f.clickCalendarDay(Month.MARCH, 1, 2021);
        f.clickCalendarDone();
        f.clickSearchButton();
    }
}
