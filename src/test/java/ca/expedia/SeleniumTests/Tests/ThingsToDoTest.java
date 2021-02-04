package ca.expedia.SeleniumTests.Tests;

import ca.expedia.SeleniumTests.PageFactory.CalendarFactory;
import ca.expedia.SeleniumTests.PageFactory.TabFactory;
import ca.expedia.SeleniumTests.PageFactory.ThingsToDoFactory;
import ca.expedia.SeleniumTests.SetUp.CommonTestBase;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;

public class ThingsToDoTest extends CommonTestBase {
    private ThingsToDoFactory todo;
    private TabFactory tab;
    private CalendarFactory cal;

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        super.beforeMethod(result);
        todo = new ThingsToDoFactory(driver, test, 5);
        tab = new TabFactory(driver, test, 5);
        cal = new CalendarFactory(driver, test, 5);
    }

    @Test(description = "Things To Do Demo")
    public void thingsToDoDemo() {
        tab.clickThingsToDoTab();
        todo.clickThingsToDoIn();
        todo.sendKeysThingsToDoIn("Toronto");
        todo.clickSearchResult("Toronto", "Ontario, Canada");
        todo.clickFromButton();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarCheckOutDate();
        cal.clickCalendarCheckInDate();
        cal.clickCalendarBackArrow();
        cal.clickCalendarBackArrow();
        cal.clickCalendarDay(Month.FEBRUARY, 18, 2021);
        cal.clickCalendarDone();
        todo.clickToButton();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarCheckInDate();
        cal.clickCalendarCheckOutDate();
        cal.clickCalendarBackArrow();
        cal.clickCalendarDay(Month.MARCH, 1, 2021);
        cal.clickCalendarDone();
        todo.clickSearchButton();
    }
}
