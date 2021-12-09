package automation.stepDefinations;

import org.openqa.selenium.WebDriver;

import auotmation.pageObjects.AccountsPage;
import automation.genericLibrary.GenericMethods;
import automation.helper.TestContext;
import cucumber.api.java.en.Then;

public class AccountsPageSteps {
	
	TestContext testContext;
	AccountsPage accountsPage;
	GenericMethods genericMethods;
	WebDriver driver;
	
	public AccountsPageSteps(TestContext context) {
		testContext = context;
		accountsPage = testContext.getPageObjectManager().getAccountsPage();
		genericMethods = testContext.getGenericMethodsManager().getGenericMethods();
	}
	
	@Then("^verify user navigated to accounts page$")
	public void verify_user_navigated_to_accounts_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if (!genericMethods.isElementPresentInScreen(accountsPage.worldCloud, 60)) {
			throw new Exception("Unable to find world cloud svg");
		}
		
	}
	

}
