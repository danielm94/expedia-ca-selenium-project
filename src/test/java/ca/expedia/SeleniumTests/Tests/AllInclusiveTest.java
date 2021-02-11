package ca.expedia.SeleniumTests.Tests;

import ca.expedia.SeleniumTests.PageFactory.AllInclusiveFactory;
import ca.expedia.SeleniumTests.PageFactory.CalendarFactory;
import ca.expedia.SeleniumTests.PageFactory.TabFactory;
import ca.expedia.SeleniumTests.PageFactory.TravellersFactory;
import ca.expedia.SeleniumTests.SetUp.CommonTestBase;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;

public class AllInclusiveTest extends CommonTestBase {
    private AllInclusiveFactory all;
    private TabFactory tab;
    private CalendarFactory cal;
    private TravellersFactory travel;

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        super.beforeMethod(result);
        all = new AllInclusiveFactory(driver, test, 5);
        tab = new TabFactory(driver, test, 5);
        cal = new CalendarFactory(driver, test, 5);
        travel = new TravellersFactory(driver, test, 5);
    }

    @Test(description = "All Inclusive Test")
    public void allInclusiveTest(){
        tab.clickAllInclusiveVacationsTab();
        all.selectLeavingFrom("Toronto");
        all.selectGoingTo("Bermuda");
        all.clickDeparting();
        cal.clickCalendarCheckInDate();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarForwardArrow();
        cal.clickCalendarBackArrow();
        cal.clickCalendarDay(Month.FEBRUARY, 24, 2021);
        cal.clickDone();
        all.selectVacationLength("7 days");
        travel.clickTravellersAnchorTag();
        for (int x = 0; x < 12; x++) {
            travel.clickAdultsIncrease();
            if (x < 6) {
                travel.clickChildrenIncrease();
                travel.selectChildAge(x + 1, x + 1);
            }
        }
        for (int x = 0; x < 13; x++) {
            travel.clickAdultsDecrease();
            if (x < 6) {
                travel.clickChildrenDecrease();
            }
        }
        travel.clickDoneButton();
        all.clickBookFor10();
    }
}
