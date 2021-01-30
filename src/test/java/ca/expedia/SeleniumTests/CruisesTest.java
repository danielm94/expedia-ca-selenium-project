package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.StaysFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import ca.expedia.SeleniumTests.PageFactory.CruisesFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class CruisesTest extends TestBase{
	private CruisesFactory f;
	private ExtentReports report;
	private ExtentTest test;
	private final String REPORT_NAME = "cruises-tab";
	private String originalWindowHandle;

	@BeforeMethod
	public void beforeMethod() {
		report = ExtentReportsConfig.getInstance(REPORT_NAME, false);
		f = new CruisesFactory(driver);
		driver.get(baseUrl);
		originalWindowHandle = driver.getWindowHandle();
	}
	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		driver.switchTo().window(originalWindowHandle);
		// After each test, determine whether or not it passed with ITestResult.
		if (testResult.getStatus() == ITestResult.FAILURE) {
			//Create DateTimeFormatter and LocalDateTime so that we may append the current date and time to our screenshots.
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(SCREENSHOT_DATE_TIME_FORMAT);
			LocalDateTime now = LocalDateTime.now();
			// If it failed, take a screenshot at the moment of failure and return the path
			// of said screenshot with f.takeScreenshotReturnPath().
			String path = f.takeScreenshotReturnPath(driver, SCREENSHOT_DIRECTORY + REPORT_NAME + "\\", testResult.getMethod().getMethodName() + "-failure-" + dtf.format(now));
			// Format the path of the screenshot so that it may be attached to an Extent
			// Reports HTML document for review.
			String imagePath = f.formatScreenshotPath(path);
			// Log the failure message and the screenshot.
			f.log(LogStatus.FAIL, testResult.getMethod().getMethodName() + " has failed.");
			f.log(LogStatus.FAIL, imagePath);
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			//Log pass message on success.
			f.log(LogStatus.PASS, testResult.getMethod().getMethodName() + " has passed.");
		}
		//Stop reporting for the test and flush it so that the report document will be updated with the test results.
		report.endTest(test);
		report.flush();
	}

	@Test(enabled = true)
	public void cruisesDemo() {
		f.createTestReport(report,"Cruises Demo");
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
		f.clickCalendarDay(Month.JANUARY, 30, 2021);
		f.clickCalendarDone();
		f.clickDepartsAsLateAs();
		f.clickCalendarCheckInDate();
		f.clickCalendarCheckOutDate();
		f.clickCalendarForwardArrow();
		f.clickCalendarBackArrow();
		f.clickCalendarDay(Month.FEBRUARY, 15, 2021);
		f.clickCalendarDone();
	}
}
