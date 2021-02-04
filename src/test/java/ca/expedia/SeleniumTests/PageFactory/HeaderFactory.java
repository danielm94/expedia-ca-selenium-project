package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//TODO REVISE XPATHS
public class HeaderFactory extends PageFactoryBase {
    @FindBy(xpath = "//div[@class='uitk-grid']/a[@href='/']")
    private WebElement expediaLogo;
    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']/button")
    private WebElement moreTravelMenuButton;
    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Hotels']")
    private WebElement moreTravelMenuStays;
    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Flights']")
    private WebElement moreTravelMenuFlights;
    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Cars']")
    private WebElement moreTravelMenuCars;
    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Vacation-Packages']")
    private WebElement moreTravelMenuPackages;
    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/things-to-do']")
    private WebElement moreTravelMenuThingsToDo;
    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/Cruises']")
    private WebElement moreTravelMenuCruises;
    @FindBy(xpath = "//div[@id='gc-custom-header-tool-bar-shop-menu']"
            + "/div/div/div/div[@class='custom-menu-section custom-menu-section-list']/div/a[@href='/deals']")
    private WebElement moreTravelMenuDeals;
    @FindBy(xpath = "//div[text()='Fran�ais']")
    private WebElement francais;
    @FindBy(id = "listYourProperty")
    private WebElement listYourProperty;
    @FindBy(id = "support-cs")
    private WebElement support;
    @FindBy(id = "itinerary")
    private WebElement trips;
    @FindBy(xpath = "//div[@id='gc-custom-header-nav-bar-acct-menu']/button")
    private WebElement signInMenuButton;
    @FindBy(xpath = "//div[@class='actions']/a[@data-stid='link-header-account-signin']")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@class='actions']/a[@data-stid='link-header-account-signup']")
    private WebElement createAFreeAccount;
    @FindBy(xpath = "//a[@href='/lists']")
    private WebElement listOfFavorites;
    @FindBy(xpath = "//a[@href='/rewards/howitworks']")
    private WebElement expediaRewards;
    @FindBy(xpath = "//a[@href='/p/info-other/feedback']")
    private WebElement feedback;
    private WebDriver driver;

    public HeaderFactory(WebDriver driver, ExtentTest test) {
        super(driver, test);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Clicks on the more travel drop down menu.
     */
    public void clickMoreTravelMenu() {
        click(moreTravelMenuButton, 5, "Clicked on the more travel drop down menu.");
    }

    /**
     * Clicks on the "Stays" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelStays() {
        click(moreTravelMenuStays, 5, "Clicked on the Stays option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Flights" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelFlights() {
        click(moreTravelMenuFlights, 5, "Clicked on the Flights option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Cars" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelCars() {
        click(moreTravelMenuCars, 5, "Clicked on the Cars option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Packages" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelPackages() {
        click(moreTravelMenuPackages, 5, "Clicked on the Travel Packages option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Things to do" menu option in the "More travel" menu. This method will fail if the "More travel"
     * menu hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelThingsToDo() {
        click(moreTravelMenuThingsToDo, 5, "Clicked on the Things to Do option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Cruises" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelCruises() {
        click(moreTravelMenuCruises, 5, "Clicked on the Cruises option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Deals" menu option in the "More travel" menu. This method will fail if the "More travel" menu
     * hasn't been expanded previously, (Use clickMoreTravelMenu() first).
     */
    public void clickMoreTravelDeals() {
        click(moreTravelMenuDeals, 5, "Clicked on the Deals option in the more travel drop down menu.");
    }

    /**
     * Clicks on the "Francais" link.
     */
    public void clickFrancais() {
        click(francais, 5, "Clicked on Francais.");
    }

    /**
     * Clicks on the "List your property" link.
     */
    public void clickListYourProperty() {
        click(listYourProperty, 5, "Clicked on List Your property.");
    }

    /**
     * Clicks on the "Support" link.
     */
    public void clickSupport() {
        click(support, 5, "Clicked on Support.");
    }

    /**
     * Clicks on the "Trips" link.
     */
    public void clickTrips() {
        click(trips, 5, "Clicked on Trips.");
    }

    /**
     * Clicks on the "Sign in" menu button.
     */
    public void clickSignInMenu() {
        click(signInMenuButton, 5, "Clicked on Sign In menu.");
    }

    /**
     * Clicks on the "Sign in" button on the "Sign in" submenu.
     */
    public void clickSignIn() {
        click(signInButton, 5, "Clicked on 'Sign in' menu option on the Sign in submenu.");
    }

    /**
     * Clicks on the "Create a free account" button on the "Sign in" submenu.
     */
    public void clickCreateAFreeAccount() {
        click(createAFreeAccount, 5, "Clicked on 'Create a free account' button on the Sign in submenu.");
    }

    /**
     * Clicks on the "List of favorites" button on the "Sign in" submenu.
     */
    public void clickListOfFavorites() {
        click(listOfFavorites, 5, "Clicked on 'List of favorites' button on the Sign in submenu.");
    }

    /**
     * Clicks on the "Expedia Rewards" button on the "Sign in" submenu.
     */
    public void clickExpediaRewards() {
        click(expediaRewards, 5, "Clicked on 'Expedia Rewards' button on the Sign in submenu");
    }

    /**
     * Clicks on the "Feedback" button on the "Sign in" submenu.
     */
    public void clickFeedback() {
        click(feedback, 5, "Clicked on 'Feedback' button on the Sign in submenu.");
    }

}
