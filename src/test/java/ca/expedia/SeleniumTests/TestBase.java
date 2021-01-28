package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.StaysFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected static URL gridHubUrl = null;
    protected static String baseUrl;
    protected static Capabilities capabilities;
    protected WebDriver driver;
    protected final String SCREENSHOT_DIRECTORY = "C:/Users/Daniel/Desktop/ExtentReports/";
    protected final String SCREENSHOT_DATE_TIME_FORMAT = "yyyy_dd_MMM-HH_mm_ss";

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}
