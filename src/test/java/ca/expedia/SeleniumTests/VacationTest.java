package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.StaysFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import ca.expedia.SeleniumTests.PageFactory.VacationFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class VacationTest extends TestBase {
    private VacationFactory f;
    private ExtentReports report;
    private ExtentTest test;
    private final String REPORT_NAME = "vacation-tab";
    private String originalWindowHandle;

    @BeforeMethod
    public void beforeMethod() {
        report = ExtentReportsConfig.getInstance(REPORT_NAME, false);
        f = new VacationFactory(driver);
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
    public void vacationTabDemo() {
        f.createTestReport(report,"Vacation Tab Demo");
        f.clickVacationPackagesTab();
        f.clickFlightsSubTab();
        f.clickStaysSubTab();
        f.clickCarsSubTab();
        f.clickFlightsSubTab();
        f.clickStaysSubTab();
        f.clickLeavingFrom();
        f.sendKeysLeavingFrom("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickGoingTo();
        f.sendKeysGoingTo("Toronto");
        f.clickSearchResult("Toronto", "Ontario, Canada");
        f.clickAccommodationsCheckbox();
        f.clickDepartingButton();
        f.clickCalendarDay(Month.JANUARY, 26, 2021);
        f.clickCalendarDone();
        f.clickReturningButton();
        f.clickCalendarDay(Month.JANUARY, 27, 2021);
        f.clickCalendarDone();
        f.clickCheckIn();
        f.clickCalendarDay(Month.JANUARY, 28, 2021);
        f.clickCalendarDone();
        f.clickCheckOut();
        f.clickCalendarDay(Month.JANUARY, 29, 2021);
        f.clickCalendarDone();
        f.clickPreferredClass();
        f.clickFirstClass();
        f.clickPreferredClass();
        f.clickBusinessClass();
        f.clickPreferredClass();
        f.clickPremiumEconomy();
        f.clickPreferredClass();
        f.clickEconomy();
    }

    @Test(enabled = false)
    public void travellerTest() {
        f.createTestReport(report,"Traveller Test");
        f.clickVacationPackagesTab();
        f.clickTraveler();
        // Add 5 rooms
        for (int x = 0; x < 5; x++) {
            f.clickTravellersAddRoom();
        }
        // Set the number of adults, children and infants to 6 in all the rooms.
        for (int room = 1; room < 7; room++) {
            while (f.getTravellerAdultCount(room) != 6) {
                f.clickTravellersAdultsInc(room);
            }
            while (f.getTravellerChildCount(room) != 6) {
                f.clickTravellersChildrenInc(room);
            }
            while (f.getTravellerInfantCount(room) != 6) {
                f.clickTravellersInfantsInc(room);
            }
        }

        // Set the age of the children in each room from 5-10. (Child 1 = 5, Child 2 =
        // 6, Child 3 = 7, etc.)
        // Set the age of every 2nd infant in each room to 1, else set it to under 1.
        for (int room = 1; room < 7; room++) {
            for (int x = 1; x < 7; x++) {
                f.selectChildAge(room, x, Integer.toString(x + 4));
                if (x % 2 == 0) {
                    f.selectInfantAge(room, x, 1);
                } else {
                    f.selectInfantAge(room, x, 0);
                }
            }
        }
        // Set the number of adults to 1.
        // Set the number of children and infants to 0.
        for (int room = 6; room > 0; room--) {
            while (f.getTravellerAdultCount(room) != 1) {
                f.clickTravellersAdultsDec(room);
            }
            while (f.getTravellerChildCount(room) != 0) {
                f.clickTravellersChildrenDec(room);
            }
            while (f.getTravellerInfantCount(room) != 0) {
                f.clickTravellersInfantsDec(room);
            }
        }
        // Remove all the rooms
        for (int room = 6; room > 1; room--) {
            f.clickTravellersRemoveRoom(room);
        }
        f.clickTravellersInfantsInc(1);
        f.clickChildInSeat();
        f.clickChildOnLap();
        f.clickTravellersDone();
        f.clickTraveler();
        f.clickAirlineAgeRules();
    }
}
