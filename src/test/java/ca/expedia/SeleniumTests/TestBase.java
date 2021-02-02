package ca.expedia.SeleniumTests;
import ca.expedia.SeleniumTests.PageFactory.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public abstract class TestBase implements ITestListener {
    protected static URL gridHubUrl = null;
    protected static String baseUrl;
    protected static Capabilities capabilities;
    protected final String SCREENSHOT_DIRECTORY = "C:/Users/Daniel/Desktop/ExtentReports/";
    protected final String SCREENSHOT_DATE_TIME_FORMAT = "yyyy_dd_MMM-HH_mm_ss";
    protected WebDriver driver;
    protected ExtentReports report;
    protected ExtentTest test;
    protected String reportName;
    protected String originalWindowHandle;
    protected StaysFactory sta;
    protected FlightsFactory fli;
    protected CarsFactory car;
    protected VacationFactory vac;
    protected AllInclusiveFactory all;
    protected ThingsToDoFactory ttd;
    protected CruisesFactory cru;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext context) throws IOException {
        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        capabilities = config.getCapabilities();
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        String className = result.getMethod().getRealClass().getSimpleName();
        String description = result.getMethod().getDescription();
        report = ExtentReportsConfig.getInstance(className, false);
        test = ExtentReportsConfig.createTestReport(report, description);

        driver.get(baseUrl);
        originalWindowHandle = driver.getWindowHandle();
        switch (className) {
            case "StaysTest":
                sta = new StaysFactory(driver, test);
                break;
            case "FlightsTest":
                fli = new FlightsFactory(driver, test);
                break;
            case "CarsTest":
                car = new CarsFactory(driver, test);
                break;
            case "VacationTest":
                vac = new VacationFactory(driver, test);
                break;
            case "AllInclusiveTest":
                all = new AllInclusiveFactory(driver, test);
                break;
            case "ThingsToDoTest":
                ttd = new ThingsToDoFactory(driver, test);
                break;
            case "CruisesTest":
                cru = new CruisesFactory(driver, test);
                break;
        }
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
            String path = ExtentReportsConfig.takeScreenshotReturnPath(driver, SCREENSHOT_DIRECTORY + reportName + "\\", testResult.getMethod().getMethodName() + "-failure-" + dtf.format(now));
            // Format the path of the screenshot so that it may be attached to an Extent
            // Reports HTML document for review.
            String imagePath = test.addScreenCapture(path);
            // Log the failure message and the screenshot.
            test.log(LogStatus.FAIL, testResult.getMethod().getMethodName() + " has failed.");
            test.log(LogStatus.FAIL, imagePath);
        } else if (testResult.getStatus() == ITestResult.SUCCESS) {
            //Log pass message on success.
            test.log(LogStatus.PASS, testResult.getMethod().getMethodName() + " has passed.");
        }

        //Stop reporting for the test and flush it so that the report document will be updated with the test results.
        report.endTest(test);
        report.flush();
    }

    @AfterClass
    public void afterClass() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}
