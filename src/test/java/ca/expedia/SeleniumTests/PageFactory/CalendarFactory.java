package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;


public class CalendarFactory extends PageFactoryBase {
    private long globalTimeOutTime;
    private WebDriver driver;
    @FindBy(xpath = "//button[1]/span[@class='uitk-date-picker-selection-date']")
    private WebElement calendarCheckInButton;
    @FindBy(xpath = "//button[2]/span[@class='uitk-date-picker-selection-date']")
    private WebElement calendarCheckOutButton;
    @FindBy(xpath = "//div[contains(@class,'uitk-date-picker-menu-pagination-container')]/button[1]")
    private WebElement calendarBackArrow;
    @FindBy(xpath = "//div[contains(@class,'uitk-date-picker-menu-pagination-container')]/button[2]")
    private WebElement calendarForwardArrow;
    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    private WebElement calendarDoneButton;
    @FindBy(xpath = "//div[@class='uitk-new-date-picker-month'][1]/h2")
    private WebElement leftCalendarHeader;
    @FindBy(xpath = "//div[@class='uitk-new-date-picker-month'][2]/h2")
    private WebElement rightCalendarHeader;

    public CalendarFactory(WebDriver driver, ExtentTest test, long globalTimeOutTime) {
        super(driver, test);
        this.globalTimeOutTime = globalTimeOutTime;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the check in date button in the calendar date picker panel so that the user can click a date on the
     * calendar and set it as their check in date.
     */
    public void clickCalendarCheckInDate() {
        click(calendarCheckInButton, globalTimeOutTime, "Clicked on the check in date on the calendar");
    }

    /**
     * Clicks on the check out date button in the calendar date picker panel so that the user can click a date on the
     * calendar and set it as their check out date.
     */
    public void clickCalendarCheckOutDate() {
        click(calendarCheckOutButton, globalTimeOutTime, "Clicked on the check out date on the calendar");
    }

    /**
     * Clicks on the back arrow button in the calendar date picker panel.
     */
    public void clickCalendarBackArrow() {
        click(calendarBackArrow, globalTimeOutTime, "Clicked on the back arrow on the calendar");
    }

    /**
     * Clicks on the forward arrow button in the calendar date picker panel.
     */
    public void clickCalendarForwardArrow() {
        click(calendarForwardArrow, globalTimeOutTime, "Clicked on the forward arrow on the calendar");
    }

    /**
     * Clicks on the done button in the calendar date picker panel.
     */
    public void clickCalendarDone() {
        click(calendarDoneButton, globalTimeOutTime, "Clicked on the done button on the calendar");
    }

    /**
     * Finds and returns the visible text of the check in button in the calendar panel.
     */
    public String getCalendarCheckInButtonText() {
        return getText(calendarCheckInButton, globalTimeOutTime, "Calendar check in button was found with the following text");
    }

    /**
     * Finds and returns the visible text of the check out button in the calendar panel.
     */
    public String getCalendarCheckOutButtonText() {
        return getText(calendarCheckOutButton, globalTimeOutTime, "Calendar check out button was found with the following text");
    }

    /**
     * Get the visible (i.e. not hidden by CSS) text of the left calendar header.
     *
     * @return The visible text of the left calendar header.
     */
    public String getLeftCalendarHeaderText() {
        return getText(leftCalendarHeader, globalTimeOutTime, "Left calendar header was found with the following text");
    }

    /**
     * Get the visible (i.e. not hidden by CSS) text of the right calendar header.
     *
     * @return The visible text of the right calendar header.
     */
    public String getRightCalendarHeaderText() {
        return getText(rightCalendarHeader, globalTimeOutTime, "Right calendar header was found with the following text");
    }


    /**
     * Finds the specified day button in the calendar date picker panel.
     *
     * @param month The month for the date we are selecting. E.g., "Month.FEBRUARY"
     * @param day   The day number for the date we are selecting.
     * @param year  The year for the date we are selecting.
     * @return The calendar day button as a WebElement.
     */
    private WebElement getCalendarDay(Month month, int day, int year) {
        return find(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@aria-label,'" + month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + day + ", " + year + "')]")), globalTimeOutTime);
    }

    /**
     * Clicks on the specified day button in the calendar date picker panel.
     *
     * @param month The month for the date we are selecting. E.g., "Month.FEBRUARY"
     * @param date  The day number for the date we are selecting.
     * @param year  The year for the date we are selecting.
     */
    private void selectCalendarDay(Month month, int date, int year) {
        WebElement calendarDay = getCalendarDay(month, date, year);
        click(calendarDay, globalTimeOutTime,
                "Clicked on the calendar day button for " + month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + date + ", " + year);
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
     * Checks whether the back arrow on the calendar is enabled or not.
     *
     * @return True if the button is enabled, else false.
     */
    public boolean isCalendarBackArrowEnabled() {
        if (calendarBackArrow.isEnabled()) {
            log(LogStatus.INFO, "The back arrow on the calendar panel was enabled.");
            return true;
        } else {
            log(LogStatus.INFO, "The back arrow on the calendar panel was disabled.");
            return false;
        }
    }

    /**
     * Checks whether the forward arrow on the calendar is enabled or not.
     *
     * @return True if the button is enabled, else false.
     */
    public boolean isCalendarForwardArrowEnabled() {
        if (calendarForwardArrow.isEnabled()) {
            log(LogStatus.INFO, "The forward arrow on the calendar panel was enabled.");
            return true;
        } else {
            log(LogStatus.INFO, "The forward arrow on the calendar panel was disabled.");
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
            if (isYesterdayDisabled) {
                for (int x = (dayToday - 1); x > 0; x--) {
                    try {
                        // If driver finds the element using this xpath then we know it's disabled.
                        find(By.xpath("//button[@aria-label='"
                                + now.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                + " " + x + ", " + now.getYear() + ", date disabled']"), globalTimeOutTime);
                    } catch (NoSuchElementException e) {
                        // If NoSuchElementException is thrown, that means the calendar day button was enabled, return false.
                        log(LogStatus.ERROR, "The calendar day of "
                                + now.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " "
                                + x + ", " + now.getYear() + " did not have the disabled attribute.");
                        return false;
                    }
                }
            } else {
                for (int x = (dayToday - 2); x > 0; x--) {
                    try {
                        // If driver finds the element using this xpath then we know it's disabled.
                        find(By.xpath("//button[@aria-label='"
                                + now.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
                                + " " + x + ", " + now.getYear() + ", date disabled']"), globalTimeOutTime);
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
            if (isCalendarBackArrowEnabled()) {
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
                find(By.xpath("//button[@aria-label='"
                        + fiveHundredDaysIntoFuture.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " "
                        + x + ", " + fiveHundredDaysIntoFuture.getYear() + ", date disabled']"), globalTimeOutTime);
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
     * Checks if a calendar day between a check in day and a check out day is highlighted correctly.
     *
     * @param month The month in short form. E.g., if searching for February use "Feb" as a parameter.
     * @param day   The day of the month.
     * @param year  The year.
     * @return True if it is highlighted correctly, else false.
     */
    private Boolean validateHighlightedCalendarDay(String month, int day, int year) {
        try {
            find(By.xpath("//button[@class='uitk-date-picker-day uitk-new-date-picker-day selected' and @aria-label='"
                    + month
                    + " " + day + ", " + year + ".']"), globalTimeOutTime);
            //If driver finds this element with this xpath, we know it's highlighted correctly.
            return true;
        } catch (NoSuchElementException e) {
            log(LogStatus.ERROR,
                    "The calendar day button for: " + month
                            + " " + day + ", " + year
                            + " was not highlighted correctly.");
            return false;
        }
    }

    /**
     * Checks if a calendar check out day is highlighted correctly.
     *
     * @param month The month in short form. E.g., if searching for February use "Feb" as a parameter.
     * @param day   The day of the month.
     * @param year  The year.
     * @return True if it is highlighted correctly, else false.
     */
    private Boolean validateHighlightedCheckOutDay(String month, int day, int year) {
        try {
            find(By.xpath("//button[@aria-label='"
                    + month + " "
                    + day + ", " + year
                    + " selected, current check out date.']"), globalTimeOutTime);
            log(LogStatus.INFO, "The calendar check out day button for: " + month
                    + " " + day + ", " + year
                    + " was highlighted correctly.");
            return true;
            //If driver finds this element with this xpath, we know it's highlighted correctly.
        } catch (NoSuchElementException e) {
            log(LogStatus.ERROR,
                    "The calendar check out day button for: " + month
                            + " " + day + ", " + year
                            + " was not highlighted correctly.");
            return false;
        }
    }

    /**
     * Checks if a calendar check in day is highlighted correctly.
     *
     * @param month The month in short form. E.g., if searching for February use "Feb" as a parameter.
     * @param day   The day of the month.
     * @param year  The year.
     * @return True if it is highlighted correctly, else false.
     */
    private Boolean validateHighlightedCheckInDay(String month, int day, int year) {
        try {
            find(By.xpath("//button[@aria-label='"
                    + month + " "
                    + day + ", " + year + " selected, current check in date.']"), globalTimeOutTime);
            //If driver finds this element with this xpath, we know it's highlighted correctly.
            log(LogStatus.INFO, "All days between the check in and check out date were highlighted correctly.");
            log(LogStatus.INFO, "The calendar check in day button for: " + month
                    + " " + day + ", " + year + " was highlighted correctly.");
            return true;
        } catch (NoSuchElementException e) {
            log(LogStatus.ERROR,
                    "The check in day button for: " + month
                            + " " + day + ", " + year
                            + " was not highlighted correctly.");
            return false;
        }
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
        if (!validateHighlightedCheckOutDay(checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US), checkOutDate.getDayOfMonth(), checkOutDate.getYear())) {
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
                    if (!validateHighlightedCalendarDay(checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US), dayCounter, checkOutDate.getYear())) {
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
                        return validateHighlightedCheckInDay(checkInDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US), checkInDate.getDayOfMonth(), checkInDate.getYear());
                    }
                    //Verify that the day buttons in between the check in date and check out date are highlighted correctly.
                    if (!validateHighlightedCalendarDay(checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US), dayCounter, checkOutDate.getYear())) {
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
                if (!validateHighlightedCalendarDay(checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US), dayCounter, checkOutDate.getYear())) {
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
                    return validateHighlightedCheckInDay(checkInDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US), checkInDate.getDayOfMonth(), checkInDate.getYear());
                }
                //Verify that the day buttons in between the check in date and check out date are highlighted correctly.
                if (!validateHighlightedCalendarDay(checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US), dayCounter, checkOutDate.getYear())) {
                    return false;
                }
            }
        } else if (monthDifference == 0) {
            for (int dayCounter = checkOutDate.getDayOfMonth(); dayCounter > checkInDate.getDayOfMonth() - 1; dayCounter--) {
                /* If we arrive at the check in date, verify that it is highlighted correctly. If it is, we are done
                 * searching so return true. Else, return false. */
                if (dayCounter == checkInDate.getDayOfMonth()) {
                    return validateHighlightedCheckInDay(checkInDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US), checkInDate.getDayOfMonth(), checkInDate.getYear());
                }
                //Verify that the day buttons in between the check in date and check out date are highlighted correctly.
                if (!validateHighlightedCalendarDay(checkOutDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US), dayCounter, checkOutDate.getYear())) {
                    return false;
                }
            }
        }
        return true;
    }
}
