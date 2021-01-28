package ca.expedia.SeleniumTests;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportsConfig {
    public static ExtentReports getInstance(String reportName, boolean overwriteReport) {
        String path = "C:\\Users\\Daniel\\Desktop\\ExtentReports\\" + reportName + "\\" + reportName + ".html";
        ExtentReports extent = new ExtentReports(path, overwriteReport);
        extent.addSystemInfo("Selenium Version", "3.141.59")
                .addSystemInfo("OS", "Windows 10");
        return extent;
    }
}
