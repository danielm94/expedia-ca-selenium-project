package ca.expedia.SeleniumTests.FactoryBase;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
//TODO: ADD JAVADOC FOR ALL CLASSES.

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
     * Finds an element by using an ExpectedCondition that returns a WebElement.
     *
     * @param condition The desired ExpectedCondition that returns a WebElement.
     * @param timeout   The time in seconds to wait for the element before throwing a TimeOutException.
     * @return WebElement
     */
    public WebElement find(ExpectedCondition<WebElement> condition, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(condition);
    }

    /**
     * Waits for an element to be clickable before clicking on it.
     *
     * @param element The WebElement you'd like to click.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     */
    public void click(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Waits for an element to be clickable by using a locator before clicking on it.
     *
     * @param locator The locator to find the WebElement with.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     */
    public void click(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Waits for an element to be clickable before clicking on it.
     *
     * @param element The WebElement you'd like to click.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log     The message to log after successfully clicking the WebElement.
     */
    public void click(WebElement element, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log(LogStatus.INFO, log);
    }

    /**
     * Waits for an element to be clickable by using a locator before clicking on it.
     *
     * @param locator The locator to find the WebElement with.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log     The message to log after successfully clicking the WebElement.
     */
    public void click(By locator, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        log(LogStatus.INFO, log);
    }


    /**
     * Waits for an element using an ExpectedCondition that returns a WebElement before clicking on it.
     *
     * @param condition The desired ExpectedCondition that returns a WebElement.
     * @param timeout   The time in seconds to wait for the element before throwing a TimeOutException.
     */
    public void click(ExpectedCondition<WebElement> condition, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition).click();
    }

    /**
     * Waits for an element using an ExpectedCondition that returns a WebElement before clicking on it.
     *
     * @param condition The desired ExpectedCondition that returns a WebElement.
     * @param timeout   The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log       The message to log after successfully clicking the WebElement.
     */
    public void click(ExpectedCondition<WebElement> condition, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition).click();
        log(LogStatus.INFO, log);
    }

    /**
     * Waits for an element using an ExpectedCondition that returns a boolean before clicking on it.
     *
     * @param element   The WebElement you wish to click.
     * @param condition The desired ExpectedCondition that returns a Boolean.
     * @param timeout   The time in seconds to wait for the element before throwing a TimeOutException.
     */
    public void click(WebElement element, ExpectedCondition<Boolean> condition, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
        element.click();
    }

    /**
     * Waits for an element using an ExpectedCondition that returns a boolean before clicking on it.
     *
     * @param element   The WebElement you wish to click.
     * @param condition The desired ExpectedCondition that returns a Boolean.
     * @param timeout   The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log       The message to log after successfully clicking the WebElement.
     */
    public void click(WebElement element, ExpectedCondition<Boolean> condition, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
        element.click();
        log(LogStatus.INFO, log);
    }

    /**
     * Waits for an element using an ExpectedCondition that returns a boolean before clicking on it using a locator.
     *
     * @param locator   The locator to find the WebElement with.
     * @param condition The desired ExpectedCondition that returns a Boolean.
     * @param timeout   The time in seconds to wait for the element before throwing a TimeOutException.
     */
    public void click(By locator, ExpectedCondition<Boolean> condition, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
        find(locator).click();
    }

    /**
     * Waits for an element using an ExpectedCondition that returns a boolean before clicking on it using a locator.
     *
     * @param locator   The locator to find the WebElement with.
     * @param condition The desired ExpectedCondition that returns a Boolean.
     * @param timeout   The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log       The message to log after successfully clicking the WebElement.
     */
    public void click(By locator, ExpectedCondition<Boolean> condition, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
        find(locator).click();
        log(LogStatus.INFO, log);
    }

    /**
     * Waits for element to be clickable.
     *
     * @param element The element to evaluate.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log     The message to log if the element was clickable within the expected time.
     * @return True if the element was clickable within the expected time, else false.
     */
    public Boolean waitUntilClickable(WebElement element, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            log(LogStatus.INFO, log);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Waits for element to be clickable.
     *
     * @param locator The locator to evaluate the element with.
     * @param timeout The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log     The message to log if the element was clickable within the expected time.
     * @return True if the element was clickable within the expected time, else false.
     */
    public Boolean waitUntilClickable(By locator, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            log(LogStatus.INFO, log);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
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
     * Returns the current URL of the page as a String.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
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
     * Uses a custom ExpectedCondition that returns an a WebElement to find the visible text of said element.
     *
     * @param condition The desired ExpectedCondition that returns a WebElement
     * @param timeout   The time in seconds to wait for the element before throwing a TimeOutException.
     * @return The visible text of an element as a string.
     */
    public String getText(ExpectedCondition<WebElement> condition, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(condition).getText();
    }

    /**
     * Uses a custom ExpectedCondition that returns an a WebElement to find the visible text of said element.
     *
     * @param condition The desired ExpectedCondition that returns a WebElement
     * @param timeout   The time in seconds to wait for the element before throwing a TimeOutException.
     * @param log       The message to log if the element was found. ": " + the the found text is concatenated
     * @return The visible text of an element as a string.
     */
    public String getText(ExpectedCondition<WebElement> condition, long timeout, String log) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String text = wait.until(condition).getText();
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

    //TODO: ADD JAVADOC
    public Boolean waitUntilInvisible(By locator, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Clicks on the header of the website in order to close a menu.
     */
    public void clickOffMenu() {
        click(ExpectedConditions.elementToBeClickable(clickOffMenuLocation), 5);
    }

    /**
     * Clicks the blue "Search" button so that we may submit our information.
     */
    public void clickSearchButton() {
        click(ExpectedConditions.elementToBeClickable(searchButton), 5, "Clicked on the 'Search' button.");
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
        click(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)),
                5, "Clicked on search result: '" + city + ", " + region + "'");
    }
}
