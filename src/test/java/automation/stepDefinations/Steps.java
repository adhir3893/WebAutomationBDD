//package automation.stepDefinations;
//
//import java.io.File;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//
//import auotmation.pageObjects.HomePage;
//import auotmation.pageObjects.LobbyPage;
//import automation.genericLibrary.GenericMethods;
//import automation.pageObjectManager.PageObjectManager;
//import automation.runner.WebDriverManager;
//import automation.testDataManager.FileReaderManager;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//
//public class Steps {
//
//	WebDriver driver;
//	HomePage homePage;
//	LobbyPage lobbyPage;
//	PageObjectManager pageObjectManager;
//	WebDriverManager webDriverManager;
//	GenericMethods genericMethods;
//	Map<String, String> testData;
//
//	@Given("^user is in home page after passing home url$")
//	public void user_is_in_home_page_after_passing_home_url() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		testData = new LinkedHashMap();
//		testData = FileReaderManager.getInstance().getConfigReader().getTestData();
//		webDriverManager = new WebDriverManager();
//		driver = webDriverManager.getDriver();
//		pageObjectManager = new PageObjectManager(driver);
//		homePage = pageObjectManager.getHomePage();
//		lobbyPage = pageObjectManager.getLobbyPage();
//
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + File.separator + "bin//chromedriver");
//		driver.get(testData.get("url"));
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		genericMethods = new GenericMethods(driver);
//		genericMethods.waitForElementToLoad(homePage.usernameTextField, 60);
//	}
//
//	@Given("^user enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
//	public void user_enter_username_and_password(String username, String password) throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		genericMethods.enterText(homePage.usernameTextField, username);
//		genericMethods.enterText(homePage.passwordTextField, password);
//		Thread.sleep(500);
//
//	}
//
//	@Given("^submit on clicking in login button$")
//	public void submit_on_clicking_in_login_button() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		genericMethods.click(homePage.loginButton);
//	}
//
//	@Given("^user navigates to lobby page$")
//	public void user_navigates_to_lobby_page() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		genericMethods.waitForElementToLoad(lobbyPage.stage3Link, 90);
//
//	}
//
//	@Then("^user close the browser")
//	public void user_close_the_browser() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		webDriverManager.closeDriver();
//	}
//}
