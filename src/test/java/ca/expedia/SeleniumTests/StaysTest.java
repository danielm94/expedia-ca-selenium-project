package ca.expedia.SeleniumTests;

import ca.expedia.SeleniumTests.PageFactory.StaysFactory;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.Month;

//TODO: ADD SOFT ASSERTIONS WHERE APPLICABLE TO ALL TESTS
//TODO: Log test outcome at the end of every test.
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
        LocalDate date500DaysIntoFuture = LocalDate.now().plusDays(450);
        test = f.createTestReport(report, "Assert Calendar Days Are Highlighted Correctly");
        f.clickStaysTab();
        f.clickCheckIn();
        f.clickCalendarDay(presentDate.getMonth(), presentDate.getDayOfMonth(), presentDate.getYear());
        f.clickCalendarDay(date500DaysIntoFuture.getMonth(),
                date500DaysIntoFuture.getDayOfMonth(), date500DaysIntoFuture.getYear());
        Assert.assertTrue(f.isCalendarHighlightingDaysCorrectly(presentDate, date500DaysIntoFuture));
    }

    @Test
    public void assertUserCanClearGoingToFieldWithXButton() {
        test = f.createTestReport(report, "Assert User Can Clear Going To Field With 'x' Button");
        f.clickStaysTab();
        f.clickGoingTo();
        f.sendKeysGoingTo("Toronto");
        f.clickGoingToClear();
        Assert.assertEquals(f.getGoingToInputValue(), "");
        f.sendKeysGoingTo("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickGoingTo();
        f.clickGoingToClear();
        Assert.assertEquals(f.getGoingToInputValue(), "");
        f.clickOffMenu();
        Assert.assertEquals(f.getGoingToButtonText(), "");
    }

    @Test
    public void assertUserCanClearLeavingFromFieldWithXButton() {
        test = f.createTestReport(report, "Assert User Can Clear Leaving From Field With 'x' Button");
        f.clickStaysTab();
        f.clickAddFlight();
        f.clickLeavingFrom();
        f.sendKeysLeavingFrom("Toronto");
        f.clickLeavingFromClear();
        Assert.assertEquals(f.getLeavingFromInputValue(), "");
        f.sendKeysLeavingFrom("Toronto");
        f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        f.clickLeavingFrom();
        f.clickLeavingFromClear();
        Assert.assertEquals(f.getLeavingFromInputValue(), "");
        f.clickOffMenu();
        Assert.assertEquals(f.getLeavingFromButtonText(), "");
    }

    @Test()
    public void assertTravellersPanelDisplaysCorrectHeaderText() {
        test = f.createTestReport(report, "Assert That The Header Inside The Travellers Panel Is Displaying The Correct Text");
        f.clickStaysTab();
        f.clickTravellersButton();
        Assert.assertEquals(f.getTravellersPanelHeaderText(), "Travellers");
        f.log(LogStatus.PASS, "The header inside the travellers panel displayed the correct text.");
    }

    @Test
    public void assertTravellersPanelDisplaysCorrectRoomHeaderText() {
        test = f.createTestReport(report, "Assert That The Room Headers Inside The Travellers Panel Are Displaying The Correct Text");
        SoftAssert sa = new SoftAssert();
        f.clickStaysTab();
        sa.assertEquals(f.getStaysTabSpanText(), "Stays");
        f.clickTravellersButton();
        sa.assertEquals(f.getTravellersButtonText(), "1 room, 2 travellers");
        for (int x = 1; x < 9; x++) {
            Assert.assertEquals(f.getTravellersRoomHeaderText(x), "Room " + x);
            if (x < 8) {
                sa.assertEquals(f.getTravellersAddAnotherRoomText(), "Add another room");
                f.clickTravellersAddRoom();
            }
        }
        f.log(LogStatus.PASS, "The room headers inside the travellers panel displayed the correct text.");
        sa.assertAll();
    }

    @Test
    public void assertTravellersPanelDisplaysCorrectAdultsLabel() {
        test = f.createTestReport(report, "Assert That The Adults Labels Inside The Travellers Panel Are Displaying The Correct Text");
        SoftAssert sa = new SoftAssert();
        f.clickStaysTab();
        sa.assertEquals(f.getStaysTabSpanText(), "Stays");
        f.clickTravellersButton();
        sa.assertEquals(f.getTravellersButtonText(), "1 room, 2 travellers");
        for (int x = 1; x < 9; x++) {
            Assert.assertEquals(f.getTravellersAdultsLabelText(x), "Adults");
            if (x < 8) {
                sa.assertEquals(f.getTravellersAddAnotherRoomText(), "Add another room");
                f.clickTravellersAddRoom();
            }
        }
        f.log(LogStatus.INFO, "The 'Adults' labels inside the travellers panel displayed the correct text.");
        sa.assertAll();
    }

    @Test
    public void assertTravellersPanelDisplaysCorrectChildrenLabel() {
        test = f.createTestReport(report, "Assert That The Children Labels Inside The Travellers Panel Are Displaying The Correct Text");
        SoftAssert sa = new SoftAssert();
        f.clickStaysTab();
        sa.assertEquals(f.getStaysTabSpanText(), "Stays");
        f.clickTravellersButton();
        sa.assertEquals(f.getTravellersButtonText(), "1 room, 2 travellers");
        for (int x = 1; x < 9; x++) {
            Assert.assertEquals(f.getTravellersChildrenLabelText(x), "Children\n" +
                    "Ages 0 to 17");
            if (x < 8) {
                sa.assertEquals(f.getTravellersAddAnotherRoomText(), "Add another room");
                f.clickTravellersAddRoom();
            }
        }
        f.log(LogStatus.INFO, "The 'Children' labels inside the travellers panel displayed the correct text.");
        sa.assertAll();
    }

    @Test
    public void assertTravellersPanelDisplaysRemoveRoomButtonsCorrectly() {
        test = f.createTestReport(report, "Assert That The Remove Room Buttons Inside The Travellers Panel Are Displaying The Correct Text");
        SoftAssert sa = new SoftAssert();
        f.clickStaysTab();
        sa.assertEquals(f.getStaysTabSpanText(), "Stays");
        f.clickTravellersButton();
        sa.assertEquals(f.getTravellersButtonText(), "1 room, 2 travellers");
        for (int x = 1; x < 9; x++) {
            if (x > 1) {
                Assert.assertEquals(f.getTravellersRemoveRoomButtonText(x), "Remove room");
            }
            if (x < 8) {
                sa.assertEquals(f.getTravellersAddAnotherRoomText(), "Add another room");
                f.clickTravellersAddRoom();
            }
        }
        f.log(LogStatus.INFO, "The 'Remove room' buttons inside the travellers panel displayed the correct text.");
        sa.assertAll();
    }

    @Test
    public void assertTravellersChildrenSelectLabelsDisplayedCorrectly() {
        test = f.createTestReport(report, "Assert That The Children Select Labels Inside The Travellers Panel Are Displayed Correctly");
        SoftAssert sa = new SoftAssert();
        f.clickStaysTab();
        sa.assertEquals(f.getStaysTabSpanText(), "Stays");
        f.clickTravellersButton();
        sa.assertEquals(f.getTravellersButtonText(), "1 room, 2 travellers");
        for (int room = 1; room < 9; room++) {
            for (int child = 1; child < 7; child++) {
                f.clickTravellersChildrenInc(room);
                sa.assertEquals(f.getTravellersChildCount(room), Integer.toString(child));
                Assert.assertEquals(f.getTravellersChildSelectLabelText(room, child), "Child " + child + " age");
            }
            if (room < 8) {
                sa.assertEquals(f.getTravellersAddAnotherRoomText(), "Add another room");
                f.clickTravellersAddRoom();
            }
        }
        f.log(LogStatus.INFO, "The children select labels were displayed correctly.");
        sa.assertAll();
    }

    @Test
    public void assertTravellersChildrenSelectDisplaySelectedOption() {
        test = f.createTestReport(report, "Assert That The Child Drop Down Menus Display The Selected Option");
        SoftAssert sa = new SoftAssert();
        f.clickStaysTab();
        sa.assertEquals(f.getStaysTabSpanText(), "Stays");
        f.clickTravellersButton();
        sa.assertEquals(f.getTravellersButtonText(), "1 room, 2 travellers");
        for (int room = 1; room < 9; room++) {
            for (int child = 1; child < 7; child++) {
                f.clickTravellersChildrenInc(room);
                sa.assertEquals(f.getTravellersChildCount(room), Integer.toString(child));
                f.selectChildAge(room, child, (room + child));
                Assert.assertEquals(f.getTravellersChildSelectedText(room, child), Integer.toString(room + child));
            }
            if (room < 8) {
                sa.assertEquals(f.getTravellersAddAnotherRoomText(), "Add another room");
                f.clickTravellersAddRoom();
            }
        }
        f.log(LogStatus.INFO, "All the child select elements displayed the option that was selected");
        sa.assertAll();
    }

    @Test
    public void assertTravellersChildrenSelectContainsCorrectOptions() {
        test = f.createTestReport(report, "Assert That The Child Drop Down Menus Contain The Correct Options");
        final String[] EXPECTED_CHILD_SELECT_OPTIONS = {"Under 1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
                , "11", "12", "13", "14", "15", "16", "17"};
        SoftAssert sa = new SoftAssert();
        f.clickStaysTab();
        sa.assertEquals(f.getStaysTabSpanText(), "Stays");
        f.clickTravellersButton();
        sa.assertEquals(f.getTravellersButtonText(), "1 room, 2 travellers");
        for (int room = 1; room < 9; room++) {
            for (int child = 1; child < 7; child++) {
                f.clickTravellersChildrenInc(room);
                sa.assertEquals(f.getTravellersChildCount(room), Integer.toString(child));
                Assert.assertTrue(f.isChildSelectListingCorrectOptions(room, child, EXPECTED_CHILD_SELECT_OPTIONS));
            }
            if (room < 8) {
                sa.assertEquals(f.getTravellersAddAnotherRoomText(), "Add another room");
                f.clickTravellersAddRoom();
            }
        }
        f.log(LogStatus.INFO, "The available options of all child select elements contained the expected options.");
        sa.assertAll();
    }

    @Test
    public void assertTravellersDoneButtonDisplaysCorrectRoomTravellersCount() {
        test = f.createTestReport(report, "Assert That The Done Button In The Travellers Tab Displays The Correct Room & Travellers Count");
        SoftAssert sa = new SoftAssert();
        f.clickStaysTab();
        sa.assertEquals(f.getStaysTabSpanText(), "Stays");
        f.clickTravellersButton();
        sa.assertEquals(f.getTravellersButtonText(), "1 room, 2 travellers");
        int expectedTravellersCount = 2;
        //1 room, 2 travellers
        for (int room = 1; room < 9; room++) {
            if (room > 1) {
                for (int adult = 1; adult < 14; adult++) {
                    f.clickTravellersAdultsInc(room);
                    sa.assertEquals(f.getTravellersAdultsCount(room), Integer.toString(adult + 1));
                    expectedTravellersCount++;
                    if (room > 1) {
                        Assert.assertEquals(f.getTravellersDoneButtonText(), "Done\n" + room + " rooms, " + expectedTravellersCount + " travellers");
                    } else {
                        Assert.assertEquals(f.getTravellersDoneButtonText(), "Done\n" + room + " room, " + expectedTravellersCount + " travellers");
                    }
                }
            } else {
                for (int adult = 1; adult < 13; adult++) {
                    f.clickTravellersAdultsInc(room);
                    sa.assertEquals(f.getTravellersAdultsCount(room), Integer.toString(adult + 2));
                    expectedTravellersCount++;
                    if (room > 1) {
                        Assert.assertEquals(f.getTravellersDoneButtonText(), "Done\n" + room + " rooms, " + expectedTravellersCount + " travellers");
                    } else {
                        Assert.assertEquals(f.getTravellersDoneButtonText(), "Done\n" + room + " room, " + expectedTravellersCount + " travellers");
                    }
                }
            }
            for (int child = 1; child < 7; child++) {
                f.clickTravellersChildrenInc(room);
                sa.assertEquals(f.getTravellersChildCount(room), Integer.toString(child));
                expectedTravellersCount++;
                if (room > 1) {
                    Assert.assertEquals(f.getTravellersDoneButtonText(), "Done\n" + room + " rooms, " + expectedTravellersCount + " travellers");
                } else {
                    Assert.assertEquals(f.getTravellersDoneButtonText(), "Done\n" + room + " room, " + expectedTravellersCount + " travellers");
                }
            }
            if (room < 8) {
                sa.assertEquals(f.getTravellersAddAnotherRoomText(), "Add another room");
                f.clickTravellersAddRoom();
                expectedTravellersCount++;
            }
        }
        f.log(LogStatus.INFO, "The 'Done' button in the travellers tab displays the correct number of travellers and rooms.");
        sa.assertAll();
    }
}
