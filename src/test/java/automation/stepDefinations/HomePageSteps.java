package automation.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import auotmation.pageObjects.HomePage;
import automation.genericLibrary.GenericMethods;
import automation.helper.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;
	GenericMethods genericMethods;
	WebDriver driver;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		genericMethods = testContext.getGenericMethodsManager().getGenericMethods();
	}

	@Given("^user is in home page after passing home url$")
	public void user_is_in_home_page_after_passing_home_url() {
		// Write code here that turns the phrase above into concrete actions
//		driver = testContext.getWebDriverManager().getDriver();
//		driver.get(testContext.getTestData().get("url"));
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		genericMethods.waitForElementToLoad(homePage.usernameTextField, 60);
	}

	@Given("^navigate to homepage$")
	public void navigate_to_homepage() {
		genericMethods.waitForPageToLoadFully();
		genericMethods.waitForElementToLoad(homePage.accountLink, 10);
		System.out.println("navigate to home page");
	}

	@Given("^user enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enter_username_and_password(String username, String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		genericMethods.enterText(homePage.usernameTextField, username);
		genericMethods.enterText(homePage.passwordTextField, password);
		Thread.sleep(500);

	}

	@Given("^submit on clicking in login button$")
	public void submit_on_clicking_in_login_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		genericMethods.click(homePage.loginButton);
		genericMethods.waitForPageToLoadFully();
		genericMethods.waitForElementToLoad(homePage.accountLink, 60);
	}

	@Then("^user close the browser")
	public void user_close_the_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		testContext.getWebDriverManager().closeDriver();
	}

	@Given("^tap on accounts link$")
	public void tap_on_accounts_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		genericMethods.waitForElementToLoad(homePage.accountLink, 10);
		genericMethods.click(homePage.accountLink);
		genericMethods.waitForPageToLoadFully();
	}
	
	@Given("^tap on geoDistribution link$")
	public void tap_on_geoDistribution_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		genericMethods.waitForElementToLoad(homePage.geoDistributionLink, 10);
		genericMethods.click(homePage.geoDistributionLink);
		genericMethods.waitForPageToLoadFully();
	}
}
