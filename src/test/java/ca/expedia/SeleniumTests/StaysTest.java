package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.StaysFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;


public class StaysTest extends TestBase {
    private StaysFactory f;

    @BeforeMethod
    public void beforeMethod() {
        reportName = "stays-tab";
        f = new StaysFactory(driver);
        super.beforeMethod();
    }

    @Test()
    public void basicTest() {
        test = f.createTestReport(report, "Basic Test");
        f.clickStaysTab();
        f.clickGoingTo();
        f.sendKeysGoingTo("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickCheckIn();
        f.clickCalendarCheckInDate();
        f.clickCalendarDay(Month.FEBRUARY, 22, 2021);
        f.clickCalendarCheckOutDate();
        f.clickCalendarDay(Month.FEBRUARY, 24, 2021);
        f.clickCalendarDone();
        f.clickTravellersButton();
        f.clickTravellersAddRoom();
        f.clickTravellersAddRoom();
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.clickTravellersChildrenInc(3);
        f.selectChildAge(3, 1, 15);
        f.selectChildAge(3, 2, 17);
        f.selectChildAge(3, 3, 4);
        f.selectChildAge(3, 4, 9);
        f.selectChildAge(3, 5, 4);
        f.selectChildAge(3, 6, 10);
    }

    @Test()
    public void leavingFromTest() {
        test = f.createTestReport(report, "Leaving From Test");
        f.clickStaysTab();
        f.clickAddFlight();
        f.clickLeavingFrom();
        f.sendKeysLeavingFrom("Delhi");
        f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        f.clickAddCar();
    }

    @Test
    public void assertUserCannotAccessPastMonth() {
        test = f.createTestReport(report, "Assert User Cannot Access A Month That Is In The Past");
        f.clickStaysTab();
        f.clickCheckIn();
        f.navigateToPresentMonth();
        Assert.assertTrue(f.isCalendarBackArrowDisabled());
    }

    @Test
    public void assertUserCannotAccessMonth500DaysAhead() {
        LocalDate fiveHundredDaysAhead = LocalDate.now().plusDays(500);
        test = f.createTestReport(report, "Assert User Cannot Access Month That Is Over 500 Days Ahead.");
        f.clickStaysTab();
        f.clickCheckIn();
        f.navigateToMonth(fiveHundredDaysAhead.getMonth(), fiveHundredDaysAhead.getYear());
        Assert.assertTrue(f.isCalendarForwardArrowDisabled());
    }

    @Test
    public void assertUserCannotSelectDayInPast() {
        test = f.createTestReport(report, "Assert User Cannot Select A Calendar Day That Is In The Past");
        f.clickStaysTab();
        f.clickCheckIn();
        f.navigateToPresentMonth();
        Assert.assertTrue(f.isUserUnableToSelectDayInPast(false));
    }

    @Test
    public void assertUserCannotSelectDaysThatAre500DaysInFuture() {
        LocalDate fiveHundredDaysAhead = LocalDate.now().plusDays(500);
        test = f.createTestReport(report, "Assert User Cannot Select A Day That Is Over 500 Days In The Future");
        f.clickStaysTab();
        f.clickCheckIn();
        f.navigateToMonth(fiveHundredDaysAhead.getMonth(), fiveHundredDaysAhead.getYear());
        Assert.assertTrue(f.isUserUnableToSelectDayOver500InFuture(fiveHundredDaysAhead));
    }

    @Test
    public void assertCalendarDaysAreHighlightedCorrectly() {
        LocalDate presentDate = LocalDate.now();
        LocalDate date500DaysIntoFuture = LocalDate.now().plusDays(500);
        test = f.createTestReport(report, "Assert Calendar Days Are Highlighted Correctly");
        f.clickStaysTab();
        f.clickCheckIn();
        f.clickCalendarDay(presentDate.getMonth(), presentDate.getDayOfMonth(), presentDate.getYear());
        f.clickCalendarDay(date500DaysIntoFuture.getMonth(),
                date500DaysIntoFuture.getDayOfMonth(), date500DaysIntoFuture.getYear());
        Assert.assertTrue(f.isCalendarHighlightingDaysCorrectly(presentDate, date500DaysIntoFuture));
    }

    @Test
    public void assertUserCanClearGoingToFieldWithXButton(){
        test = f.createTestReport(report,"Assert User Can Clear Going To Field With 'x' Button");
        f.clickStaysTab();
        f.clickGoingTo();
        f.sendKeysGoingTo("Toronto");
        f.clickGoingToClear();
        Assert.assertEquals(f.getGoingToInputValue(),"");
        f.sendKeysGoingTo("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickGoingTo();
        f.clickGoingToClear();
        Assert.assertEquals(f.getGoingToInputValue(),"");
        f.clickOffMenu();
        Assert.assertEquals(f.getGoingToButtonText(),"");
    }

    @Test
    public void assertUserCanClearLeavingFromFieldWithXButton(){
        test = f.createTestReport(report,"Assert User Can Clear Leaving From Field With 'x' Button");
        f.clickStaysTab();
        f.clickAddFlight();
        f.clickLeavingFrom();
        f.sendKeysLeavingFrom("Toronto");
        f.clickLeavingFromClear();
        Assert.assertEquals(f.getLeavingFromInputValue(),"");
        f.sendKeysLeavingFrom("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickLeavingFrom();
        f.clickLeavingFromClear();
        Assert.assertEquals(f.getLeavingFromInputValue(),"");
        f.clickOffMenu();
        Assert.assertEquals(f.getLeavingFromButtonText(),"");
    }
    @Test()
    public void assertCorrectNumberOfRoomsAreDisplayed() {
        test = f.createTestReport(report,"Assert The Correct Number of Rooms Are Displayed For Travellers");
        f.clickStaysTab();
        Assert.assertEquals(f.getTravellersText(), "1 room, 2 travellers");
        f.clickTravellersButton();
        Assert.assertTrue(f.isTravellersPanelDisplayingRooms(1));
        Assert.assertEquals(f.getTravellersDoneButtonSubText(), "1 room, 2 travellers");
        f.clickTravellersAddRoom();
        System.out.println("Hello jenkins.");
    }
}
