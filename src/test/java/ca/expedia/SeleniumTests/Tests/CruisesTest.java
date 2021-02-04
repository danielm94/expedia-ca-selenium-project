package ca.expedia.SeleniumTests.Tests;

import ca.expedia.SeleniumTests.PageFactory.CalendarFactory;
import ca.expedia.SeleniumTests.PageFactory.CruisesFactory;
import ca.expedia.SeleniumTests.PageFactory.TabFactory;
import ca.expedia.SeleniumTests.PageFactory.TravellersFactory;
import ca.expedia.SeleniumTests.SetUp.CommonTestBase;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;

public class CruisesTest extends CommonTestBase {
    private CruisesFactory cruise;
    private TabFactory tab;
    private CalendarFactory cal;
    private TravellersFactory travel;

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        super.beforeMethod(result);
        cruise = new CruisesFactory(driver, test, 5);
        tab = new TabFactory(driver, test, 5);
        cal = new CalendarFactory(driver, test, 5);
        travel = new TravellersFactory(driver, test, 5);
    }

    @Test(description = "Cruises Demo")
    public void cruisesDemo() {
        tab.clickCruisesTab();
        cruise.selectCruiseDestination("Mexico");
        travel.clickTravellersButton();
        for (int x = 0; x < 4; x++) {
            if (x < 3) {
                travel.clickTravellersAdultsInc();
            }
            travel.clickTravellersChildrenInc();
            travel.selectChildAge(x + 1, x + 5);
        }
        for (int x = 0; x < 4; x++) {
            travel.clickTravellersAdultsDec();
            travel.clickTravellersChildrenDec();
        }
        travel.clickTravellersDoneButton();
        cruise.clickDepartsAsEarlyAs();
        cal.clickCalendarCheckOutDate();
        cal.clickCalendarCheckInDate();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarBackArrow();
        cal.clickCalendarDay(Month.FEBRUARY, 10, 2021);
        cal.clickCalendarDone();
        cruise.clickDepartsAsLateAs();
        cal.clickCalendarCheckInDate();
        cal.clickCalendarCheckOutDate();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarBackArrow();
        cal.clickCalendarDay(Month.FEBRUARY, 20, 2021);
        cal.clickCalendarDone();
    }
}
