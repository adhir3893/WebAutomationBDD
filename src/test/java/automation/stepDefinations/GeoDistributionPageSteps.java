package automation.stepDefinations;

import org.openqa.selenium.WebDriver;

import auotmation.pageObjects.AccountsPage;
import auotmation.pageObjects.GeoDistributionPage;
import automation.genericLibrary.GenericMethods;
import automation.helper.TestContext;
import cucumber.api.java.en.Then;

public class GeoDistributionPageSteps {
	
	TestContext testContext;
	AccountsPage accountsPage;
	GeoDistributionPage geoPage;
	GenericMethods genericMethods;
	WebDriver driver;
	
	public GeoDistributionPageSteps(TestContext context) {
		testContext = context;
		geoPage = testContext.getPageObjectManager().getGeoDistributionPage();
		genericMethods = testContext.getGenericMethodsManager().getGenericMethods();
	}
	
	@Then("^verify user navigated to geoDistribution page$")
	public void verify_user_navigated_to_geoDistribution_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if (!genericMethods.isElementPresentInScreen(geoPage.bubbleChart, 60)) {
			throw new Exception("Unable to find bubble chart svg");
		}
		
	}

}
