package ca.expedia.SeleniumTests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.Month;

//TODO: ADD SOFT ASSERTIONS WHERE APPLICABLE TO ALL TESTS
public class StaysTest extends TestBase {

    @Test(description = "Basic Test")
    public void basicTest() {
        sta.clickStaysTab();
        sta.clickGoingTo();
        sta.sendKeysGoingTo("Delhi");
        sta.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        sta.clickCheckIn();
        sta.clickCalendarCheckInDate();
        sta.clickCalendarDay(Month.FEBRUARY, 22, 2021);
        sta.clickCalendarCheckOutDate();
        sta.clickCalendarDay(Month.FEBRUARY, 24, 2021);
        sta.clickCalendarDone();
        sta.clickTravellersButton();
        sta.clickTravellersAddRoom();
        sta.clickTravellersAddRoom();
        sta.clickTravellersChildrenInc(3);
        sta.clickTravellersChildrenInc(3);
        sta.clickTravellersChildrenInc(3);
        sta.clickTravellersChildrenInc(3);
        sta.clickTravellersChildrenInc(3);
        sta.clickTravellersChildrenInc(3);
        sta.selectChildAge(3, 1, 15);
        sta.selectChildAge(3, 2, 17);
        sta.selectChildAge(3, 3, 4);
        sta.selectChildAge(3, 4, 9);
        sta.selectChildAge(3, 5, 4);
        sta.selectChildAge(3, 6, 10);
    }

    @Test(description = "Leaving From Test")
    public void leavingFromTest() {
        sta.clickStaysTab();
        sta.clickAddFlight();
        sta.clickLeavingFrom();
        sta.sendKeysLeavingFrom("Delhi");
        sta.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        sta.clickAddCar();
    }

    @Test(description = "Assert User Cannot Access A Month That Is In The Past")
    public void userCannotAccessPastMonth() {
        sta.clickStaysTab();
        sta.clickCheckIn();
        sta.navigateToPresentMonth();
        Assert.assertTrue(sta.isCalendarBackArrowDisabled());
    }

    @Test(description = "Assert User Cannot Access Month That Is Over 500 Days Ahead.")
    public void userCannotAccessMonth500DaysAhead() {
        LocalDate fiveHundredDaysAhead = LocalDate.now().plusDays(500);
        sta.clickStaysTab();
        sta.clickCheckIn();
        sta.navigateToMonth(fiveHundredDaysAhead.getMonth(), fiveHundredDaysAhead.getYear());
        Assert.assertTrue(sta.isCalendarForwardArrowDisabled());
    }

    @Test(description = "Assert User Cannot Select A Calendar Day That Is In The Past")
    public void userCannotSelectDayInPast() {
        sta.clickStaysTab();
        sta.clickCheckIn();
        sta.navigateToPresentMonth();
        Assert.assertTrue(sta.isUserUnableToSelectDayInPast(false));
    }

    @Test(description = "Assert User Cannot Select A Day That Is Over 500 Days In The Future")
    public void userCannotSelectDaysThatAre500DaysInFuture() {
        LocalDate fiveHundredDaysAhead = LocalDate.now().plusDays(500);
        sta.clickStaysTab();
        sta.clickCheckIn();
        sta.navigateToMonth(fiveHundredDaysAhead.getMonth(), fiveHundredDaysAhead.getYear());
        Assert.assertTrue(sta.isUserUnableToSelectDayOver500InFuture(fiveHundredDaysAhead));
    }

    @Test(description = "Assert Calendar Days Are Highlighted Correctly")
    public void calendarDaysAreHighlightedCorrectly() {
        LocalDate presentDate = LocalDate.now();
        LocalDate date450DaysIntoFuture = LocalDate.now().plusDays(450);
        sta.clickStaysTab();
        sta.clickCheckIn();
        sta.clickCalendarDay(presentDate.getMonth(), presentDate.getDayOfMonth(), presentDate.getYear());
        sta.clickCalendarDay(date450DaysIntoFuture.getMonth(),
                date450DaysIntoFuture.getDayOfMonth(), date450DaysIntoFuture.getYear());
        Assert.assertTrue(sta.isCalendarHighlightingDaysCorrectly(presentDate, date450DaysIntoFuture));
    }

    @Test(description = "Assert User Can Clear Going To Field With 'x' Button")
    public void userCanClearGoingToFieldWithXButton() {
        sta.clickStaysTab();
        sta.clickGoingTo();
        sta.sendKeysGoingTo("Toronto");
        sta.clickGoingToClear();
        Assert.assertEquals(sta.getGoingToInputValue(), "");
        sta.sendKeysGoingTo("Toronto");
        sta.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        sta.clickGoingTo();
        sta.clickGoingToClear();
        Assert.assertEquals(sta.getGoingToInputValue(), "");
        sta.clickOffMenu();
        Assert.assertEquals(sta.getGoingToButtonText(), "");
    }

    @Test(description = "Assert User Can Clear Leaving From Field With 'x' Button")
    public void userCanClearLeavingFromFieldWithXButton() {
        sta.clickStaysTab();
        sta.clickAddFlight();
        sta.clickLeavingFrom();
        sta.sendKeysLeavingFrom("Toronto");
        sta.clickLeavingFromClear();
        Assert.assertEquals(sta.getLeavingFromInputValue(), "");
        sta.sendKeysLeavingFrom("Toronto");
        sta.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        sta.clickLeavingFrom();
        sta.clickLeavingFromClear();
        Assert.assertEquals(sta.getLeavingFromInputValue(), "");
        sta.clickOffMenu();
        Assert.assertEquals(sta.getLeavingFromButtonText(), "");
    }

    @Test(description = "Assert That The Header Inside The Travellers Panel Is Displaying The Correct Text")
    public void travellersPanelDisplaysCorrectHeaderText() {
        SoftAssert sa = new SoftAssert();
        sta.clickStaysTab();
        sa.assertEquals(sta.getStaysTabSpanText(), "Stays");
        sta.clickTravellersButton();
        sa.assertEquals(sta.getTravellersButtonText(), "1 room, 2 travellers");
        Assert.assertEquals(sta.getTravellersPanelHeaderText(), "Travellers");
        sta.log(LogStatus.PASS, "The header inside the travellers panel displayed the correct text.");
        sa.assertAll();
    }

    @Test(description = "Assert That The Room Headers Inside The Travellers Panel Are Displaying The Correct Text")
    public void travellersPanelDisplaysCorrectRoomHeaderText() {
        SoftAssert sa = new SoftAssert();
        sta.clickStaysTab();
        sa.assertEquals(sta.getStaysTabSpanText(), "Stays");
        sta.clickTravellersButton();
        sa.assertEquals(sta.getTravellersButtonText(), "1 room, 2 travellers");
        for (int x = 1; x < 9; x++) {
            Assert.assertEquals(sta.getTravellersRoomHeaderText(x), "Room " + x);
            if (x < 8) {
                sa.assertEquals(sta.getTravellersAddAnotherRoomText(), "Add another room");
                sta.clickTravellersAddRoom();
            }
        }
        sta.log(LogStatus.PASS, "The room headers inside the travellers panel displayed the correct text.");
        sa.assertAll();
    }

    @Test(description = "Assert That The Adults Labels Inside The Travellers Panel Are Displaying The Correct Text")
    public void travellersPanelDisplaysCorrectAdultsLabel() {
        SoftAssert sa = new SoftAssert();
        sta.clickStaysTab();
        sa.assertEquals(sta.getStaysTabSpanText(), "Stays");
        sta.clickTravellersButton();
        sa.assertEquals(sta.getTravellersButtonText(), "1 room, 2 travellers");
        for (int x = 1; x < 9; x++) {
            Assert.assertEquals(sta.getTravellersAdultsLabelText(x), "Adults");
            if (x < 8) {
                sa.assertEquals(sta.getTravellersAddAnotherRoomText(), "Add another room");
                sta.clickTravellersAddRoom();
            }
        }
        sta.log(LogStatus.INFO, "The 'Adults' labels inside the travellers panel displayed the correct text.");
        sa.assertAll();
    }

    @Test(description = "Assert That The Children Labels Inside The Travellers Panel Are Displaying The Correct Text")
    public void travellersPanelDisplaysCorrectChildrenLabel() {
        SoftAssert sa = new SoftAssert();
        sta.clickStaysTab();
        sa.assertEquals(sta.getStaysTabSpanText(), "Stays");
        sta.clickTravellersButton();
        sa.assertEquals(sta.getTravellersButtonText(), "1 room, 2 travellers");
        for (int x = 1; x < 9; x++) {
            Assert.assertEquals(sta.getTravellersChildrenLabelText(x), "Children\n" +
                    "Ages 0 to 17");
            if (x < 8) {
                sa.assertEquals(sta.getTravellersAddAnotherRoomText(), "Add another room");
                sta.clickTravellersAddRoom();
            }
        }
        sta.log(LogStatus.INFO, "The 'Children' labels inside the travellers panel displayed the correct text.");
        sa.assertAll();
    }

    @Test(description = "Assert That The Remove Room Buttons Inside The Travellers Panel Are Displaying The Correct Text")
    public void travellersPanelDisplaysRemoveRoomButtonsCorrectly() {
        SoftAssert sa = new SoftAssert();
        sta.clickStaysTab();
        sa.assertEquals(sta.getStaysTabSpanText(), "Stays");
        sta.clickTravellersButton();
        sa.assertEquals(sta.getTravellersButtonText(), "1 room, 2 travellers");
        for (int x = 1; x < 9; x++) {
            if (x > 1) {
                Assert.assertEquals(sta.getTravellersRemoveRoomButtonText(x), "Remove room");
            }
            if (x < 8) {
                sa.assertEquals(sta.getTravellersAddAnotherRoomText(), "Add another room");
                sta.clickTravellersAddRoom();
            }
        }
        sta.log(LogStatus.INFO, "The 'Remove room' buttons inside the travellers panel displayed the correct text.");
        sa.assertAll();
    }

    @Test(description = "Assert That The Children Select Labels Inside The Travellers Panel Are Displayed Correctly")
    public void travellersChildrenSelectLabelsDisplayedCorrectly() {
        SoftAssert sa = new SoftAssert();
        sta.clickStaysTab();
        sa.assertEquals(sta.getStaysTabSpanText(), "Stays");
        sta.clickTravellersButton();
        sa.assertEquals(sta.getTravellersButtonText(), "1 room, 2 travellers");
        for (int room = 1; room < 9; room++) {
            for (int child = 1; child < 7; child++) {
                sta.clickTravellersChildrenInc(room);
                sa.assertEquals(sta.getTravellersChildCount(room), Integer.toString(child));
                Assert.assertEquals(sta.getTravellersChildSelectLabelText(room, child), "Child " + child + " age");
            }
            if (room < 8) {
                sa.assertEquals(sta.getTravellersAddAnotherRoomText(), "Add another room");
                sta.clickTravellersAddRoom();
            }
        }
        sta.log(LogStatus.INFO, "The children select labels were displayed correctly.");
        sa.assertAll();
    }

    @Test(description = "Assert That The Child Drop Down Menus Display The Selected Option")
    public void travellersChildrenSelectDisplaySelectedOption() {
        SoftAssert sa = new SoftAssert();
        sta.clickStaysTab();
        sa.assertEquals(sta.getStaysTabSpanText(), "Stays");
        sta.clickTravellersButton();
        sa.assertEquals(sta.getTravellersButtonText(), "1 room, 2 travellers");
        for (int room = 1; room < 9; room++) {
            for (int child = 1; child < 7; child++) {
                sta.clickTravellersChildrenInc(room);
                sa.assertEquals(sta.getTravellersChildCount(room), Integer.toString(child));
                sta.selectChildAge(room, child, (room + child));
                Assert.assertEquals(sta.getTravellersChildSelectedText(room, child), Integer.toString(room + child));
            }
            if (room < 8) {
                sa.assertEquals(sta.getTravellersAddAnotherRoomText(), "Add another room");
                sta.clickTravellersAddRoom();
            }
        }
        sta.log(LogStatus.INFO, "All the child select elements displayed the option that was selected");
        sa.assertAll();
    }

    @Test(description = "Assert That The Child Drop Down Menus Contain The Correct Options")
    public void travellersChildrenSelectContainsCorrectOptions() {
        final String[] EXPECTED_CHILD_SELECT_OPTIONS = {"Under 1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
                , "11", "12", "13", "14", "15", "16", "17"};
        SoftAssert sa = new SoftAssert();
        sta.clickStaysTab();
        sa.assertEquals(sta.getStaysTabSpanText(), "Stays");
        sta.clickTravellersButton();
        sa.assertEquals(sta.getTravellersButtonText(), "1 room, 2 travellers");
        for (int room = 1; room < 9; room++) {
            for (int child = 1; child < 7; child++) {
                sta.clickTravellersChildrenInc(room);
                sa.assertEquals(sta.getTravellersChildCount(room), Integer.toString(child));
                Assert.assertTrue(sta.isChildSelectListingCorrectOptions(room, child, EXPECTED_CHILD_SELECT_OPTIONS));
            }
            if (room < 8) {
                sa.assertEquals(sta.getTravellersAddAnotherRoomText(), "Add another room");
                sta.clickTravellersAddRoom();
            }
        }
        sta.log(LogStatus.INFO, "The available options of all child select elements contained the expected options.");
        sa.assertAll();
    }

    @Test(description = "Assert That The Done Button In The Travellers Tab Displays The Correct Room & Travellers Count")
    public void travellersDoneButtonDisplaysCorrectRoomTravellersCount() {
        SoftAssert sa = new SoftAssert();
        sta.clickStaysTab();
        sa.assertEquals(sta.getStaysTabSpanText(), "Stays");
        sta.clickTravellersButton();
        sa.assertEquals(sta.getTravellersButtonText(), "1 room, 2 travellers");
        int expectedTravellersCount = 2;
        for (int room = 1; room < 9; room++) {
            if (room > 1) {
                for (int adult = 1; adult < 14; adult++) {
                    sta.clickTravellersAdultsInc(room);
                    sa.assertEquals(sta.getTravellersAdultsCount(room), Integer.toString(adult + 1));
                    expectedTravellersCount++;
                    if (room > 1) {
                        Assert.assertEquals(sta.getTravellersDoneButtonText(), "Done\n" + room + " rooms, " + expectedTravellersCount + " travellers");
                    } else {
                        Assert.assertEquals(sta.getTravellersDoneButtonText(), "Done\n" + room + " room, " + expectedTravellersCount + " travellers");
                    }
                }
            } else {
                for (int adult = 1; adult < 13; adult++) {
                    sta.clickTravellersAdultsInc(room);
                    sa.assertEquals(sta.getTravellersAdultsCount(room), Integer.toString(adult + 2));
                    expectedTravellersCount++;
                    if (room > 1) {
                        Assert.assertEquals(sta.getTravellersDoneButtonText(), "Done\n" + room + " rooms, " + expectedTravellersCount + " travellers");
                    } else {
                        Assert.assertEquals(sta.getTravellersDoneButtonText(), "Done\n" + room + " room, " + expectedTravellersCount + " travellers");
                    }
                }
            }
            for (int child = 1; child < 7; child++) {
                sta.clickTravellersChildrenInc(room);
                sa.assertEquals(sta.getTravellersChildCount(room), Integer.toString(child));
                expectedTravellersCount++;
                if (room > 1) {
                    Assert.assertEquals(sta.getTravellersDoneButtonText(), "Done\n" + room + " rooms, " + expectedTravellersCount + " travellers");
                } else {
                    Assert.assertEquals(sta.getTravellersDoneButtonText(), "Done\n" + room + " room, " + expectedTravellersCount + " travellers");
                }
            }
            if (room < 8) {
                sa.assertEquals(sta.getTravellersAddAnotherRoomText(), "Add another room");
                sta.clickTravellersAddRoom();
                expectedTravellersCount++;
            }
        }
        //Do it again but in reverse.
    }
}
