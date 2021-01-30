package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.CruisesFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;

public class CruisesTest extends TestBase {
    private CruisesFactory f;

    @BeforeMethod
    public void beforeMethod() {
        reportName = "cruises-tab";
        f = new CruisesFactory(driver);
        super.beforeMethod();
    }

    @Test()
    public void cruisesDemo() {
        test = f.createTestReport(report, "Cruises Demo");
        f.clickCruisesTab();
        f.selectCruiseDestination("Mexico");
        f.clickTravellersButton();
        for (int x = 0; x < 4; x++) {
            if (x < 3) {
                f.clickTravellersAdultsInc();
            }
            f.clickTravellersChildrenInc();
            f.selectChildAge(x + 1, x + 5);
        }
        for (int x = 0; x < 4; x++) {
            f.clickTravellersAdultsDec();
            f.clickTravellersChildrenDec();
        }
        f.clickTravellersDone();
        f.clickDepartsAsEarlyAs();
        f.clickCalendarCheckOutDate();
        f.clickCalendarCheckInDate();
        f.clickCalendarForwardArrow();
        f.clickCalendarBackArrow();
        f.clickCalendarDay(Month.FEBRUARY, 10, 2021);
        f.clickCalendarDone();
        f.clickDepartsAsLateAs();
        f.clickCalendarCheckInDate();
        f.clickCalendarCheckOutDate();
        f.clickCalendarForwardArrow();
        f.clickCalendarBackArrow();
        f.clickCalendarDay(Month.FEBRUARY, 20, 2021);
        f.clickCalendarDone();
    }
}
