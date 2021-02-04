package ca.expedia.SeleniumTests.FactoryBase;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class PageFactoryBase {
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    protected WebElement searchButton;
    @FindBy(xpath = "//section[@class='header-region no-stripe']")
    protected WebElement clickOffMenuLocation;
    private WebDriver driver;
    private ExtentTest test;

    public PageFactoryBase(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }


    /**
     * Logs messages in the ExtentReports report.
     *
     * @param status  The status of the log. E.g., 'LogStatus.INFO', 'LogStatus.ERROR'
     * @param message The message inside the log.
     */
    public void log(LogStatus status, String message) {
        test.log(status, message);
    }

    /**
     * Takes a screenshot of the browser window.
     *
     * @param driver   The WebDriver instance.
     * @param fileName The file name the screenshot will be saved as.
     */
    public void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        fileName = fileName + ".png";
        String directory = "C:/Users/Daniel/Desktop/ExtentReports/";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
    }

    /**
     * Takes a screenshot of the browser window and returns its file path as a string.
     *
     * @param driver   The WebDriver instance.
     * @param fileName The file name the screenshot will be saved as.
     * @return The file path of the screenshot that will be taken.
     */
    public String takeScreenshotReturnPath(WebDriver driver, String directory, String fileName) throws IOException {
        fileName = fileName + ".png";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        return directory + fileName;
    }

    /**
     * Formats the file path of a screenshot so that it may be added to the Extent Reports HTML document as a log.
     *
     * @param path The path of the screenshot.
     * @return The formatted screenshot path as a string.
     */
    public String formatScreenshotPath(String path) {
        return test.addScreenCapture(path);
    }

    /**
     * Finds an element by using a locator.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @return WebElement
     */
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Finds an element by using a locator.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @return WebElement
     */
    public WebElement find(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Clicks on a WebElement.
     *
     * @param element The WebElement you wish to click.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     */
    public void click(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    /**
     * Clicks on a WebElement.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     */
    public void click(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    /**
     * Clicks on a WebElement.
     *
     * @param element The WebElement you wish to click.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log     The message you wish to log after performing the action.
     */
    public void click(WebElement element, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log(LogStatus.INFO, log);
    }

    /**
     * Clicks on a WebElement.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log     The message you wish to log after performing the action.
     */
    public void click(By locator, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        log(LogStatus.INFO, log);
    }

    //TODO: ADD JAVADOCS FOR ALL CHECKBOX METHODS
    public void checkBox(WebElement element, long timeout, Boolean isTheBoxChecked) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementSelectionStateToBe(element, isTheBoxChecked));
        element.click();
    }

    public void checkBox(By locator, long timeout, Boolean isTheBoxChecked) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementSelectionStateToBe(locator, isTheBoxChecked));
        driver.findElement(locator).click();
    }

    public void checkBox(WebElement element, long timeout, Boolean isTheBoxChecked, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementSelectionStateToBe(element, isTheBoxChecked));
        element.click();
        log(LogStatus.INFO, log);
    }

    public void checkBox(By locator, long timeout, Boolean isTheBoxChecked, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementSelectionStateToBe(locator, isTheBoxChecked));
        driver.findElement(locator).click();
        log(LogStatus.INFO, log);
    }

    /**
     * Sends keys to an element after clearing it.
     *
     * @param element The WebElement you wish to send keys to.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param keys    The keys to send.
     */
    public void type(WebElement element, long timeout, String keys) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(keys);
    }

    /**
     * Sends keys to an element after clearing it.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param keys    The keys to send.
     */
    public void type(By locator, long timeout, String keys) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(keys);
    }

    /**
     * Sends keys to an element after clearing it.
     *
     * @param element The WebElement you wish to send keys to.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param keys    The keys to send.
     * @param log     The message you wish to log after performing the action.
     */
    public void type(WebElement element, long timeout, String keys, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(keys);
        log(LogStatus.INFO, log);
    }

    /**
     * Sends keys to an element after clearing it.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param keys    The keys to send.
     * @param log     The message you wish to log after performing the action.
     */
    public void type(By locator, long timeout, String keys, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(keys);
        log(LogStatus.INFO, log);
    }

    /**
     * Checks a WebElement to see if it is clickable.
     *
     * @param element The WebElement to evaluate.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @return True if it is clickable before the timeout, else false.
     */
    public Boolean isClickable(WebElement element, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            log(LogStatus.ERROR, e.getMessage());
            return false;
        }
    }

    /**
     * Checks a WebElement to see if it is clickable.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @return True if it is clickable before the timeout, else false.
     */
    public Boolean isClickable(By locator, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (TimeoutException e) {
            log(LogStatus.ERROR, e.getMessage());
            return false;
        }
    }

    /**
     * Returns the title of the current page.
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Returns the visible text of an element.
     *
     * @param element The WebElement to evaluate.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @return The visible text of an element as a string.
     */
    public String getText(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    /**
     * Returns the visible text of an element.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @return The visible text of an element as a string.
     */
    public String getText(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    /**
     * Returns the visible text of an element.
     *
     * @param element The WebElement to evaluate.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log     The message to log if the element was found. ": " + the the found text is concatenated
     * @return The visible text of an element as a string.
     */
    public String getText(WebElement element, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        log(LogStatus.INFO, log + ": " + text);
        return text;
    }

    /**
     * Returns the visible text of an element.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log     The message to log if the element was found. ": " + the the found text is concatenated
     * @return The visible text of an element as a string.
     */
    public String getText(By locator, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        log(LogStatus.INFO, log + ": " + text);
        return text;
    }

    /**
     * Waits before an element is visible before returning it. Useful for situations where you have an element already
     * declared in page factory but you want to make sure it's visible first before doing anything with it.
     *
     * @param element The element you want to evaluate.
     * @param timeOut The time in seconds to wait for the element before throwing a TimeOutException.
     * @return WebElement that is visible.
     */
    public WebElement waitUntilVisible(WebElement element, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits before an element is visible before returning it.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @param timeOut The time in seconds to wait for the element before throwing a TimeOutException.
     * @return WebElement that is visible.
     */
    public WebElement waitUntilVisible(By locator, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Clicks on the header of the website in order to close a menu.
     */
    public void clickOffMenu() {
        click(clickOffMenuLocation, 5);
    }

    /**
     * Clicks the blue "Search" button so that we may submit our information.
     */
    public void clickSearchButton() {
        click(searchButton, 5, "Clicked on the 'Search' button.");
    }

    /**
     * Clicks a search result generated after typing in a location in one of the search fields, (Leaving from, Going to,
     * etc)
     *
     * @param city   - This parameter is the top bolded text that appears in one of the search results. (e.g., New York
     *               (JFK - John F. Kennedy Intl.)
     * @param region - This parameter is the bottom text that appears in one of the search results. (e.g., New York,
     *               United States of America)
     */

    public void clickSearchResult(String city, String region) {
        String xpath = "//button[normalize-space()='" + city + region
                + "' and not(ancestor-or-self::div[@aria-hidden='true'])]";
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        log(LogStatus.INFO, "Clicked on search result: '" + city + ", " + region + "'");
    }
}
