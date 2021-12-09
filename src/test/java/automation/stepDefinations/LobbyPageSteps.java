package automation.stepDefinations;

import org.openqa.selenium.WebDriver;

import auotmation.pageObjects.LobbyPage;
import automation.helper.TestContext;
import cucumber.api.java.en.Given;

public class LobbyPageSteps {
	TestContext testContext;
	LobbyPage lobbyPage;
	WebDriver driver;

	public LobbyPageSteps(TestContext context) {
		testContext = context;
		lobbyPage = testContext.getPageObjectManager().getLobbyPage();
	}

	@Given("^user navigates to lobby page$")
	public void user_navigates_to_lobby_page() throws Throwable {
		driver = testContext.getWebDriverManager().getDriver();
		testContext.getGenericMethodsManager().getGenericMethods().waitForElementToLoad(lobbyPage.lobbyTabBar, 60);

	}

}
