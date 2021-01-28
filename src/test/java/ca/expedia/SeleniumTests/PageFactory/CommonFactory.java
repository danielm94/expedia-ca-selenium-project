package ca.expedia.SeleniumTests.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public abstract class CommonFactory {
    private WebDriver driver;
    private ExtentTest test;

    @FindBy(xpath = "//div[@class='uitk-grid']/a[@href='/']")
    protected WebElement expediaLogo;

    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']/button")
    protected WebElement moreTravelMenuButton;

    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Hotels']")
    protected WebElement moreTravelMenuStays;

    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Flights']")
    protected WebElement moreTravelMenuFlights;

    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Cars']")
    protected WebElement moreTravelMenuCars;

    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Vacation-Packages']")
    protected WebElement moreTravelMenuPackages;

    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/things-to-do']")
    protected WebElement moreTravelMenuThingsToDo;

    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Cruises']")
    protected WebElement moreTravelMenuCruises;

    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/deals']")
    protected WebElement moreTravelMenuDeals;

    @FindBy(xpath = "//div[text()='Fran�ais']")
    protected WebElement francais;

    @FindBy(id = "listYourProperty")
    protected WebElement listYourProperty;

    @FindBy(id = "support-cs")
    protected WebElement support;

    @FindBy(id = "itinerary")
    protected WebElement trips;

    @FindBy(xpath = "//div[@id='gc-custom-header-nav-bar-acct-menu']/button")
    protected WebElement signInMenuButton;

    @FindBy(xpath = "//div[@class='actions']/a[@data-stid='link-header-account-signin']")
    protected WebElement signInButton;

    @FindBy(xpath = "//div[@class='actions']/a[@data-stid='link-header-account-signup']")
    protected WebElement createAFreeAccount;

    @FindBy(xpath = "//a[@href='/lists']")
    protected WebElement listOfFavorites;

    @FindBy(xpath = "//a[@href='/rewards/howitworks']")
    protected WebElement expediaRewards;

    @FindBy(xpath = "//a[@href='/p/info-other/feedback']")
    protected WebElement feedback;

    /**
     * This button is in the calendar date selector panel. It allows the user to
     * select a check in date.
     */
    @FindBy(xpath = "//div[@class='uitk-flex uitk-flex-align-items-center uitk-toolbar uitk-new-date-picker-toolbar']/section/section/button[@type='button'][1]")
    protected WebElement calendarCheckInButton;

    /**
     * This button is in the calendar date selector panel. It allows the user to
     * select a check out date.
     */
    @FindBy(xpath = "//div[@class='uitk-flex uitk-flex-align-items-center uitk-toolbar uitk-new-date-picker-toolbar']/section/section/button[@type='button'][2]")
    protected WebElement calendarCheckOutButton;

    @FindBy(xpath = "//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-new-date-picker-menu-pagination-container']/button[1]")
    protected WebElement calendarBackArrow;

    @FindBy(xpath = "//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-new-date-picker-menu-pagination-container']/button[2]")
    protected WebElement calendarForwardArrow;

    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    protected WebElement calendarDoneButton;

    @FindBy(xpath = "//button[@data-testid='submit-button']")
    protected WebElement searchButton;

    @FindBy(xpath = "//div[@class='uitk-flex uitk-flex-align-items-center uitk-toolbar uitk-new-date-picker-toolbar']/section/section/button[@type='button'][1]/span")
    protected WebElement calendarCheckInSpan;

    @FindBy(xpath = "//div[@class='uitk-flex uitk-flex-align-items-center uitk-toolbar uitk-new-date-picker-toolbar']/section/section/button[@type='button'][2]/span")
    protected WebElement calendarCheckOutSpan;

    @FindBy(xpath = "//div[@class='uitk-new-date-picker-month'][1]/h2")
    protected WebElement leftCalendarHeader;

    @FindBy(xpath = "//div[@class='uitk-new-date-picker-month'][2]/h2")
    protected WebElement rightCalendarHeader;

    @FindBy(xpath = "//a[@href='?pwaLob=wizard-thirdPartyPackage-pwa']")
    protected WebElement allInclusiveVacationsTab;

    @FindBy(xpath = "//a[@href='?pwaLob=wizard-car-pwa']")
    protected WebElement carsTab;

    @FindBy(xpath = "//a[@href='?pwaLob=wizard-cruise-pwa']")
    protected WebElement cruisesTab;

    @FindBy(xpath = "//a[@href='?pwaLob=wizard-flight-pwa']")
    protected WebElement flightsTab;

    @FindBy(xpath = "//a[@href='?pwaLob=wizard-hotel-pwa-v2']")
    protected WebElement staysTab;

    @FindBy(xpath = "//a[@href='?pwaLob=wizard-lx-pwa']")
    protected WebElement thingsToDoTab;

    @FindBy(xpath = "//a[@href='?pwaLob=wizard-package-pwa']")
    protected WebElement vacationPackagesTab;

    /**
     * Constructor
     *
     * @param driver Driver instance from test class.
     */
    protected CommonFactory(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Clicks on the "All-inclusive vacations" tab.
     */
    public void clickAllInclusiveVacationsTab() {
        allInclusiveVacationsTab.click();
        log(LogStatus.INFO, "Clicked on the 'All-inclusive vacations' tab.");
    }


    /**
     * Clicks on the "Cars" tab.
     */
    public void clickCarsTab() {
        carsTab.click();
        log(LogStatus.INFO, "Clicked on the 'Cars' tab.");
    }

    /**
     * Clicks on the "Flights" tab.
     */
    public void clickFlightsTab() {
        flightsTab.click();
        log(LogStatus.INFO, "Clicked on the 'Flights tab'.");
    }

    /**
     * Clicks on the "Cruises" tab.
     */
    public void clickCruisesTab() {
        cruisesTab.click();
        log(LogStatus.INFO, "Clicked on the 'Cruises' tab.");
    }

    /**
     * Clicks on the "Stays" tab.
     */
    public void clickStaysTab() {
        staysTab.click();
        log(LogStatus.INFO, "Clicked on the stays tab.");
    }

    /**
     * Clicks on the "Things to do" tab.
     */
    public void clickThingsToDoTab() {
        thingsToDoTab.click();
        log(LogStatus.INFO, "Clicked on the 'Things to do' tab.");
    }

    /**
     * Clicks on the "Vacation packages" tab.
     */
    public void clickVacationPackagesTab() {
        vacationPackagesTab.click();
        log(LogStatus.INFO, "Clicked on the 'Vacation packages' tab.");
    }

    /**
     * Clicks on the more travel drop down menu.
     */
    public void clickMoreTravelMenu() {
        moreTravelMenuButton.click();
        log(LogStatus.INFO, "Clicked on the more travel drop down menu.");
    }

    /**
     * Clicks on the "Stays" menu option in the "More travel" menu. This method will
     * fail if the "More travel" menu hasn't been expanded previously, (Use
     * clickMoreTravelMenu() first).
     */
    public void clickMoreTravelStays() {
        moreTravelMenuStays.click();
        log(LogStatus.INFO, "Clicked on the Stays option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Flights" menu option in the "More travel" menu. This method
     * will fail if the "More travel" menu hasn't been expanded previously, (Use
     * clickMoreTravelMenu() first).
     */
    public void clickMoreTravelFlights() {
        moreTravelMenuFlights.click();
        log(LogStatus.INFO, "Clicked on the Flights option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Cars" menu option in the "More travel" menu. This method will
     * fail if the "More travel" menu hasn't been expanded previously, (Use
     * clickMoreTravelMenu() first).
     */
    public void clickMoreTravelCars() {
        moreTravelMenuCars.click();
        log(LogStatus.INFO, "Clicked on the Cars option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Packages" menu option in the "More travel" menu. This method
     * will fail if the "More travel" menu hasn't been expanded previously, (Use
     * clickMoreTravelMenu() first).
     */
    public void clickMoreTravelPackages() {
        moreTravelMenuPackages.click();
        log(LogStatus.INFO, "Clicked on the Travel Packages option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Things to do" menu option in the "More travel" menu. This
     * method will fail if the "More travel" menu hasn't been expanded previously,
     * (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelThingsToDo() {
        moreTravelMenuThingsToDo.click();
        log(LogStatus.INFO, "Clicked on the Things to Do option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Cruises" menu option in the "More travel" menu. This method
     * will fail if the "More travel" menu hasn't been expanded previously, (Use
     * clickMoreTravelMenu() first).
     */
    public void clickMoreTravelCruises() {
        moreTravelMenuCruises.click();
        log(LogStatus.INFO, "Clicked on the Cruises option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Deals" menu option in the "More travel" menu. This method will
     * fail if the "More travel" menu hasn't been expanded previously, (Use
     * clickMoreTravelMenu() first).
     */
    public void clickMoreTravelDeals() {
        moreTravelMenuDeals.click();
        log(LogStatus.INFO, "Clicked on the Deals option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Francais" link.
     */
    public void clickFrancais() {
        francais.click();
        log(LogStatus.INFO, "Clicked on Francais.");
    }

    /**
     * Clicks on the "List your property" link.
     */
    public void clickListYourProperty() {
        listYourProperty.click();
        log(LogStatus.INFO, "Clicked on List Your property.");
    }

    /**
     * Clicks on the "Support" link.
     */
    public void clickSupport() {
        support.click();
        log(LogStatus.INFO, "Clicked on Support.");
    }

    /**
     * Clicks on the "Trips" link.
     */
    public void clickTrips() {
        trips.click();
        log(LogStatus.INFO, "Clicked on Trips.");
    }

    /**
     * Clicks on the "Sign in" menu button.
     */
    public void clickSignInMenu() {
        signInMenuButton.click();
        log(LogStatus.INFO, "Clicked on Sign In menu.");
    }

    /**
     * Clicks on the "Sign in" button on the "Sign in" submenu.
     */
    public void clickSignIn() {
        signInButton.click();
        log(LogStatus.INFO, "Clicked on 'Sign in' menu option on the Sign in submenu.");
    }

    /**
     * Clicks on the "Create a free account" button on the "Sign in" submenu.
     */
    public void clickCreateAFreeAccount() {
        createAFreeAccount.click();
        log(LogStatus.INFO, "Clicked on 'Create a free account' button on the Sign in submenu.");
    }

    /**
     * Clicks on the "List of favorites" button on the "Sign in" submenu.
     */
    public void clickListOfFavorites() {
        listOfFavorites.click();
        log(LogStatus.INFO, "Clicked on 'List of favorites' button on the Sign in submenu.");
    }

    /**
     * Clicks on the "Expedia Rewards" button on the "Sign in" submenu.
     */
    public void clickExpediaRewards() {
        expediaRewards.click();
        log(LogStatus.INFO, "Clicked on 'Expedia Rewards' button on the Sign in submenu");
    }

    /**
     * Clicks on the "Feedback" button on the "Sign in" submenu.
     */
    public void clickFeedback() {
        feedback.click();
        log(LogStatus.INFO, "Clicked on 'Feedback' button on the Sign in submenu.");
    }

    /**
     * Clicks on the check in date button in the calendar date picker panel so that
     * the user can click a date on the calendar and set it as their check in date.
     */
    public void clickCalendarCheckInDate() {
        calendarCheckInButton.click();
        log(LogStatus.INFO, "Clicked on the check in date on the calendar");
    }

    /**
     * Clicks on the check out date button in the calendar date picker panel so that
     * the user can click a date on the calendar and set it as their check out date.
     */
    public void clickCalendarCheckOutDate() {
        calendarCheckOutButton.click();
        log(LogStatus.INFO, "Clicked on the check out date on the calendar");
    }

    /**
     * Clicks on the back arrow button in the calendar date picker panel.
     */
    public void clickCalendarBackArrow() {
        calendarBackArrow.click();
        log(LogStatus.INFO, "Clicked on the back arrow on the calendar");
    }

    /**
     * Clicks on the forward arrow button in the calendar date picker panel.
     */
    public void clickCalendarForwardArrow() {
        calendarForwardArrow.click();
        log(LogStatus.INFO, "Clicked on the forward arrow on the calendar");
    }

    /**
     * Clicks on the done button in the calendar date picker panel.
     */
    public void clickCalendarDone() {
        calendarDoneButton.click();
        log(LogStatus.INFO, "Clicked on the done button on the calendar");
    }


    /**
     * Finds the specified day button in the calendar date picker panel.
     *
     * @param month The month for the date we are selecting. E.g.,
     *              "Month.FEBRUARY"
     * @param day   The day number for the date we are selecting.
     * @param year  The year for the date we are selecting.
     * @return The calendar day button as a WebElement.
     */
    protected WebElement getCalendarDay(Month month, int day, int year) {
        return driver.findElement(By.xpath("//button[@aria-label='"
                + month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + day + ", " + year + "']"));
    }

    /**
     * Clicks on the specified day button in the calendar date picker panel.
     *
     * @param month The month for the date we are selecting. E.g.,
     *              "Month.FEBRUARY"
     * @param date  The day number for the date we are selecting.
     * @param year  The year for the date we are selecting.
     */

    public void clickCalendarDay(Month month, int date, int year) {
        WebElement calendarDay = getCalendarDay(month, date, year);
        calendarDay.click();
        log(LogStatus.INFO, "Clicked on the calendar day button for " + month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + date + ", " + year);
    }

    /**
     * Starts the report for a specified test.
     *
     * @param report The ExtentReports object from the test class.
     * @param name   The name of the test that will show up in the report.
     */
    public void createTestReport(ExtentReports report, String name) {
        test = report.startTest(name);
    }

    /**
     * Method used to log messages from the test class rather than the page factory,
     * typically for pass/fail messages.
     *
     * @param status
     * @param message
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
     * Takes a screenshot of the browser window and returns its file path as a
     * string.
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
     * Formats the file path of a screenshot so that it may be added to the Extent
     * Reports HTML document as a log.
     *
     * @param path The path of the screenshot.
     * @return The formatted screenshot path as a string.
     */
    public String formatScreenshotPath(String path) {
        return test.addScreenCapture(path);
    }

    /**
     * Clicks the blue "Search" button so that we may submit our information.
     */
    public void clickSearchButton() {
        searchButton.click();
        log(LogStatus.INFO, "Clicked on the 'Search' button.");
    }

    public String getCalendarCheckInSpanText() {
        return calendarCheckInSpan.getText();
    }

    public String getCalendarCheckOutSpanText() {
        return calendarCheckOutSpan.getText();
    }

    public String getLeftCalendarHeaderText() {
        return leftCalendarHeader.getText();
    }

    public String getRightCalendarHeaderText() {
        return rightCalendarHeader.getText();
    }

    /**
     * Clicks a search result generated after typing in a location in one of the
     * search fields, (Leaving from, Going to, etc)
     *
     * @param city   - This parameter is the top bolded text that appears in one of
     *               the search results. (e.g., New York (JFK - John F. Kennedy
     *               Intl.)
     * @param region - This parameter is the bottom text that appears in one of the
     *               search results. (e.g., New York, United States of America)
     */

    public void clickSearchResult(String city, String region) {
        String xpath = "//button[normalize-space()='" + city + region
                + "' and not(ancestor-or-self::div[@aria-hidden='true'])]";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        searchResult.click();
        log(LogStatus.INFO, "Clicked on search result: '" + city + ", " + region + "'");
    }

    /**
     * Navigates to a past month on the calendar panel.
     *
     * @param month - The month you wish to navigate to. (E.g., month.JANUARY)
     * @param year  - The year you wish to navigate to.
     */
    public void navigateToPastMonth(Month month, int year) {
        String monthYear = month.getDisplayName(TextStyle.FULL, Locale.US) + " " + year;
        while (!getLeftCalendarHeaderText().equals(monthYear)) {
            clickCalendarBackArrow();
        }
        log(LogStatus.INFO, "Navigated back to " + monthYear + " on the calendar.");
    }

    /**
     * Navigates to a future month on the calendar panel.
     *
     * @param month - The month you wish to navigate to. (E.g., month.JANUARY)
     * @param year  - The year you wish to navigate to.
     */
    public void navigateToFutureMonth(Month month, int year) {
        String monthYear = month.getDisplayName(TextStyle.FULL, Locale.US) + " " + year;
        while (!getRightCalendarHeaderText().equals(monthYear)) {
            clickCalendarForwardArrow();
        }
        log(LogStatus.INFO, "Navigated forward to " + monthYear + " on the calendar.");
    }

    /**
     * Navigates to the present month on the calendar panel.
     */
    public void navigateToPresentMonth() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM yyyy");
        String currentMonthYear = now.format(dtf);
        while (!getLeftCalendarHeaderText().equals(currentMonthYear)) {
            clickCalendarBackArrow();
        }
        log(LogStatus.INFO, "Navigated to the month of " + currentMonthYear);
    }

    /**
     * Verifies whether the "disabled" attribute of the calendarBackArrow button equals true or not.
     *
     * @return True if the button is disabled, else false.
     */
    public boolean isCalendarBackArrowDisabled() {
        final String attribute = "disabled";
        if (calendarBackArrow.getAttribute(attribute) == null) {
            // If disabled = null, then it is not disabled, which is bad.
            log(LogStatus.ERROR, "The calendar back arrow button did not have the 'disabled' attribute.");
            return false;
        } else if (calendarBackArrow.getAttribute(attribute).equals("true")) {
            // If disabled = true, then it is disabled which is what we want.
            log(LogStatus.INFO, "The calendar back arrow button is disabled, which is the expected behavior.");
            return true;
        } else {
            // If disabled does not equal true or null, then something has gone terribly wrong.
            log(LogStatus.ERROR,
                    "The calendar back arrow button's 'disabled' attribute is equal to something other than the expected values of 'null' and 'true', which means something has gone wrong.");
            return false;
        }
    }

    /**
     * Verifies whether the "disabled" attribute of the calendarForwardArrow button equals true or not.
     *
     * @return True if the button is disabled, else false.
     */
    public boolean isCalendarForwardArrowDisabled() {
        final String attribute = "disabled";
        // Return true if the forward arrow is disabled, else return false.
        if (calendarForwardArrow.getAttribute(attribute) == null) {
            // If disabled = null, then it is not disabled, which is bad.
            log(LogStatus.ERROR, "The calendar forward arrow button did not have the 'disabled' attribute.");
            return false;
        } else if (calendarForwardArrow.getAttribute(attribute).equals("true")) {
            // If disabled = true, then it is disabled which is what we want.
            log(LogStatus.INFO, "The calendar forward arrow button is disabled, which is the expected behavior.");
            return true;
        } else {
            // If disabled does not equal true or null, then something has gone terribly wrong.
            log(LogStatus.ERROR,
                    "The calendar forward arrow button's 'disabled' attribute is equal to something other than the expected values of 'null' and 'true', which means something has gone wrong.");
            return false;
        }
    }

    /**
     * Verifies that the user is unable to select a day that is in the past on the calendar.
     *
     * @return True if all the buttons which are in the past are disabled, else false.
     */
    public Boolean isUserUnableToSelectDayInPast() {
        // Issues - cannot consistently identify when the day yesterday from today will
        // be disabled on the calendar. It can be 3:00AM on the 5th of January EST, yet
        // the 4th of January will still be enabled. Not sure if a bug or it is an issue
        // with time zones. Perhaps it would be better to pass
        // the day to the method?

        // Create LocalDate object so we may get the current date.
        LocalDate now = LocalDate.now();
        int dayToday = now.getDayOfMonth();

        // For loop to verify that days in the past are disabled on the calendar. If the
        // current day is not the 1st of the month, take
        // the current day minus one and count down until we reach 0.
        // While we are counting down the days, we are checking to see if they are disabled.
        if (dayToday != 1) {
            for (int x = (dayToday - 1); x > 0; x--) {
                try {
                    // If driver finds the element using this xpath then we know it's disabled.
                    driver.findElement(By.xpath("//button[@aria-label='"
                            + now.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                            + " " + x + ", " + now.getYear() + ", date disabled']"));
                } catch (NoSuchElementException e) {
                    // If NoSuchElementException is thrown, that means the calendar day button was enabled, return false.
                    log(LogStatus.ERROR, "The calendar day of "
                            + now.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " "
                            + x + ", " + now.getYear() + " did not have the disabled attribute.");
                    return false;
                }
            }
        }
        // Else, if it is the 1st of the month, then we verify that the 1st day of the
        // month button is enabled, and that the back arrow is disabled.
        else {
            try {
                // If driver finds the element using this xpath then we know it's enabled.
                getCalendarDay(now.getMonth(), 1, now.getYear());
            } catch (NoSuchElementException e) {
                // Any other xpath would mean it is disabled, which is not the expected
                // behavior; fail the test.
                log(LogStatus.ERROR, "The first of the month calendar button is disabled.");
                return false;
            }
            if (!isCalendarBackArrowDisabled()) {
                return false;
            }
        }
        log(LogStatus.INFO,
                "The calendar day buttons for days in the past are disabled, which is the expected behavior.");
        return true;
    }

    public Boolean isUserUnableToSelectDayOver500InFuture(LocalDate fiveHundredDaysIntoFuture) {
        int startingDisabledDate = fiveHundredDaysIntoFuture.getDayOfMonth() + 1;
        int daysInMonth = fiveHundredDaysIntoFuture.lengthOfMonth();

        // For loop that checks each day button in the calendar between the day that is
        // 500 days in the future, and the final day of that month. E.g., May 09th
        // 2022 is 500 days from now, and the month of May ends on the 31st that year,
        // so each day between the 9th and 31st should have the disabled attribute. If
        // all of the expected days are disabled, return true, else return false.
        for (int x = startingDisabledDate; x < (daysInMonth + 1); x++) {
            try {
                driver.findElement(By.xpath("//button[@aria-label='"
                        + fiveHundredDaysIntoFuture.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " "
                        + x + ", " + fiveHundredDaysIntoFuture.getYear() + ", date disabled']"));
                // If driver finds the element using this xpath then we know it's disabled.
            } catch (NoSuchElementException e) {
                // If NoSuchElementException is thrown, then we can infer that it was enabled,
                // which is not the expected behavior, return false.
                log(LogStatus.ERROR,
                        "The calendar day button for: '" + fiveHundredDaysIntoFuture.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                + " " + x + ", " + fiveHundredDaysIntoFuture.getYear()
                                + "' was not disabled even though it was expected to be disabled.");
                return false;
            }
        }
        log(LogStatus.INFO,
                "All the calendar days which are over 500 days from the current day are disabled as expected.");
        return true;
    }

    public Boolean isCalendarHighlightingDaysCorrectly(LocalDate checkInDate, LocalDate checkOutDate) {
        /*
        Xpaths to identify characteristics of day buttons.

        Check In Date Button(First Day Selected): aria label determines if it is the first selected date or the check in date..
        //button[@aria-label='Jan 27, 2021 selected, current check in date.']

        All the days between check in and check out date: class is the determining factor of whether or not it is selected.
        //button[@class='uitk-new-date-picker-day selected' and @aria-label='Jan 29, 2021']

        Check Out Date Button(Last Day Selected): aria label determines if it is the second selected date or the check out date.
        //button[@aria-label='Feb 5, 2021 selected, current check out date.']

         */

        return true;
    }
}
