package ca.expedia.SeleniumTests.PageFactory;

import ca.expedia.SeleniumTests.FactoryBase.PageFactoryBase;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//TODO:Add get text method for all the tabs.
public class TabFactory extends PageFactoryBase {
    private long globalTimeOutTime;
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-thirdPartyPackage-pwa']")
    private WebElement allInclusiveVacationsTab;
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-car-pwa']")
    private WebElement carsTab;
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-cruise-pwa']")
    private WebElement cruisesTab;
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-flight-pwa']")
    private WebElement flightsTab;
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-hotel-pwa-v2']")
    private WebElement staysTab;
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-lx-pwa']")
    private WebElement thingsToDoTab;
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-package-pwa']")
    private WebElement vacationPackagesTab;

    @FindBy(xpath = "//a[@href='?pwaLob=wizard-hotel-pwa-v2']/span")
    private WebElement staysTabSpan;
    private WebDriver driver;

    public TabFactory(WebDriver driver, ExtentTest test, long globalTimeOutTime) {
        super(driver, test);
        this.driver = driver;
        this.globalTimeOutTime = globalTimeOutTime;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the "All-inclusive vacations" tab.
     */
    public void clickAllInclusiveVacationsTab() {
        click(allInclusiveVacationsTab,5,"Clicked on the 'All-inclusive vacations' tab.");
    }


    /**
     * Clicks on the "Cars" tab.
     */
    public void clickCarsTab() {
        click(carsTab,5,"Clicked on the 'Cars' tab.");
    }

    /**
     * Clicks on the "Flights" tab.
     */
    public void clickFlightsTab() {
        click(flightsTab,5,"Clicked on the 'Flights tab'.");
    }

    /**
     * Clicks on the "Cruises" tab.
     */
    public void clickCruisesTab() {
        click(cruisesTab,5,"Clicked on the 'Cruises' tab.");
    }

    /**
     * Clicks on the "Stays" tab.
     */
    public void clickStaysTab() {
        click(staysTab,5,"Clicked on the stay tab.");
    }

    /**
     * Clicks on the "Things to do" tab.
     */
    public void clickThingsToDoTab() {
        click(thingsToDoTab,5,"Clicked on the 'Things to do' tab.");
    }

    /**
     * Clicks on the "Vacation packages" tab.
     */
    public void clickVacationPackagesTab() {
        click(vacationPackagesTab,5,"Clicked on the 'Vacation packages' tab.");
    }


    /**
     * Returns the visible text of the span inside the 'Stays' tab button.
     */
    public String getStaysTabSpanText() {
      return getText(staysTabSpan,5,"The 'Stays' tab element was found with the following text");
    }
}
