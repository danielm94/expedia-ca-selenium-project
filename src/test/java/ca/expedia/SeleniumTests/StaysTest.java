package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.StaysFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class StaysTest extends TestBase {
    private StaysFactory f;
    private ExtentReports report;
    private ExtentTest test;
    private final String REPORT_NAME = "stays-tab";
    private String originalWindowHandle;

    @BeforeMethod
    public void beforeMethod() {
        report = ExtentReportsConfig.getInstance(REPORT_NAME, false);
        f = new StaysFactory(driver);
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
    public void basicTest() {
        f.createTestReport(report, "Basic Test");
        f.clickStaysTab();
        f.clickGoingTo();
        f.sendKeysGoingTo("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickCheckIn();
        f.clickCalendarCheckInDate();
        f.clickCalendarDay(Month.FEBRUARY, 22, 2021);
        f.clickCalendarCheckOutDate();
        f.clickCalendarDay(Month.FEBRUARY, 24, 2021);
        f.clickCalendarDone();
        f.clickTravellersButton();
        f.clickTravellersAddRoom();
        f.clickTravellersAddRoom();
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.selectChildAge(3, 1, 15);
        f.selectChildAge(3, 2, 17);
        f.selectChildAge(3, 3, 4);
        f.selectChildAge(3, 4, 9);
        f.selectChildAge(3, 5, 4);
        f.selectChildAge(3, 6, 10);
    }

    @Test(enabled = true)
    public void leavingFromTest() {
        f.createTestReport(report, "Leaving From Test");
        f.clickStaysTab();
        f.clickAddFlight();
        f.clickLeavingFrom();
        f.sendKeysLeavingFrom("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickAddCar();
    }

    @Test
    public void assertUserCannotAccessPastMonth() {
        f.createTestReport(report, "Assert User Cannot Access A Month That Is In The Past");
        f.clickStaysTab();
        f.clickCheckIn();
        f.navigateToPresentMonth();
        Assert.assertTrue(f.isCalendarBackArrowDisabled());
    }

    @Test
    public void assertUserCannotAccessMonth500DaysAhead() {
        LocalDate fiveHundredDaysAhead = LocalDate.now().plusDays(500);
        f.createTestReport(report, "Assert User Cannot Access Month That Is Over 500 Days Ahead.");
        f.clickStaysTab();
        f.clickCheckIn();
        f.navigateToMonth(fiveHundredDaysAhead.getMonth(), fiveHundredDaysAhead.getYear());
        Assert.assertTrue(f.isCalendarForwardArrowDisabled());
    }

    @Test
    public void assertUserCannotSelectDayInPast() {
        f.createTestReport(report, "Assert User Cannot Select A Calendar Day That Is In The Past");
        f.clickStaysTab();
        f.clickCheckIn();
        f.navigateToPresentMonth();
        Assert.assertTrue(f.isUserUnableToSelectDayInPast());
    }

    @Test
    public void assertUserCannotSelectDaysThatAre500DaysInFuture() {
        LocalDate fiveHundredDaysAhead = LocalDate.now().plusDays(500);
        f.createTestReport(report, "Assert User Cannot Select A Day That Is Over 500 Days In The Future");
        f.clickStaysTab();
        f.clickCheckIn();
        f.navigateToMonth(fiveHundredDaysAhead.getMonth(), fiveHundredDaysAhead.getYear());
        Assert.assertTrue(f.isUserUnableToSelectDayOver500InFuture(fiveHundredDaysAhead));
    }

    @Test
    public void assertCalendarDaysAreHighlightedCorrectly() {
        LocalDate presentDate = LocalDate.now();
        LocalDate date500DaysIntoFuture = LocalDate.now().plusDays(500);
        f.createTestReport(report, "Assert Calendar Days Are Highlighted Correctly");
        f.clickStaysTab();
        f.clickCheckIn();
        f.clickCalendarDayAfterNavigating(presentDate.getMonth(), presentDate.getDayOfMonth(), presentDate.getYear());
        f.clickCalendarDayAfterNavigating(date500DaysIntoFuture.getMonth(),
                date500DaysIntoFuture.getDayOfMonth(), date500DaysIntoFuture.getYear());
        Assert.assertTrue(f.isCalendarHighlightingDaysCorrectly(presentDate, date500DaysIntoFuture));
    }

    @Test
    public void assertUserCanClearGoingToFieldWithXButton(){
        f.createTestReport(report,"Assert User Can Clear Going To Field With 'x' Button");
        f.clickStaysTab();
        f.clickGoingTo();
        f.sendKeysGoingTo("Toronto");
        f.clickGoingToClear();
        Assert.assertEquals(f.getGoingToInputValue(),"");
        f.sendKeysGoingTo("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickGoingTo();
        f.clickGoingToClear();
        Assert.assertEquals(f.getGoingToInputValue(),"");
        f.clickOffMenu();
        Assert.assertEquals(f.getGoingToButtonText(),"");
    }

    @Test
    public void assertUserCanClearLeavingFromFieldWithXButton(){
        f.createTestReport(report,"Assert User Can Clear Leaving From Field With 'x' Button");
        f.clickStaysTab();
        f.clickAddFlight();
        f.clickLeavingFrom();
        f.sendKeysLeavingFrom("Toronto");
        f.clickLeavingFromClear();
        Assert.assertEquals(f.getLeavingFromInputValue(),"");
        f.sendKeysLeavingFrom("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickLeavingFrom();
        f.clickLeavingFromClear();
        Assert.assertEquals(f.getLeavingFromInputValue(),"");
        f.clickOffMenu();
        Assert.assertEquals(f.getLeavingFromButtonText(),"");
    }
    @Test()
    public void assertCorrectNumberOfRoomsAreDisplayed() {
        f.createTestReport(report,"Assert The Correct Number of Rooms Are Displayed For Travellers");
        f.clickStaysTab();
        Assert.assertEquals(f.getTravellersText(), "1 room, 2 travellers");
        f.clickTravellersButton();
        Assert.assertTrue(f.isTravellersPanelDisplayingRooms(1));
        Assert.assertEquals(f.getTravellersDoneButtonSubText(), "1 room, 2 travellers");
        f.clickTravellersAddRoom();
    }
}
