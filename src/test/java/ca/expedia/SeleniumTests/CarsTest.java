package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.StaysFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import ca.expedia.SeleniumTests.PageFactory.CarsFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class CarsTest extends TestBase {
    private CarsFactory f;
    private ExtentReports report;
    private ExtentTest test;
    private final String REPORT_NAME = "carsTab";
    private String originalWindowHandle;

    @BeforeMethod
    public void beforeMethod() {
        report = ExtentReportsConfig.getInstance(REPORT_NAME, false);
        f = new CarsFactory(driver);
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
            String path = f.takeScreenshotReturnPath(driver, SCREENSHOT_DIRECTORY +  REPORT_NAME + "\\", testResult.getMethod().getMethodName() + "-failure-" + dtf.format(now));
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
    public void carsTest() {
        f.createTestReport(report,"Cars Test");
        f.clickCarsTab();
        f.clickAirportTab();
        f.clickRentalTab();
        f.clickPickUp();
        f.sendKeysPickUp("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickSameAsPickup();
        f.sendKeysSameAsPickUp("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickPickUpDate();
        f.clickCalendarForwardArrow();
        f.clickCalendarDay(Month.MARCH, 19, 2021);
        f.clickCalendarDone();
        f.clickDropOffDate();
        f.clickCalendarForwardArrow();
        f.clickCalendarDay(Month.APRIL, 9, 2021);
        f.clickCalendarDone();
        f.selectPickUpTime("15:00");
        f.selectDropOffTime("22:15");
        f.clickIHaveADiscountCode();
        f.clickIHaveADiscountCode();
        f.clickIHaveADiscountCode();
        f.selectRentalCarCompany("Thrifty Car Rental");
        f.selectDiscountType("Special or advertised");
        f.sendKeysCouponInput1("Test1");
        f.sendKeysCouponInput2("Test2");
        f.sendKeysCouponInput3("Test3");
        f.clickAirportTab();
        f.clickAirportButton();
        f.sendKeysAirportInput("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickHotelNameButton();
        f.sendKeysHotelNameInput("Toronto");
        f.clickSearchResult("Hotel Toronto", "New Delhi, National Capital Territory of Delhi, India");
        f.clickFlightArrivalDate();
        f.clickCalendarDay(Month.MARCH, 20, 2021);
        f.clickCalendarDone();
        f.selectFlightArrivalTime("16:30");
        f.clickBookRoundtrip();
        f.clickFlightDepartureDate();
        f.clickCalendarDay(Month.MARCH, 25, 2021);
        f.clickCalendarDone();
        f.selectFlightDepratureTime("19:30");
        f.clickTraveller();
        f.clickTravellersAdultsInc();
        f.clickTravellersAdultsInc();
        f.clickTravellersChildrenInc();
        f.clickTravellersChildrenInc();
        f.clickTravellersInfantsInc();
        f.clickTravellersInfantsInc();
        f.clickTravellersAdultsDec();
        f.clickTravellersChildrenDec();
        f.clickTravellersInfantsDec();
        f.clickTravellersDone();
        f.clickSwapAirportHotel();
    }
}
