package ca.expedia.SeleniumTests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ca.expedia.SeleniumTests.PageFactory.FlightsFactory;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class FlightsTest extends TestBase {
    private FlightsFactory f;
    private ExtentReports report;
    private ExtentTest test;
    private final String REPORT_NAME = "flights_tab";
    private String originalWindowHandle;

    @BeforeMethod
    public void beforeMethod() {
        report = ExtentReportsConfig.getInstance(REPORT_NAME, false);
        f = new FlightsFactory(driver);
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
    public void flightsTabTest() {
        f.createTestReport(report, "Flights Tab Test");
        f.clickFlightsTab();
        f.clickLeavingFrom();
        f.sendKeysLeaving("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickGoingTo();
        f.sendKeysGoing("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickDeparting();
        f.clickCalendarCheckInDate();
        f.clickCalendarDay(Month.FEBRUARY, 5, 2021);
        f.clickCalendarDone();
        f.clickReturning();
        f.clickCalendarCheckOutDate();
        f.clickCalendarForwardArrow();
        f.clickCalendarBackArrow();
        f.clickCalendarDay(Month.FEBRUARY, 9, 2021);
        f.clickCalendarDone();
        f.clickPreferredClass();
        f.clickPremiumEconomy();
        f.clickOneWay();
        f.clickLeavingFrom();
        f.sendKeysLeaving("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickGoingTo();
        f.sendKeysGoing("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickDeparting();
        f.clickCalendarCheckInDate();
        f.clickCalendarDay(Month.FEBRUARY, 9, 2021);
        f.clickCalendarDone();
        f.clickPreferredClass();
        f.clickPremiumEconomy();
        f.clickTraveller();
        for (int x = 0; x < 5; x++) {
            f.clickTravellersChildrenInc();
        }
        f.selectChildAge(1, 2);
        f.selectChildAge(2, 3);
        f.selectChildAge(3, 10);
        f.selectChildAge(4, 9);
        f.selectChildAge(5, 7);
        for (int x = 0; x < 5; x++) {
            f.clickTravellersChildrenDec();
        }
        for (int x = 0; x < 5; x++) {
            f.clickTravellersInfantsInc();
        }
        f.selectInfantAge(1, 1);
        f.selectInfantAge(2, 1);
        f.selectInfantAge(3, 1);
        f.selectInfantAge(4, 1);
        f.selectInfantAge(5, 1);
        f.selectInfantAge(5, 0);
        f.clickTravellersInSeat();
        f.clickTravellersOnLap();
        f.clickAirlineAgeRules();
        f.clickTravellersDone();
    }

    @Test()
    public void mutliCityTest() {
        f.createTestReport(report, "Multi City Test");
        f.clickFlightsTab();
        f.clickMultiCity();
        for (int x = 0; x < 3; x++) {
            f.clickAddAnotherFlight();
        }
        f.clickMultiCityLeavingFrom(1);
        f.sendKeysMultiCityLeaving("Delhi", 1);
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickMultiCityGoingTo(1);
        f.sendKeysMultiCityGoing("Toronto", 1);
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickMultiCityDeparting(1);
        f.clickCalendarDay(Month.FEBRUARY, 8, 2021);
        f.clickCalendarDone();
        f.clickMultiCityLeavingFrom(2);
        f.sendKeysMultiCityLeaving("Delhi", 2);
        f.clickSearchResult("London (YXU - London Intl.)", "Near Delhi, Ontario, Canada");
        f.clickMultiCityGoingTo(2);
        f.sendKeysMultiCityGoing("Toronto", 2);
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickMultiCityDeparting(2);
        f.clickCalendarDay(Month.FEBRUARY, 9, 2021);
        f.clickCalendarDone();
        f.clickMultiCityLeavingFrom(3);
        f.sendKeysMultiCityLeaving("Delhi", 3);
        f.clickSearchResult("London (YXU - London Intl.)", "Near Delhi, Ontario, Canada");
        f.clickMultiCityGoingTo(3);
        f.sendKeysMultiCityGoing("Toronto", 3);
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickMultiCityDeparting(3);
        f.clickCalendarDay(Month.FEBRUARY, 10, 2021);
        f.clickCalendarDone();
        f.clickMultiCityLeavingFrom(4);
        f.sendKeysMultiCityLeaving("Delhi", 4);
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickMultiCityGoingTo(4);
        f.sendKeysMultiCityGoing("Toronto", 4);
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickMultiCityDeparting(4);
        f.clickCalendarDay(Month.FEBRUARY, 11, 2021);
        f.clickCalendarDone();
        f.clickMultiCityLeavingFrom(5);
        f.sendKeysMultiCityLeaving("Delhi", 5);
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickMultiCityGoingTo(5);
        f.sendKeysMultiCityGoing("Toronto", 5);
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickMultiCityDeparting(5);
        f.clickCalendarDay(Month.FEBRUARY, 12, 2021);
        f.clickCalendarDone();
    }
}
