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
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public abstract class CommonFactory {
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
     * This button is in the calendar date selector panel. It allows the user to select a check in date.
     */
    @FindBy(xpath = "//button[1]/span[@class='uitk-date-picker-selection-date']")
    protected WebElement calendarCheckInButton;
    /**
     * This button is in the calendar date selector panel. It allows the user to select a check out date.
     */
    @FindBy(xpath = "//button[2]/span[@class='uitk-date-picker-selection-date']")
    protected WebElement calendarCheckOutButton;
    @FindBy(xpath = "//div[contains(@class,'uitk-date-picker-menu-pagination-container')]/button[1]")
    protected WebElement calendarBackArrow;
    @FindBy(xpath = "//div[contains(@class,'uitk-date-picker-menu-pagination-container')]/button[2]")
    protected WebElement calendarForwardArrow;
    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    protected WebElement calendarDoneButton;
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    protected WebElement searchButton;
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
    @FindBy(xpath="//section[@class='header-region no-stripe']")
    protected WebElement clickOffMenuLocation;
    private WebDriver driver;
    private ExtentTest test;

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
     * Clicks on the "Stays" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelStays() {
        moreTravelMenuStays.click();
        log(LogStatus.INFO, "Clicked on the Stays option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Flights" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelFlights() {
        moreTravelMenuFlights.click();
        log(LogStatus.INFO, "Clicked on the Flights option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Cars" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelCars() {
        moreTravelMenuCars.click();
        log(LogStatus.INFO, "Clicked on the Cars option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Packages" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelPackages() {
        moreTravelMenuPackages.click();
        log(LogStatus.INFO, "Clicked on the Travel Packages option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Things to do" menu option in the "More travel" menu. This method will fail if the "More travel"
     * menu hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelThingsToDo() {
        moreTravelMenuThingsToDo.click();
        log(LogStatus.INFO, "Clicked on the Things to Do option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Cruises" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelCruises() {
        moreTravelMenuCruises.click();
        log(LogStatus.INFO, "Clicked on the Cruises option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Deals" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
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
     * Clicks on the check in date button in the calendar date picker panel so that the user can click a date on the
     * calendar and set it as their check in date.
     */
    public void clickCalendarCheckInDate() {
        calendarCheckInButton.click();
        log(LogStatus.INFO, "Clicked on the check in date on the calendar");
    }

    /**
     * Clicks on the check out date button in the calendar date picker panel so that the user can click a date on the
     * calendar and set it as their check out date.
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
     * @param month The month for the date we are selecting. E.g., "Month.FEBRUARY"
     * @param day   The day number for the date we are selecting.
     * @param year  The year for the date we are selecting.
     * @return The calendar day button as a WebElement.
     */
    protected WebElement getCalendarDay(Month month, int day, int year) {
        return driver.findElement(By.xpath("//button[@aria-label='"
                + month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + day + ", " + year + ".']"));
    }

    /**
     * Clicks on the specified day button in the calendar date picker panel.
     *
     * @param month The month for the date we are selecting. E.g., "Month.FEBRUARY"
     * @param date  The day number for the date we are selecting.
     * @param year  The year for the date we are selecting.
     */
//TODO: MAKE THIS PROTECTED, CHANGE METHOD NAME TO selectCalendarDay(), USE METHOD THAT NAVIGATES TO DATES BEFORE CLICKING
    protected void selectCalendarDay(Month month, int date, int year) {
        WebElement calendarDay = getCalendarDay(month, date, year);
        calendarDay.click();
        log(LogStatus.INFO, "Clicked on the calendar day button for " + month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + date + ", " + year);
    }

    /**
     * Clicks on the header of the website in order to close a menu.
     */
    public void clickOffMenu(){
        clickOffMenuLocation.click();
    }
    /**
     * Starts the report for a specified test and returns the instance as an ExtentTest object.
     *
     * @param report The ExtentReports object from the test class.
     * @param name   The name of the test that will show up in the report.
     */
    public ExtentTest createTestReport(ExtentReports report, String name) {
        test = report.startTest(name);
        return test;
    }

    /**
     * Method used to log messages from the test class rather than the page factory, typically for pass/fail messages.
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
     * Clicks the blue "Search" button so that we may submit our information.
     */
    public void clickSearchButton() {
        searchButton.click();
        log(LogStatus.INFO, "Clicked on the 'Search' button.");
    }

    public String getCalendarCheckInButtonText() {
        return calendarCheckInButton.getText();
    }

    public String getCalendarCheckOutButtonText() {
        return calendarCheckOutButton.getText();
    }

    /**
     * Get the visible (i.e. not hidden by CSS) text of the left calendar header.
     *
     * @return The visible text of the left calendar header.
     */
    public String getLeftCalendarHeaderText() {
        return leftCalendarHeader.getText();
    }

    /**
     * Get the visible (i.e. not hidden by CSS) text of the right calendar header.
     *
     * @return The visible text of the right calendar header.
     */
    public String getRightCalendarHeaderText() {
        return rightCalendarHeader.getText();
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
        //Create YearMonth object and get the current date.
        YearMonth now = YearMonth.now();
        //Create DateTimeFormatter so that we may format the YearMonth object into a string that can be compared to
        //the text of the header element on the calendar.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM yyyy");
        String currentMonthYear = now.format(dtf);

        while (!getLeftCalendarHeaderText().equals(currentMonthYear)) {
            clickCalendarBackArrow();
        }
        log(LogStatus.INFO, "Navigated to the month of " + currentMonthYear);
    }

    /**
     * Checks whether the "disabled" attribute of the calendarBackArrow button equals true or not.
     *
     * @return True if the button is disabled, else false.
     */
    public boolean isCalendarBackArrowDisabled() {
        final String attribute = "disabled";
        if (calendarBackArrow.getAttribute(attribute) == null) {
            log(LogStatus.ERROR, "The calendar back arrow button did not have the 'disabled' attribute.");
            return false;
        } else if (calendarBackArrow.getAttribute(attribute).equals("true")) {
            log(LogStatus.INFO, "The calendar back arrow button is disabled, which is the expected behavior.");
            return true;
        } else {
            log(LogStatus.ERROR,
                    "The calendar back arrow button's 'disabled' attribute is equal to something other than the expected values of 'null' and 'true', which means something has gone wrong.");
            return false;
        }
    }

    /**
     * Checks whether the "disabled" attribute of the calendarForwardArrow button equals true or not.
     *
     * @return True if the button is disabled, else false.
     */
    public boolean isCalendarForwardArrowDisabled() {
        final String attribute = "disabled";
        if (calendarForwardArrow.getAttribute(attribute) == null) {
            log(LogStatus.ERROR, "The calendar forward arrow button did not have the 'disabled' attribute.");
            return false;
        } else if (calendarForwardArrow.getAttribute(attribute).equals("true")) {
            log(LogStatus.INFO, "The calendar forward arrow button is disabled, which is the expected behavior.");
            return true;
        } else {
            log(LogStatus.ERROR,
                    "The calendar forward arrow button's 'disabled' attribute is equal to something other than the expected values of 'null' and 'true', which means something has gone wrong.");
            return false;
        }
    }

    /**
     * Checks that the user is unable to select a day that is in the past on the calendar.
     *
     * @return True if all the buttons which are in the past are disabled, else false.
     */
    public Boolean isUserUnableToSelectDayInPast(Boolean isYesterdayDisabled) {
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
            if(isYesterdayDisabled) {
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
            }else{
                for (int x = (dayToday - 2); x > 0; x--) {
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

    /**
     * Checks user is unable to book a date that is over 500 days from today.
     *
     * @param fiveHundredDaysIntoFuture LocalDate object whose date is 500 days ahead of the present day.
     * @return True if the day buttons which are over 500 days in the future are disabled, else false.
     */
    public Boolean isUserUnableToSelectDayOver500InFuture(LocalDate fiveHundredDaysIntoFuture) {
        int startingDisabledDate = fiveHundredDaysIntoFuture.getDayOfMonth() + 1;
        int daysInMonth = fiveHundredDaysIntoFuture.lengthOfMonth();

        // For loop that checks each day button in the calendar between the day that is
        // 500 days in the future, and the final day of that month. E.g., May 09th
        // 2022 is 500 days from now, and the month of May ends on the 31st of that year,
        // so each day starting from the 10th to the 31st should have the disabled attribute. If
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

    /**
     * Navigates to the desired month & year. Will fail if the month is either in the past or if the first day of the
     * month is over 500 days in the future.
     *
     * @param month The month for the date we are navigating to. E.g., "Month.FEBRUARY"
     * @param year  The year for the date we are navigating to.
     */
    public void navigateToMonth(Month month, int year) {
        //Create DateTimeFormatter to format the left calendar header's text into something that can be parsed.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
        //Create a YearMonth object from the parameters passed.
        YearMonth desiredYearMonth = YearMonth.of(year, month);
     /*    Create YearMonth object for the left calendar header by formatting and parsing the text from the left calendar
        header WebElement.*/
        YearMonth leftCalendarHeaderDate = YearMonth.parse(getLeftCalendarHeaderText(), formatter);
        /*  Create YearMonth object for the right calendar header by taking the date of the left calendar
        header YearMonth object and adding one month.*/
        YearMonth rightCalendarHeaderDate = leftCalendarHeaderDate.plusMonths(1);

        //Navigate forwards or backwards in the calendar, depending on whether the date is in the past or the future.
        if (desiredYearMonth.isAfter(rightCalendarHeaderDate)) {
            navigateToFutureMonth(month, year);
        } else if (desiredYearMonth.isBefore(leftCalendarHeaderDate)) {
            navigateToPastMonth(month, year);
        }
    }

    /**
     * Navigates to the desired month & year of a calendar date and clicks it. Will fail if the date is either in the
     * past or over 500 days in the future.
     *
     * @param month The month for the date we are selecting. E.g., "Month.FEBRUARY"
     * @param day   The day number for the date we are selecting.
     * @param year  The year for the date we are selecting.
     */
    public void clickCalendarDay(Month month, int day, int year) {
        navigateToMonth(month, year);
        selectCalendarDay(month, day, year);
    }

    /**
     * Checks that the check in day button, check out day button and all the day buttons between are highlighted
     * correctly. You must have the check in button & check out button selected and be at the check out button's month
     * on the calendar upon calling this method
     *
     * @param checkInDate  The check in date, which will be the first date button we click.
     * @param checkOutDate The check out date, which will be the last date button we click.
     * @return True if the check in day button, check out day button and all the day buttons between are highlighted
     * correctly, else false.
     */
    public Boolean isCalendarHighlightingDaysCorrectly(LocalDate checkInDate, LocalDate checkOutDate) {
        /*Start by verifying that the check out date,(the second date selected), is highlighted correctly.
        Then verify that every single day button between the check out date and the check in date,
        (first date selected), is also highlighted correctly. Finally, verify the check in date is highlighted
        correctly.
         */

        //Verify that the check out date is highlighted correctly.
        try {
            driver.findElement(By.xpath("//button[@aria-label='"
                    + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " "
                    + checkOutDate.getDayOfMonth() + ", " + checkOutDate.getYear()
                    + " selected, current check out date.']"));
            log(LogStatus.INFO, "The calendar check out day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                    + " " + checkOutDate.getDayOfMonth() + ", " + checkOutDate.getYear()
                    + " was highlighted correctly.");
            //If driver finds this element with this xpath, we know it's highlighted correctly.
        } catch (NoSuchElementException e) {
            log(LogStatus.ERROR,
                    "The calendar check out day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                            + " " + checkOutDate.getDayOfMonth() + ", " + checkOutDate.getYear()
                            + " was not highlighted correctly.");
            return false;
        }
        //Get the difference between the two dates in months.
        int monthDifference = (int) ChronoUnit.MONTHS.between(checkInDate, checkOutDate);
        /*Subtract one day from the check out date object since we have already verified that the check out
        date button is highlighted correctly*/
        checkOutDate = checkOutDate.minusDays(1);
        if (monthDifference > 1) {
            //Month cycling loop that will eventually bring us back to our check in date.
            for (int monthCounter = 0; monthCounter < monthDifference + 1; monthCounter++) {
                /*Loop that cycles through all the days on the right hand calendar panel,
                starting from the day before the check out day to the 1st of the month */
                for (int dayCounter = checkOutDate.getDayOfMonth(); dayCounter > 0; dayCounter--) {
                    /*Verify that the day buttons in between the check in date and check out date are
                    highlighted correctly.*/
                    try {
                        driver.findElement(By.xpath("//button[@class='uitk-date-picker-day uitk-new-date-picker-day selected' and @aria-label='"
                                + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                + " " + dayCounter + ", " + checkOutDate.getYear() + ".']"));
                        //If driver finds this element with this xpath, we know it's highlighted correctly.
                    } catch (NoSuchElementException e) {
                        log(LogStatus.ERROR,
                                "The calendar day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                        + " " + dayCounter + ", " + checkOutDate.getYear()
                                        + " was not highlighted correctly.");
                        return false;
                    }
                }
                /*  After checking all the days on the right hand side calendar, we need to take the check out
                date object and subtract 1 month from it so that we may start checking the days on the left hand side
                calendar to see if they are also highlighted correctly.
                    Set the day of month number of the check out date to the last day listed on the left hand calendar
                by getting the number of days in the month for that year.*/
                checkOutDate = checkOutDate.minusMonths(1);
                checkOutDate = checkOutDate.withDayOfMonth(checkOutDate.lengthOfMonth());

                /* Start cycling through all the days on the left hand side calendar, starting from the last day of the
                 * month to the 1st of the month. */
                for (int dayCounter = checkOutDate.getDayOfMonth(); dayCounter > 0; dayCounter--) {
                    /* If we arrive at the check in date, verify that it is highlighted correctly. If it is, we are done
                     * searching so return true. Else, return false. */
                    if (dayCounter == checkInDate.getDayOfMonth() && checkOutDate.getMonth().equals(checkInDate.getMonth())
                            && checkOutDate.getYear() == checkInDate.getYear()) {
                        try {
                            driver.findElement(By.xpath("//button[@aria-label='"
                                    + checkInDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " "
                                    + checkInDate.getDayOfMonth() + ", " + checkInDate.getYear() + " selected, current check in date.']"));
                            //If driver finds this element with this xpath, we know it's highlighted correctly.
                            log(LogStatus.INFO, "All days between the check in and check out date were highlighted correctly.");
                            log(LogStatus.INFO, "The calendar check in day button for: " + checkInDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                    + " " + dayCounter + ", " + checkInDate.getYear() + " was highlighted correctly.");
                            return true;
                        } catch (NoSuchElementException e) {
                            log(LogStatus.ERROR,
                                    "The check in day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                            + " " + dayCounter + ", " + checkOutDate.getYear()
                                            + " was not highlighted correctly.");
                            return false;
                        }
                    }
                    //Verify that the day buttons in between the check in date and check out date are highlighted correctly.
                    try {
                        driver.findElement(By.xpath("//button[@class='uitk-date-picker-day uitk-new-date-picker-day selected' and @aria-label='"
                                + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                + " " + dayCounter + ", " + checkOutDate.getYear() + ".']"));
                        //If driver finds this element with this xpath, we know it's highlighted correctly.
                    } catch (NoSuchElementException e) {
                        log(LogStatus.ERROR,
                                "The calendar day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                        + " " + dayCounter + ", " + checkOutDate.getYear()
                                        + " was not highlighted correctly.");
                        return false;
                    }
                }
                clickCalendarBackArrow();
                /* Upon completing one iteration of the loop, we will click the back arrow on the calendar and begin
                verifying that the calendar date buttons for the month we were just looking at on the left hand side
                are displayed correctly on the right hand side as we go back a month. */
            }
        } else if (monthDifference > 0) {
               /*Loop that cycles through all the days on the right hand calendar panel,
                starting from the day before the check out day to the 1st of the month */
            for (int dayCounter = checkOutDate.getDayOfMonth(); dayCounter > 0; dayCounter--) {
                    /*Verify that the day buttons in between the check in date and check out date are
                    highlighted correctly.*/
                try {
                    driver.findElement(By.xpath("//button[@class='uitk-date-picker-day uitk-new-date-picker-day selected' and @aria-label='"
                            + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                            + " " + dayCounter + ", " + checkOutDate.getYear() + ".']"));
                    //If driver finds this element with this xpath, we know it's highlighted correctly.
                } catch (NoSuchElementException e) {
                    log(LogStatus.ERROR,
                            "The calendar day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                    + " " + dayCounter + ", " + checkOutDate.getYear()
                                    + " was not highlighted correctly.");
                    return false;
                }
            }
                /*  After checking all the days on the right hand side calendar, we need to take the check out
                date object and subtract 1 month from it so that we may start checking the days on the left hand side
                calendar to see if they are also highlighted correctly.
                    Set the day of month number of the check out date to the last day listed on the left hand calendar
                by getting the number of days in the month for that year.*/
            checkOutDate = checkOutDate.minusMonths(1);
            checkOutDate = checkOutDate.withDayOfMonth(checkOutDate.lengthOfMonth());

            /* Start cycling through all the days on the left hand side calendar, starting from the last day of the
             * month to the 1st of the month. */
            for (int dayCounter = checkOutDate.getDayOfMonth(); dayCounter > 0; dayCounter--) {
                /* If we arrive at the check in date, verify that it is highlighted correctly. If it is, we are done
                 * searching so return true. Else, return false. */
                if (dayCounter == checkInDate.getDayOfMonth() && checkOutDate.getMonth().equals(checkInDate.getMonth())
                        && checkOutDate.getYear() == checkInDate.getYear()) {
                    try {
                        driver.findElement(By.xpath("//button[@aria-label='"
                                + checkInDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " "
                                + dayCounter + ", " + checkInDate.getYear() + " selected, current check in date.']"));
                        //If driver finds this element with this xpath, we know it's highlighted correctly.
                        log(LogStatus.INFO, "All days between the check in and check out date were highlighted correctly.");
                        log(LogStatus.INFO, "The calendar check in day button for: " + checkInDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                + " " + dayCounter + ", " + checkInDate.getYear() + " was highlighted correctly.");
                        return true;
                    } catch (NoSuchElementException e) {
                        log(LogStatus.ERROR,
                                "The check in day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                        + " " + dayCounter + ", " + checkOutDate.getYear() + " was not highlighted correctly.");
                        return false;
                    }
                }
                //Verify that the day buttons in between the check in date and check out date are highlighted correctly.
                try {
                    driver.findElement(By.xpath("//button[@class='uitk-date-picker-day uitk-new-date-picker-day selected' and @aria-label='"
                            + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                            + " " + dayCounter + ", " + checkOutDate.getYear() + ".']"));
                    //If driver finds this element with this xpath, we know it's highlighted correctly.
                } catch (NoSuchElementException e) {
                    log(LogStatus.ERROR,
                            "The calendar day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                    + " " + dayCounter + ", " + checkOutDate.getYear()
                                    + " was not highlighted correctly.");
                    return false;
                }
            }
        } else if (monthDifference == 0) {
            for (int dayCounter = checkOutDate.getDayOfMonth(); dayCounter > checkInDate.getDayOfMonth() - 1; dayCounter--) {
                /* If we arrive at the check in date, verify that it is highlighted correctly. If it is, we are done
                 * searching so return true. Else, return false. */
                if (dayCounter == checkInDate.getDayOfMonth()) {
                    try {
                        driver.findElement(By.xpath("//button[@aria-label='"
                                + checkInDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " "
                                + dayCounter + ", " + checkInDate.getYear()
                                + " selected, current check in date.']"));
                        //If driver finds this element with this xpath, we know it's highlighted correctly.
                        log(LogStatus.INFO, "All days between the check in and check out date were highlighted correctly.");
                        log(LogStatus.INFO, "The calendar check in day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                + " " + dayCounter + ", " + checkOutDate.getYear()
                                + " was highlighted correctly.");
                        return true;
                    } catch (NoSuchElementException e) {
                        log(LogStatus.ERROR,
                                "The check in day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                        + " " + dayCounter + ", " + checkOutDate.getYear()
                                        + " was not highlighted correctly.");
                        return false;
                    }
                }
                //Verify that the day buttons in between the check in date and check out date are highlighted correctly.
                try {
                    driver.findElement(By.xpath("//button[@class='uitk-date-picker-day uitk-new-date-picker-day selected' and @aria-label='"
                            + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                            + " " + dayCounter + ", " + checkOutDate.getYear() + ".']"));
                    //If driver finds this element with this xpath, we know it's highlighted correctly.
                } catch (NoSuchElementException e) {
                    log(LogStatus.ERROR,
                            "The calendar day button for: " + checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                    + " " + dayCounter + ", " + checkOutDate.getYear()
                                    + " was not highlighted correctly.");
                    return false;
                }
            }
        }
        return true;
    }
}