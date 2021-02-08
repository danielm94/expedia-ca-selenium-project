package ca.expedia.SeleniumTests.Tests;

import ca.expedia.SeleniumTests.PageFactory.CalendarFactory;
import ca.expedia.SeleniumTests.PageFactory.StaysFactory;
import ca.expedia.SeleniumTests.PageFactory.TabFactory;
import ca.expedia.SeleniumTests.PageFactory.TravellersFactory;
import ca.expedia.SeleniumTests.SetUp.CommonTestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

public class StaysTest extends CommonTestBase {
    private StaysFactory stay;
    private CalendarFactory cal;
    private TabFactory tab;
    private TravellersFactory travel;

    @BeforeMethod()
    public void beforeMethod(ITestResult result) {
        super.beforeMethod(result);
        stay = new StaysFactory(driver, test, 5);
        cal = new CalendarFactory(driver, test, 5);
        tab = new TabFactory(driver, test, 5);
        travel = new TravellersFactory(driver, test, 5);
    }

    private void smokeTest() {
        Assert.assertEquals(stay.getTitle(), "Travel with Expedia.ca: Vacation Homes, Hotels, Car Rentals, Flights & More",
                "Page did not have expected title.");
        Assert.assertEquals(stay.getCurrentUrl(), "https://www.expedia.ca/");
    }

    @Test(description = "Basic Test")
    public void basicTest() {
        smokeTest();
        tab.clickStaysTab();
        stay.clickGoingTo();
        stay.sendKeysGoingTo("Delhi");
        stay.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        stay.clickCheckIn();
        cal.clickCalendarCheckInDate();
        cal.clickCalendarDay(Month.FEBRUARY, 20, 2021);
        cal.clickCalendarCheckOutDate();
        cal.clickCalendarDay(Month.FEBRUARY, 24, 2021);
        cal.clickCalendarDone();
        travel.clickTravellersButton();
        travel.clickTravellersAddRoom();
        travel.clickTravellersAddRoom();
        travel.clickTravellersChildrenInc(3);
        travel.clickTravellersChildrenInc(3);
        travel.clickTravellersChildrenInc(3);
        travel.clickTravellersChildrenInc(3);
        travel.clickTravellersChildrenInc(3);
        travel.clickTravellersChildrenInc(3);
        travel.selectChildAge(3, 1, 15);
        travel.selectChildAge(3, 2, 17);
        travel.selectChildAge(3, 3, 4);
        travel.selectChildAge(3, 4, 9);
        travel.selectChildAge(3, 5, 4);
        travel.selectChildAge(3, 6, 10);
    }

    @Test(description = "Leaving From Test")
    public void leavingFromTest() {
        smokeTest();
        tab.clickStaysTab();
        stay.clickAddFlight(false);
        stay.clickLeavingFrom();
        stay.sendKeysLeavingFrom("Delhi");
        stay.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
        stay.clickAddCar(false);
    }

    @Test(description = "Assert User Cannot Access A Month That Is In The Past")
    public void userCannotAccessPastMonth() {
        smokeTest();
        tab.clickStaysTab();
        stay.clickCheckIn();
        cal.navigateToPresentMonth();
        Assert.assertFalse(cal.isCalendarBackArrowEnabled());
    }

    @Test(description = "Assert User Cannot Access Month That Is Over 500 Days Ahead.")
    public void userCannotAccessMonth500DaysAhead() {
        smokeTest();
        LocalDate fiveHundredDaysAhead = LocalDate.now().plusDays(500);
        tab.clickStaysTab();
        stay.clickCheckIn();
        cal.navigateToMonth(fiveHundredDaysAhead.getMonth(), fiveHundredDaysAhead.getYear());
        Assert.assertFalse(cal.isCalendarForwardArrowEnabled());
    }

    @Test(description = "Assert User Cannot Select A Calendar Day That Is In The Past")
    public void userCannotSelectDayInPast() {
        smokeTest();
        tab.clickStaysTab();
        stay.clickCheckIn();
        cal.navigateToPresentMonth();
        Assert.assertTrue(cal.isUserUnableToSelectDayInPast(false));
    }

    @Test(description = "Assert User Cannot Select A Day That Is Over 500 Days In The Future")
    public void userCannotSelectDaysThatAre500DaysInFuture() {
        smokeTest();
        LocalDate fiveHundredDaysAhead = LocalDate.now().plusDays(500);
        tab.clickStaysTab();
        stay.clickCheckIn();
        cal.navigateToMonth(fiveHundredDaysAhead.getMonth(), fiveHundredDaysAhead.getYear());
        Assert.assertTrue(cal.isUserUnableToSelectDayOver500InFuture(fiveHundredDaysAhead));
    }

    @Test(description = "Assert Calendar Days Are Highlighted Correctly")
    public void calendarDaysAreHighlightedCorrectly() {
        smokeTest();
        LocalDate presentDate = LocalDate.now();
        LocalDate date450DaysIntoFuture = LocalDate.now().plusDays(450);
        tab.clickStaysTab();
        stay.clickCheckIn();
        cal.clickCalendarDay(presentDate.getMonth(), presentDate.getDayOfMonth(), presentDate.getYear());
        cal.clickCalendarDay(date450DaysIntoFuture.getMonth(),
                date450DaysIntoFuture.getDayOfMonth(), date450DaysIntoFuture.getYear());
        Assert.assertTrue(cal.isCalendarHighlightingDaysCorrectly(presentDate, date450DaysIntoFuture));
    }

    @Test(description = "Assert User Can Clear Going To Field With 'x' Button")
    public void userCanClearGoingToFieldWithXButton() {
        smokeTest();
        tab.clickStaysTab();
        stay.clickGoingTo();
        stay.sendKeysGoingTo("Toronto");
        stay.clickGoingToClear();
        Assert.assertEquals(stay.getGoingToInputValue(), "");
        stay.sendKeysGoingTo("Toronto");
        stay.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        stay.clickGoingTo();
        stay.clickGoingToClear();
        Assert.assertEquals(stay.getGoingToInputValue(), "");
        stay.clickOffMenu();
        Assert.assertEquals(stay.getGoingToButtonText(), "");
    }

    @Test(description = "Assert User Can Clear Leaving From Field With 'x' Button")
    public void userCanClearLeavingFromFieldWithXButton() {
        smokeTest();
        tab.clickStaysTab();
        stay.clickAddFlight(false);
        stay.clickLeavingFrom();
        stay.sendKeysLeavingFrom("Toronto");
        stay.clickLeavingFromClear();
        Assert.assertEquals(stay.getLeavingFromInputValue(), "");
        stay.sendKeysLeavingFrom("Toronto");
        stay.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
        stay.clickLeavingFrom();
        stay.clickLeavingFromClear();
        Assert.assertEquals(stay.getLeavingFromInputValue(), "");
        stay.clickOffMenu();
        Assert.assertEquals(stay.getLeavingFromButtonText(), "");
    }

    @Test(description = "Assert That The Header Inside The Travellers Panel Is Displaying The Correct Text")
    public void travellersPanelDisplaysCorrectHeaderText() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        Assert.assertEquals(travel.getTravellersPanelHeaderText(), "Travellers");
        stay.log(LogStatus.PASS, "The header inside the travellers panel displayed the correct text.");
    }

    @Test(description = "Assert That The Room Headers Inside The Travellers Panel Are Displaying The Correct Text")
    public void travellersPanelDisplaysCorrectRoomHeaderText() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        for (int x = 1; x < 9; x++) {
            Assert.assertEquals(travel.getTravellersRoomHeaderText(x), "Room " + x);
            if (x < 8) {
                travel.clickTravellersAddRoom();
            }
        }
    }

    @Test(description = "Assert That The Adults Labels Inside The Travellers Panel Are Displaying The Correct Text")
    public void travellersPanelDisplaysCorrectAdultsLabel() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        for (int x = 1; x < 9; x++) {
            Assert.assertEquals(travel.getTravellersAdultsLabelText(x), "Adults");
            if (x < 8) {
                travel.clickTravellersAddRoom();
            }
        }
    }

    @Test(description = "Assert That The Children Labels Inside The Travellers Panel Are Displaying The Correct Text")
    public void travellersPanelDisplaysCorrectChildrenLabel() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        for (int x = 1; x < 9; x++) {
            Assert.assertEquals(travel.getTravellersChildrenLabelText(x), "Children\n" +
                    "Ages 0 to 17");
            if (x < 8) {
                travel.clickTravellersAddRoom();
            }
        }
    }

    @Test(description = "Assert That The Remove Room Buttons Inside The Travellers Panel Are Displaying The Correct Text")
    public void travellersPanelDisplaysRemoveRoomButtonsCorrectly() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        for (int x = 1; x < 9; x++) {
            if (x > 1) {
                Assert.assertEquals(travel.getTravellersRemoveRoomButtonText(x), "Remove room");
            }
            if (x < 8) {
                travel.clickTravellersAddRoom();
            }
        }
    }

    @Test(description = "Assert That The Children Select Labels Inside The Travellers Panel Are Displayed Correctly")
    public void travellersChildrenSelectLabelsDisplayedCorrectly() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        for (int room = 1; room < 9; room++) {
            for (int child = 1; child < 7; child++) {
                travel.clickTravellersChildrenInc(room);
                Assert.assertEquals(travel.getTravellersChildSelectLabelText(room, child), "Child " + child + " age");
            }
            if (room < 8) {
                travel.clickTravellersAddRoom();
            }
        }
    }

    @Test(description = "Assert That The Child Drop Down Menus Display The Selected Option")
    public void travellersChildrenSelectDisplaySelectedOption() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        for (int room = 1; room < 9; room++) {
            for (int child = 1; child < 7; child++) {
                travel.clickTravellersChildrenInc(room);
                travel.selectChildAge(room, child, (room + child));
                Assert.assertEquals(travel.getTravellersChildSelectedText(room, child), Integer.toString(room + child));
            }
            if (room < 8) {
                travel.clickTravellersAddRoom();
            }
        }
    }

    @Test(description = "Assert That The Child Drop Down Menus Contain The Correct Options")
    public void travellersChildrenSelectContainsCorrectOptions() {
        smokeTest();
        final String[] EXPECTED_CHILD_SELECT_OPTIONS = {"Under 1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
                , "11", "12", "13", "14", "15", "16", "17"};
        tab.clickStaysTab();
        travel.clickTravellersButton();
        for (int room = 1; room < 9; room++) {
            for (int child = 1; child < 7; child++) {
                travel.clickTravellersChildrenInc(room);
                Assert.assertTrue(travel.isChildSelectListingCorrectOptions(room, child, EXPECTED_CHILD_SELECT_OPTIONS));
            }
            if (room < 8) {
                travel.clickTravellersAddRoom();
            }
        }
    }

    @Test(description = "Assert That The Done Button In The Travellers Tab Displays The Correct Room & Travellers Count")
    public void travellersDoneButtonDisplaysCorrectRoomTravellersCount() {
        smokeTest();
        final String assertFailureMessage = "Travellers done button did not display the correct number of travellers/rooms.";
        tab.clickStaysTab();
        travel.clickTravellersButton();
        Assert.assertEquals(travel.getTravellersDoneButtonText(), "Done\n1 room, 2 travellers", assertFailureMessage);

        travel.clickTravellersAdultsInc(1);
        Assert.assertEquals(travel.getTravellersDoneButtonText(), "Done\n1 room, 3 travellers", assertFailureMessage);

        travel.clickTravellersChildrenInc(1);
        Assert.assertEquals(travel.getTravellersDoneButtonText(), "Done\n1 room, 4 travellers", assertFailureMessage);

        travel.clickTravellersAddRoom();
        Assert.assertEquals(travel.getTravellersDoneButtonText(), "Done\n2 rooms, 5 travellers", assertFailureMessage);

        travel.clickTravellersAdultsDec(1);
        Assert.assertEquals(travel.getTravellersDoneButtonText(), "Done\n2 rooms, 4 travellers", assertFailureMessage);

        travel.clickTravellersChildrenDec(1);
        Assert.assertEquals(travel.getTravellersDoneButtonText(), "Done\n2 rooms, 3 travellers", assertFailureMessage);

        travel.clickTravellersRemoveRoom(2);
        Assert.assertEquals(travel.getTravellersDoneButtonText(), "Done\n1 room, 2 travellers", assertFailureMessage);

        travel.clickTravellersAdultsDec(1);
        Assert.assertEquals(travel.getTravellersDoneButtonText(), "Done\n1 room, 1 traveller", assertFailureMessage);
    }

    @Test(description = "Assert that the increase button for adults in the travellers tab will be disabled upon reaching limit.")
    public void travellersAdultIncreaseButtonDisabledUponReachingLimit() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        while (!travel.getTravellersAdultsCount(1).equals("14")) {
            travel.clickTravellersAdultsInc(1);
        }
        Assert.assertFalse(travel.isAdultIncreaseButtonEnabled(1),"The increase button for adults was not disabled upon reaching 14 adults.");
    }

    @Test(description = "Assert that the increase button for children in the travellers tab will be disabled upon reaching limit.")
    public void travellersChildrenIncreaseButtonDisabledUponReachingLimit() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        while (!travel.getTravellersChildCount(1).equals("6")) {
            travel.clickTravellersChildrenInc(1);
        }
        Assert.assertFalse(travel.isChildIncreaseButtonEnabled(1),"The increase button for children was not disabled upon reaching 6 children.");
    }

    @Test(description = "Assert that the decrease button for adults in the travellers tab will be disabled upon reaching limit.")
    public void travellersAdultDecreaseButtonDisabledUponReachingLimit() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        while (!travel.getTravellersAdultsCount(1).equals("1")) {
            travel.clickTravellersAdultsDec(1);
        }
        Assert.assertFalse(travel.isAdultDecreaseButtonEnabled(1),"The decrease button for adults was not disabled upon reaching 1 adult.");
    }

    @Test(description = "Assert that the decrease button for children in the travellers tab will be disabled upon reaching limit.")
    public void travellersChildrenDecreaseButtonDisabledUponReachingLimit() {
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        while (!travel.getTravellersChildCount(1).equals("0")) {
            travel.clickTravellersChildrenDec(1);
        }
        Assert.assertFalse(travel.isChildDecreaseButtonEnabled(1),"The decrease button for children was not disabled upon reaching 0 children.");
    }

    @Test(description="Assert that the remove room button in the travellers panel will remove the last room that was added.")
    public void travellersRemoveRoomButtonShouldRemoveRoom(){
        smokeTest();
        tab.clickStaysTab();
        travel.clickTravellersButton();
        for(int room = 1;room<9;room++){

        }
    }
}
