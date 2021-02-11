package ca.expedia.SeleniumTests.SetUp;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
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

//TODO: REPLACE ALL INSTANCES OF SELECT METHODS WITH WEBELEMENT METHODS
public class CommonTestBase extends AbstractTestNGCucumberTests implements ITestListener {
    protected static URL gridHubUrl;
    protected static String baseUrl;
    protected static Capabilities capabilities;
    protected final String SCREENSHOT_DIRECTORY = System.getProperty("user.dir")+"\\target\\Extent_Reports\\";
    protected final String SCREENSHOT_DATE_TIME_FORMAT = "yyyy_dd_MMM-HH_mm_ss";
    protected WebDriver driver;
    protected ExtentReports report;
    protected ExtentTest test;
    protected String reportName;
    protected String originalWindowHandle;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws IOException {
        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        capabilities = config.getCapabilities();
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        String className = result.getMethod().getRealClass().getSimpleName();
        String description = result.getMethod().getDescription();
        report = ExtentReportsConfig.getInstance(className, false);
        test = ExtentReportsConfig.createTestReport(report, description);
        driver.get(baseUrl);
        originalWindowHandle = driver.getWindowHandle();
        driver.manage().deleteAllCookies();
        }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        driver.switchTo().window(originalWindowHandle);
        String className = result.getMethod().getRealClass().getSimpleName();
        // After each test, determine whether or not it passed with ITestResult.
        if (result.getStatus() == ITestResult.FAILURE) {
            //Create DateTimeFormatter and LocalDateTime so that we may append the current date and time to our screenshots.
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(SCREENSHOT_DATE_TIME_FORMAT);
            LocalDateTime now = LocalDateTime.now();
            // If it failed, take a screenshot at the moment of failure and return the path
            // of said screenshot with f.takeScreenshotReturnPath().
            String path = ExtentReportsConfig.takeScreenshotReturnPath(driver, SCREENSHOT_DIRECTORY + className + "\\", result.getMethod().getMethodName() + "-failure-" + dtf.format(now));
            // Format the path of the screenshot so that it may be attached to an Extent
            // Reports HTML document for review.
            String imagePath = test.addScreenCapture(path);
            // Log the failure message and the screenshot.
            test.log(LogStatus.ERROR,result.getThrowable().getMessage());
            test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " has failed.");
            test.log(LogStatus.FAIL, imagePath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            //Log pass message on success.
            test.log(LogStatus.PASS, result.getMethod().getMethodName() + " has passed.");
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
