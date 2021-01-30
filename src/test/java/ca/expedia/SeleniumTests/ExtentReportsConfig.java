package ca.expedia.SeleniumTests;

import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReportsConfig {
    public static ExtentReports getInstance(String reportName, boolean overwriteReport) {
        String path = "C:\\Users\\Daniel\\Desktop\\ExtentReports\\" + reportName + "\\" + reportName + ".html";
        ExtentReports extent = new ExtentReports(path, overwriteReport);
        extent.addSystemInfo("Selenium Version", "3.141.59")
                .addSystemInfo("OS", "Windows 10");
        return extent;
    }

    /**
     * Takes a screenshot of the browser window and returns its file path as a string.
     *
     * @param driver   The WebDriver instance.
     * @param fileName The file name the screenshot will be saved as.
     * @return The file path of the screenshot that will be taken.
     */
    public static String takeScreenshotReturnPath(WebDriver driver, String directory, String fileName) throws IOException {
        fileName = fileName + ".png";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        return directory + fileName;
    }
}
