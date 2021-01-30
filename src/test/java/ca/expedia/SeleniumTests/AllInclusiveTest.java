package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.AllInclusiveFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;

public class AllInclusiveTest extends TestBase {
	private AllInclusiveFactory f;

	@BeforeMethod
	public void beforeMethod() {
		reportName = "all-inclusive-tab";
		f = new AllInclusiveFactory(driver);
		super.beforeMethod();
	}

	@Test()
	public void allInclusiveTest() {
		test = f.createTestReport(report,"All Inclusive Test");
		f.clickAllInclusiveVacationsTab();
		f.selectLeavingFrom("Toronto");
		f.selectGoingTo("Bermuda");
		f.clickDeparting();
		f.clickCalendarCheckInDate();
		f.clickCalendarForwardArrow();
		f.clickCalendarForwardArrow();
		f.clickCalendarBackArrow();
		f.clickCalendarDay(Month.FEBRUARY, 24, 2021);
		f.clickCalendarDone();
		f.selectVacationLength("7 days");
		f.clickTraveller();
		for (int x = 0; x < 12; x++) {
			f.clickTravellersAdultsInc();
			if (x < 6) {
				f.clickTravellersChildrenInc();
				f.selectChildAge(x + 1, x + 1);
			}
		}
		for (int x = 0; x < 13; x++) {
			f.clickTravellersAdultsDec();
			if (x < 6) {
				f.clickTravellersChildrenDec();
			}
		}
		f.clickTravellersDone();
		f.clickBookFor10();
	}
}
